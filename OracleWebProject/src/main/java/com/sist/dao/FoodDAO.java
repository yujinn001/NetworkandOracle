package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FoodDAO {
   // 연결객체
   private Connection conn;
   // sql문장 전송, 결과값 읽기
   private PreparedStatement ps;
   // 오라클 주소, 유저명, 비밀번호, 드라이버명 => final(상수)로 만들어야함 => 주로 xml, properties로 (web-inf)
   /////////////////////////////////////////////////> 경로 줄 때(\\ - 윈도우,/ - 맥)
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private final String DRIVER="oracle.jdbc.driver.OracleDriver";
   private final String USER="hr";
   private final String PWD="happy";
   //-----------------------------------------------------=오라클 정보
   
   // 드라이버 등록
   public FoodDAO() {
      // 생성자 - 한번만 등록하면 되는 것들(객체 생성 시 한번만 호출)
      //   ex) 자동 로그인, id저장
      try {
         // 등록 : Class.forName(), Properties이용
         Class.forName(DRIVER); // => DriverManager : 메모리 할당
         // 패키지명.클래스명을 등록 => 메모리 할당을 요청
         // MyBatis, Spring, Spring-Boot : 클래스 관리자 => 프로그래머들은 클래스 등록만 / 싱글턴
         // 스프링 => new를 사용하지 않는다 => 메모리 할당 => 어노테이션
         
         /*   annotation
          
             @Repository
             class A
             
             class B{
                @Autowired
                A a;
             }
             
          */
      }catch(Exception ex) {}
   }
   // 오라클 연결 => DBCP(연결하는걸 미리 만들어 놓고 시작)
   public void getConnection() {
      try {
         conn=DriverManager.getConnection(URL,USER,PWD);
      }catch(Exception ex) {}
   }
   // 오라클 닫기
   public void disConnection() {
      try {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
      }catch(Exception ex) {}
   }
   // 기능
   // 1. 목록 출력 
   public ArrayList<FoodVO> foodListData(int page){
	   ArrayList<FoodVO> list = new ArrayList<FoodVO>();
	   try
	   {
		   //1. 연결
		   getConnection();
		   //2. sql 문장 제작 => 인라인뷰
		   String sql ="SELECT fno, name,poster, score,num"
		   		+ " FROM (SELECT fno, name, poster, score,rownum as num "
		   		+ " FROM (SELECT /* + INDEX_ASC(food_location)*/ fno,name,poster, score "
		   		+ " FROM food_location))"
		   		+ " WHERE num BETWEEN ? AND ? ";
		   //3. 오라클로 전송
		   ps =conn.prepareStatement(sql);
		   //4. ?에 값을 채운다
		   int rowSize =20;
		   int start =(rowSize * page)-(rowSize-1); // rownum => 시작이 1이다!!
		   int end = rowSize*page;
		   /*
		    *  1page => 1~20
		    *  2page => 21~40
		    */
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   
		   // 4. 실행 요청
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   FoodVO vo = new FoodVO();
			   vo.setFno(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   // 포스터 쓰는 방법
			   vo.setPoster(rs.getString(3));
			   vo.setScore(rs.getDouble(4));
			   // vo = 맛집 정보
			   list.add(vo); // list안에 맛집 정소 20개를 추가
		   }
		   rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally
	   {
		   disConnection();
	   }
	   return list;
   }
}


























