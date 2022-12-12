package com.sist.dao;
/* 
 *  	오라클 데이터형
 *   	문자형
 *        CHAAR(1~2000byte) => 고정 메모리
 *        varchar2(1~4000byte) => 가변메모리 (입력된 글자수만큼)
 *        CLOB(4기가) => 가변 메모리
 *        --------------------------------------------- 자바 (String)
 *     숫자형
 *     	 NUMBER(4) => int
 *       NUMBER(8,2) => double
 *     날짜형
 *       DATE => java.io.InputStream
 *     기타형
 *       BLOB/BFILE => java.io.InpitStream
 */
import java.util.*;
import java.sql.*;
// util, sql 둘다 DATE가 있어서 어디서 사용할지 써준다

public class StudentVO {
	private int hakbun;
	private String name;
	private int kor, eng,math;
	private java.util.Date date;
}
