package com.sist.main;
/*
 *      생성                                     대기               동작           일시정지
 *   Thread t1 = new Thread()             사용할 데이터를 수집        run()          sleep()
 *   JVM역할                                 t1.start()         ===========       wait()
 *   = Thread 이름 부여                                            재정의(동작 설정 방법)
 *     Thread - 0
 *     Thread - 1
 *     setName("")
 *      => 이름 변경이 가능
 *   = 순서를 부여
 *     0~10 => 10번이 가능 빠르다
 *     MIN_PRIORITY(0) => gc()
 *     NORM_PRIORITY(5) => 사용자 정의 쓰레드
 *     MAX_PRIORITY(10) => main
 *     setPriority() => 설정
 *           
 *                                          쓰레드 제거(종료) => interrupt(), join()
 *      = 생성 방법 
 *       = Thread를 상속 ===> 네트워크 
 *         class
 *         class MyThread extends Thread
 *         {
 *            public void run()
 *            {
 *               동작에 관련된 소스 코딩 
 *            }
 *         }
 *     = Runable을 구현하는 방식 => 윈도우
 *       인터페이스
 *       class MyThread implements Runnable
 *       {
 *       		public void run()
 *       		{
 *       			 작업 내용
 *       		}
 *       }
 *       
 *       run()를 호출하지 않는다 => start() 호출
 *       void start()
 *       {
 *         run()
 *       }
 */
class MyThread extends Thread // 상속받아서 처리하는 방식
{
	public void run() //동작 내용 정의
	{
	 try
	 {
		 for(int i =1; i<=10; i++)
		 {
			 System.out.println(getName()+":"+i);
			 Thread.sleep(100); // 1/1000
		 }
	 }catch(InterruptedException ex) {} // 쓰레드는 CheckedException => 반드시 예외처리 필요
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyThread t1 = new MyThread();
		 t1.setName("홍길동");
		 t1.setPriority(Thread.NORM_PRIORITY);
		 MyThread t2 = new MyThread();
		 t2.setName("심청이");
		 t2.setPriority(Thread.MIN_PRIORITY);
		 MyThread t3 = new MyThread();
		 t3.setName("이순신");
		 t3.setPriority(Thread.MAX_PRIORITY);
		 System.out.println("t1-이름 : "+t1.getName()+", 우선순위 : "+t1.getPriority());
		 System.out.println("t2-이름 : "+t2.getName()+", 우선순위 : "+t2.getPriority());
		 System.out.println("t3-이름 : "+t3.getName()+", 우선순위 : "+t3.getPriority());
		 System.out.println("====동작====");
		 t1.start();
		 t2.start();
		 t3.start();
	}

}
