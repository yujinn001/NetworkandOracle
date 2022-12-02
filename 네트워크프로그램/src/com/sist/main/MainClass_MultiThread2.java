package com.sist.main;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 *   Button / Menu / JTextField(enter) => ActionListener
 *   JTree / JTable => Mouse
 */
public  class MainClass_MultiThread2 extends JFrame implements ActionListener {
	JTextArea my,thread; //여기서 입력을 하고                     // button 누를 때 처리하는 메소드
	JButton b; // 버튼을 누른다
	MyThread3 t;
	// ==> 동시 작업 (읽기/쓰기) , 실시간 => 쓰레드 : Ajax, VueJS, ReactJS
	public MainClass_MultiThread2()
	{
		my = new JTextArea();
		JScrollPane js1= new JScrollPane(my); // 스크롤바
		thread = new JTextArea();
		thread.setEditable(false); // 비활성화
		JScrollPane js2 = new JScrollPane(thread);
		b = new JButton("저장");
		
		setLayout(null); // 사용자 지정
		js1.setBounds(10,15,300,420);
		js2.setBounds(320,15,300,420);
		b.setBounds(10,450,100,30);
		
		// 윈도우에 추가
		add(js1);add(js2);
		add(b);
		
		setSize(650, 520);
		setVisible(true);	
		
		b.addActionListener(this);
		
		t= new MyThread3();
		t.start();
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass_MultiThread2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==b) // 버튼 클릭시 처리
		{
			try
			{// 입력값 읽기
				String msg = my.getText();
				if(msg.trim().length()<1)
				{
					JOptionPane.showMessageDialog(this, "데이터를 입력하세요");
					my.requestFocus();
					return;
				}
				FileWriter fw = new FileWriter("C:\\java_data\\chat.txt",true);
				fw.write(msg);
				fw.close();
				
				t= new MyThread3(); // 읽기 => 출력 ==> 입출력
				t.start();
			}catch(Exception ex) {}
		}
	}
	// 클래스와 클래스끼리 ==>데이터 공유
	// 파일 읽기만 담당
	class MyThread3  extends Thread
	{
		public void run() // run()에서 작업 => 파일을 읽어서 textarea에 출력
		{
			try
			{
				FileReader fr = new FileReader("c:\\java_data\\chat.txt");
				int i =0;
				String msg ="";
				while((i=fr.read())!=-1)
				{
					msg +=String .valueOf((char)i);
				}
				fr.close();
				// 윈도우에 출력
				thread.setText(msg);
				
				t.interrupt();//Thread 종료
						 
			}catch(Exception ex) {}
		}
	}

}
