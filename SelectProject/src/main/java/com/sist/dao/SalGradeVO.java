package com.sist.dao;

public class SalGradeVO {
	private int grade, losal, hisal;
//  오라클에서 받는 데이터를 VO로!
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getLosal() {
		return losal;
	}

	public void setLosal(int losal) {
		this.losal = losal;
	}

	public int getHisal() {
		return hisal;
	}

	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
	
}
