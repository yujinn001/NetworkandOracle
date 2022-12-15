package com.sist.dao;
// VO 는 따로 제작

import java.util.*; // 데이터를 모아서 넘겨줄때 => ArrayList
import java.util.Date;
import javax.xml.crypto.Data;

/*
 *  ROW 한개 (ROW => BookVO)
 *  ROW 여러개 ==> ArrayList
 */
/*
 *    1. 드라이버 등록 : Class.forName()
 *    2. 연결 : DriverManager.getConnection(URL,"username","pwd")
 *    3. sql문장을 만든다
 *    4. 오라클로 전송 : conn.preparedStatement(sql)
 *    5. 결과값 읽기
 *        1) 결과값이 있는 경우 (SELECT)    ----------------> execyteQuery()
 *        2) 결과값이 없는 경우 (INSERT, UPDATE, DELETE) ---> executeUpdate() => 포함 COMMIT 
 *        => 저장되는 메모리 : ResultSet (결과값 설정)
 *           ResultSet rs= ps.executeQuery()
 *           
 *           --------------------------
 *    
 */
import java.sql.*;
public class BookDAO {
	private Connection conn; // 오라클 연결 객체
	private PreparedStatement ps; //송수신 객체 (SQL전송, 결과값 받기
	private final String URL  ="jdbc:oracle:thin:@localhost:1521:XE";
	
	//1. 드라이버 등록 (한번만 수행)
	public BookDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	//2. 오라클 연결 (반복) 
	public void getConnection()
	{
		try
		{
			conn= DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex){}

	}
	
	//3. 오라클 연결 종료 (반복)
	public void disConnection()
	{
		try
		{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex){}
	}
	
	/*
	 * 
	  ArrayList<BookVO> list = new ArrayList<BookVO>();
		try
		{
			//1. 연결
			//2.sql문장 제작
			//3. 오라클 전송
			//4. 결과값을 가지고 온다
			//5. arrayList값을 추가
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
	*/
	// 기능 수행
	// 3-1문제 
	// => 자바와 오라클 연동 (70%) / html 출력 => 웹 프로그래머 (30%)
	//  [질의 3-1] 모든 도서의 이름과 가격을 검색하시오. BookVO => 도서 정보 1개
	public ArrayList<BookVO> book3_1()
	{
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try
		{
			//1. 연결
			getConnection();
			//2.sql문장 제작
			String sql ="SELECT bookname, price FROM book";
			//3. 오라클 전송
			ps =conn.prepareStatement(sql);
			//4. 결과값을 가지고 온다
			ResultSet rs =ps.executeQuery();
			//5. arrayList값을 추가
			while(rs.next())
			{
				BookVO vo = new BookVO();
				vo.setBookname(rs.getString(1));
				vo.setPrice(rs.getInt(2));
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

	// [질의 3-2] 모든 도서의 도서번호, 도서이름, 출판사, 가격을 검색하시오.
	public ArrayList<BookVO> book3_2()
	{
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try
		{
			//1. 연결
			getConnection();
			//2.sql문장 제작
			String sql = "SELECT bookid,bookname, publisher, price FROM book ";
			//3. 오라클 전송
			ps =conn.prepareStatement(sql);
			//4. 결과값을 가지고 온다
			ResultSet rs = ps.executeQuery();		
			//5. arrayList값을 추가
			while(rs.next())
			{
				BookVO vo = new BookVO();
				vo.setBookid(rs.getInt(1));
				vo.setBookname(rs.getString(2));
				vo.setPublisher(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				
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

	//  [질의 3-3] 도서 테이블에 있는 모든 출판사를 검색하시오.
	// 컬럼이 여러개 => VO
	// 컬럼이 한개 => 해당 데이터
	
	// 중복제거 distinct 
	// 문자열 결합 ㅣ|
	// 별칭
	public ArrayList<String> book3_3()
	{
		  ArrayList<String> list = new ArrayList<String>();
			try
			{
				//1. 연결
				getConnection();
				//2.sql문장 제작
				String sql =" SELECT DISTINCT publisher FROM book";
				
				//3. 오라클 전송
				ps =conn.prepareStatement(sql);
				
				//4. 결과값을 가지고 온다
				ResultSet rs = ps.executeQuery();
				
				//5. arrayList값을 추가
				while(rs.next())
				{
					BookVO vo = new BookVO();
					vo.setPublisher(rs.getString(1));
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
	
	// [질의 3-4] 가격이 20,000원 미만인 도서를 검색하시오.
	public ArrayList<BookVO > book3_4()
	{
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try
		{
			//1. 연결
			getConnection();
			//2.sql문장 제작
			String sql ="SELECT * FROM book WHERE price <2000";
			//3. 오라클 전송
			ps =conn.prepareStatement(sql);

			//4. 결과값을 가지고 온다
			ResultSet rs =ps.executeQuery();
			
			
			//5. arrayList값을 추가
			while(rs.next())
			{
				BookVO vo = new BookVO();
				vo.setBookid(rs.getInt(1));
				vo.setBookname(rs.getString(2));
				vo.setPublisher(rs.getString(3));
				vo.setPrice(rs.getInt(4));
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
	//JOIN
	//[질의 3-21] 고객과 고객의 주문에 관한 데이터를 모두 보이시오.
	public ArrayList<CustomerVO> book3_21()
	{
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		try
		{
			//1. 연결
			getConnection();
			//2.sql문장 제작
			String sql ="SELECT  name,address,phone,bookid,saleprice, orderdate FROM customer, orders "
					+ "  WHERE customer.custid =orders.custid "
					+"  order by  customer.custid";
			//3. 오라클 전송
			ps =conn.prepareStatement(sql);

			//4. 결과값을 가지고 온다
			ResultSet rs =ps.executeQuery();
			
			
			//5. arrayList값을 추가
			while(rs.next())
			{
				CustomerVO vo = new CustomerVO();

				vo.setName(rs.getString(1));
				vo.setAddress(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.getOvo().setBookid(rs.getInt(4));
				vo.getOvo().setSaleprice(rs.getInt(5));
				vo.getOvo().setOrderdate(rs.getDate(6));
							
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
} 
	










































