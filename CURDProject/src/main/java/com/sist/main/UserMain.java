package com.sist.main;

import java.util.*;


import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import com.sist.dao.StudentDAO;
import com.sist.dao.StudentVO;

import java.sql.*;

public class UserMain {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StudentVO vo = new StudentVO(); // 데이터
		
		System.out.print("이름 입력 :");
		vo.setName(sc.next());
		System.out.print("국어 입력 :");
		vo.setKor(sc.nextInt());
		System.out.print("영어 입력 :");
		vo.setEng(sc.nextInt());
		System.out.print("수학 입력 :");
		vo.setMath(sc.nextInt());
		
		StudentDAO dao = new StudentDAO();
		dao.studentInsert(vo);
		System.out.println("저장 완료!!");
		
		ArrayList<StudentVO> list = dao.studentListData();
		for(StudentVO svo : list)
		{
			System.out.println(svo.getHakbun()+" "
					+svo.getName() +" "
					+svo.getKor()+" "
					+svo.getMath()+" "
					+svo.getEng()+" "
					+svo.getTotal()+" "
					+svo.getAvg());
		}
	}
}
