package com.sist.main;
// => Thread 상속 => 상속이 안되는 클래스 => 윈도우
/*
 *   class Window extends JFrame implements Runnable // 상속을 윈도우로 받아야 한다(JFrame)
 *   {
 *   }
 *   
 *   ==> 두가지 일을 동시
 *       = IO (단방향) => 읽기/쓰기  
 *       = 클라이언트 => 본인이 동작 / 서벙에서 들어오는 값
 *                    ----------------------------
 *   
 */

class MyThread2 implements Runnable // 쓰레드가 아니라 쓰레드에 동작만 만들어 준다
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try
		 {
			 for(int i=1; i<=10; i++)
			 {
				 System.out.println(Thread.currentThread()+"i="+i); 
				 // currentThread() : 현재 동작하고 있는 쓰레드 이름
				 Thread.sleep(300);
			 }
		 }catch(Exception ex) {ex.printStackTrace();}
		 
	}                                  
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 t1 = new MyThread2();
		new Thread(t1).start(); // t1이 가지고 있는 run() 메소드를 호출하라
	}

}
