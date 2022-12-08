package com.sist.dao;

import java.util.*;
// DESC table; => 정보를 확인하고 만든다 => 컬럼명과 변수의 일치

// VO => value Object => 오라클에서 가지고 오는 데이터를 저장할 목적으로 만든다
public class EmpVO {
	private int empno, mgr, sal,comm,deptno;
	private String ename,job;
	private Date hiredate;
	private DeptVO dvo = new DeptVO(); // JOIN => 자바 (포함 클래스)
	private SalGradeVO svo = new SalGradeVO();// JOIN => 자바 (포함 클래스)
			
	
	public SalGradeVO getSvo() {
		return svo;
	}
	public void setSvo(SalGradeVO svo) {
		this.svo = svo;
	}
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	// getter, setter을 해줘야 데이터를 사용할 수 있다
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgt) {
		this.mgr = mgt;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
