package com.sist.dao;
// 오라클 연결
// 데이터를 가져오는 위치
import java.util.*; //ArrayList => 데이터 묶어준다 (table)

import javax.management.monitor.MonitorSettingException;

/*
 *  Location VO
 *   -----------------------
 *    => 오라클에 저장 (한개 명소에 대한 저장) => new LocationVO()
 *   -----------------------
 *   => 오라클에 저장 (한개 명소에 대한 저장)
 *   -----------------------
 *   => 오라클에 저장 (한개 명소에 대한 저장)
 *   -----------------------
 */
import java.sql.*; // 오라클 연결 => 송수신(SQL전송, 데이터 수신)
public class LocationDAO {
	// 데이터 베이스 연결 객체
	private Connection conn;
	// 데이터 베이스 송수신이 가능
	private PreparedStatement ps; //PreparedStatement을 통해서 받아온다
	// SQL 문장 => 전송, 데이터 받기 
	private final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
	// 드라이버 등록
	public LocationDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 닫기
	public void disConneciton()
	{
		try
		{
			if(ps!=null)ps.close();
			if(conn!= null)conn.close();
		}catch(Exception ex)
		{}
	}
	// ------------------------------ 모든 DAO 동일
	// 기능 (SQL문장)
	public ArrayList<LocationVO> locationListData()
	{
		ArrayList<LocationVO> list = new ArrayList<LocationVO>();
		try
		{
			// 1. 연결
			getConnection();
			// 2. SQL문장
			String sql ="SELECT no,title,poster,msg,rownum "
					+ "FROM seoul_location "
					+ "WHERE no BETWEEN 1 AND 20";
			// 3. 오라클 전송
			ps=conn.prepareStatement(sql);
			// 4. 결과값 읽기
			ResultSet rs = ps.executeQuery(); // rs안에 결과값이 저장됨
			// 5.  결과값을 ArrayList에 담는다 => 브라우저 읽어서 출력
			while(rs.next())
			{
				LocationVO vo = new LocationVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setMsg(rs.getString(4));
				list.add(vo); //추출된 데이터를 모은다
				
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConneciton();
		}
		return list;
	}
	public ArrayList<ZipcodeVO> postFind()
	{
		  ArrayList<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		 {
			try
			{
				getConnection(); 
				String sql ="SELECT zipocode, sido, gugun,NVL(bungi,' ') FROM zipcode";
				ps= conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				
				while(rs.next())
				{
					ZipcodeVO vo= new ZipcodeVO();
					vo.setZipcode(rs.getString(1));
					vo.setSido(rs.getString(2));
					vo.setGugun(rs.getString(3));
					vo.setDong(rs.getString(4));
					vo.setBunji(rs.getString(5));
					list.add(vo);
				}
				
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
			disConneciton();
			}
		 return list;
				
		}
	}	
	
}
