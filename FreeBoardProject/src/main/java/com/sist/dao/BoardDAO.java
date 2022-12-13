package com.sist.dao;
// 오라클 연결
import java.util.*;
import java.sql.*;

public class BoardDAO {
	private Connection conn;
	// sql 문장 전송 객체
	private PreparedStatement ps;
	private final String URL="jdbc.oracle.thin:@localhost:1521:XE";
	                             // 업체. 연결.
	// 드라이버 등록
	public BoardDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 연결
	public void getConnetion()
	{
		try
		{
			conn =DriverManager.getConnection(URL,"hr","happy");
		}
		catch(Exception ex) {}
	}
	// 해제
	public void disConnection()
	{
		try
		{ // 증거 제시 => 포트 폴리어 
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();		
		}catch(Exception ex) {}
	}
	
	// 기능 => CURD 프로그램
	// 페이징(X) ==> 이미지 (맛집 => 댓글)
	// 1. 목록 출력 ==> SELECT (ORDER BY) // 목록이여서 여러개를 한번에 묶어줘야해서 ArrayList를 사용한다
	public ArrayList<BoardVO> boardListData()
	{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try
		{
			//1. 연결
			getConnetion(); // 메소드는 한개의 기능(재사용), 반복적인 구간
			//2. sql문장 제작
			String sql ="SELECT no, subject, name, TO_CHAR(regdate, 'YYYY/MM/DD'), hit  "
					+ "FROM freeboard "
					+ "ORDER BY no DESC";
			//3. 오라클 서버로 전송
			ps =conn.prepareStatement(sql); //conn => 오라클이라고 생각하면 된다
			//4. 결과값 받아오기
			ResultSet rs =ps.executeQuery(); // ResultSet => 저장 공간 
			//5. 결과값 ArrayList에 담아준다
			// 오라클에 저장된 데이터는 자동 정렬이 된 상태가 아니다
			while(rs.next()) // 메모리에 출력된 첫번째 위치에 커서를 이동한다
			// next() => 한줄씩 읽기 때문에 순설르 잘 작성해 줘야 한다
			{
				
				BoardVO vo =new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);				
			}
			rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
	// 2. 게시물 추가 ==> INSERT
	
	
	// 3. 상세보기 ==> SELECT (WHERE) => vo에 묶어서 보여줘야한다
	public BoardVO boardDeatailData(int no) 
	// 사용자가 게시물 번호를 보내줘야 그 번호에 해당되는 상세를 보여준다
	// 사용자는 게시물 번호를 알지 못해 우리가 추가를 해줘야 한다 
	// no가 게시물 번호 => 사용자로부터 받아서 데이터를 넘겨준다 
	// detail을 하게 되면 Primary key를 이용해서 프로그램을 만들어야 한다
	{
		BoardVO vo =new BoardVO();
		try
		{
			//1. 연결
			getConnetion();
			//2. 전송할  sql문장 제
			String sql = "UPDATE freeboard SET "
					+ "hit = hit+1 "
					+ "WHERE no = "+no;
			//3. 전송 객체
			ps = conn.prepareStatement(sql);
			//4. 실행 (UPDATE해서 받을 값이 없다)
			ps.executeUpdate(); // 실행 => commit()
			
			//5. 전송할 SQL문장을 제작
			sql="SELECT no, name, subject,content,regdate,hit "
					+ "FROM freeboard "
					+ "WHERE no="+no;
			// 6. 오라클에 다시 전송
			ps = conn.prepareStatement(sql);
			//7. 실행 후 결과값 읽기
			ResultSet rs = ps.executeQuery();
			//8. 커서의 위치 이동 
			//=> 상세보기는 한개만 출력하기 때문에 while문을 사용하지 않아도 된다
			rs.next();
			//9. VO에 값을 채운다 
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));			
			rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
	//-----------------------------------
	// 4. 수정 ==> UPDATE
	// 5. 삭제 ==> DELETE
	//----------------------------------- 본인 여부 확인 (비밀번호 비교)
	// 6. 검색 ==> SELECT (LIKE)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
}
