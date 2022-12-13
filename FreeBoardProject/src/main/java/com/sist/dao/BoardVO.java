package com.sist.dao;
/*
    VO :  값 오브젝트로써 값을 위해 쓰인다
    
		  이름      널?       유형             
		------- -------- -------------- 
		NO      NOT NULL NUMBER         
		NAME    NOT NULL VARCHAR2(34)   
		SUBJECT NOT NULL VARCHAR2(4000) 
		CONTENT NOT NULL CLOB           
		PWD     NOT NULL VARCHAR2(10)   
		REGDATE          DATE           
		HIT              NUMBER         
		
			(오라클)  ==>  (자바)
			TO_CHAR  ==> String
			TO_INT  ==>  int
			TO_DATE ==> Date
 */
import java.util.*;
public class BoardVO {
	private int no, hit;
	private String name,subject,content,pwd, dbday; 
	//dbday변수는 날짜를 변환해서 가져올 변수 (오라클) TO_CHAR => (자바) => String
	
	private Date regdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
