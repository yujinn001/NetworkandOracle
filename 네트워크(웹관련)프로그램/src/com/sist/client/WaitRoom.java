package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 *  클래스의 종류
 *  ----------
 *       1) 추상 클래스 : 미완성된 클래스
 *           public abstract class ClassName
 *           {
 *            ----------------------------
 *            인스턴스 변수 설정
 *            ----------------------------'
 *            구현된 메소드
 *            ----------------------------
 *            선언만된 메소드
 *            public abstract 리턴형 메소드(매개변수..);
 *            ----------------------------
 *           }
 *       2) 인터페이스 : 추상 클래스의 일종, 미완성된 클래스 => 클래스 여러개 묶어서 한개의 이름으로 사용
 *       ------------ java.sql => 데이터베이스 종류 (오라클, MySQL,MSSSQL,DB@)
 *       3) 내부 클래스
 *       = 멤버 변수 (클래스의 내용(변수, 메소등)을 공유) => static을 이용한다 => Thread, Window
 *       class A
 *       {
 *        	공유할 데이터
 *        고유할 메소드
 *        	class B
 *        	{
 *        	   A가 가지고 있는 모든 메소드, 변수를 사용이 가능(private 사용 가능)
 *        	}
 *       }
 *       
 *       4) 종단 클래스 => 사용자 정의는 거의 없다 => java.lang.*(종단 클래스)
 */
public class WaitRoom extends JPanel {
	// 내부 클래스
	JTable table1, table2;
	DefaultTableModel model1, model2;
	JTextArea ta;
	JTextField tf;
	JButton b1,b2,b3,b4,b5,b6;
	public WaitRoom()
	{
		// 초기화 
		// 익명의 클래스 => 상속없이 오버라이딩시에 사용
	}
}
