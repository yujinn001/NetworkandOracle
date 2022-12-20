package com.sist.dao;
import java.util.*;
import java.sql.*;

public class SeoulDAO {
	// 연결객체
	private Connection conn;
	// sql문장 전송 , 결과값 읽기
	private PreparedStatement ps;
	// 오라클 주소, 유저명, 비밀번호, 드라이브명 => final = xml,propertie => WEB-INF
	//                                  경로 =>  \\ (맥?), / (윈도우)
	private final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
	private final String Driver ="oracle.jdbc.driver.OracleDriver";
	private final String USER ="hr";
	private final String PWD ="happy";
	
	//드라이버 등록
	public SeoulDAO() // 생성자에서 처리하는 이유 : 한번만 등록이 가능 => 객체 생성시 한번만 호출 : 자동 로그인, ID저장
	{
		try
		{
			// 등록 => Class.forName() ,Properties이용
			Class.forName(Driver); //DriverManager => 메모리 할당
			// 패키지명.클래스명을 등록 => 메모리 할당을 요청
			// => MyBaris , Spring , Spring - Boot : 클래스 관리자 => 등록 => 싱글톤
			// 스프링 => new 사용하지 않는다 => 메모리 할당 => 어노테이션
			/*
			 *  @Repository
			 *  class A
			 *  
			 *  classB
			 *  {
			 *     @Autowired
			 *     A a;
			 *  }
			 *  프레임워크 => 클래스 분석 
			 */
		}catch(Exception ex) {}
	}
	// 오라클 연결
	public void getConnection() {
		try
		{
			conn = DriverManager.getConnection(URL,USER, PWD);
		}catch(Exception ex) {}
	}
	// 오라클 닫기
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex) {}
	}
	// 기능 설정
	// VO, DAO => 테이블 한개에 대한 기능
	public ArrayList<SeoulVO> seoulListData(int type)
	{
		String[] table_name= {"","seoul_location","seoul_nature","seoul_shop"};
		ArrayList<SeoulVO> list =new ArrayList<SeoulVO>();
		try
		{
			//1.연결
			getConnection();
			//2. sql문장 전송
			String sql ="SELECT no,title FROM "+table_name[type]
					+" ORDER BY no ASC";
			ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SeoulVO vo = new SeoulVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				list.add(vo);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
		return list;
	}
	// DAO, DAO => Service
}


























