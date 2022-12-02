package com.sist.main;
import java.sql.*;
public class MainClass_Oracle {
/*
    자바
    --- 최종 => 네트워크  /  데이터베이스 => 자바라이브러리(JDBC)  ,  외부라이브러리(MyBatis, JPA)
    
    bit > byte(8bit) => 한글자 > word(단어) > row(record) > table(구분되어 있다)
                                 ------------    -------- 2차원구조
                                      문장          파일
    
    오라클 명령어 (SQL)
    DQL  :  SELECT => 데이터를 검색
    DML  :  INSERT => 데이터 추가(회원가입 , 글쓰기, 댓글달기)
          UPDATE => 데이터 수정
          DELETE => 데이터 삭제
    ------------------------------------CURD(프로그래머)
    DDL  :   데이터 정의 언어
          => 데이터 저장 공간
          => 저장공간 수정
          => 저장공간 삭제
    ------------------------------------DBA
    DCL
    TCL
 */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
      // 드라이버등록(thin) => ojdbc8.jar
         Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 설치하는 실제 클래스 이름
         
      // 오라클 연결
         String url="jdbc:oracle:thin:@192.168.1.167:1521:XE"; // 자동설정
         /* 
             데이터베이스 : 폴더
             테이블 : 파일
             컬럼 : 클래스의 인스턴스변수
             ROW , RECORD : 객체 데이터
          */
         Connection conn=DriverManager.getConnection(url,"hr","happy"); // conn hr/happy => 오라클에 전송
         
         // SQL문장 전송
         String sql="SELECT ename,job,hiredate FROM emp";
         PreparedStatement ps=conn.prepareStatement(sql);//sql문장만 오라클로 전송
         ResultSet rs=ps.executeQuery();
      //  ---------
      //      실행결과
         
      // 실행결과 가져오기
         /*
             KING    PRESIDENT     81/11/17    7839
             String   String         Date       int
          */
         while(rs.next()) // 커서위치를 맨 위로 이동
         {
            System.out.println(rs.getString(1)+" "
                  +rs.getString(2)+" "
                  +rs.getDate(3).toString());
         }
      }catch(Exception ex) {ex.printStackTrace();}
   }

}