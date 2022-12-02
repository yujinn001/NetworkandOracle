package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
/*
 *   class ChatServer
 *   {
 *       Client의 정보를 저장 ==> IP, PORT
 *       ------------------------------- 접속시 마다 저장 (담당)
 *       
 *       -------------------------------
 *        class Client extends Thread ==> 접속자마다 통신을 담당하는 쓰레드가 필요!!
 *        {
 *           통신만 담당
 *        }
 *        
 *       -------------------------------
 *   }
 *   내부 클래스 : 쓰레드, 네트워크 => 공유하는 데이터가 많다  ==> 멤버 클래스를 이용해서 공유!
 *    = 멤버 클래스
 *      class A
 *      {
 *        class B
 *        {
 *           A가 가지고 있는 모든 데이터 공유할 목적
 *        }
 *      }
 *    = 익명의 클래스 : 상속 없이 오버라이딩을 할 때 사용
 */
// 접속시에 클라이언트 정보 저장 ==> 교환 소켓
public class ChatServer implements Runnable{
	// 클라이언트 정보 저장
	private Vector<Client> waitVc = new Vector<Client>();
	// 서버 가동
	private ServerSocket ss; // 교환 소켓 => 접속시에만 처리
	// 서버는 PORT가 고정, 고정 IP
	private final static int PORT=3355; // 전화선 (연결 번호)
	//0-65335
	/*
	 *  0-1023번 알려진 포트 => 사용금지
	 *    = FTP  ==> 21
	 *    = SMTP ==> 25
	 *    = HTTP ==> 80
	 *    = Telnet ==> 23
	 *       P => 프로토콜(약속)
	 *  1521 : 오라클 사용
	 *  3306 : MYSQL
	 *  3000 : React
	 *  8080 : 스프링
	 *  ================== 음성 : 20000번대
	 *                     화상 : 30000번대
	 */
	public ChatServer()
	{
		try
		{
			// 서버는 두번 실행하면 안된다 (한번만 실행이 가능) => 그래도 사용해야 할 경우 PORT를 변경해서 사용한다
			/*
			 *  서버
			 *    P2P : Client 프로그램  서버를 작동 ==> 게임
			 */
			ss = new ServerSocket(PORT); // 단점) 50명까지 접근 => 인트라넷 (사내)
			//new ServerSocket(PORT, 1000(접근 가능수))
			System.out.println("Server Start...");			
			// bind(IP, PORT) : 개통 , listen() : 대기
		}catch(Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}
	public void run() // 접속시에 정보를 저장
	{
		try
		{
			while(true)
			{
				// 서버 => client정보를 가지고 있어야 한다
				Socket client =ss.accept(); // 클라이언트가 접속했을 경우에만 호출 (특수 메소드) => 접속한 클라이언트에 정보를 가지고 온다.
							 // 발신자 전화번호 // ss.accept()로 IP를 받는다
				 		     // IP와 PORT를 가지고 있는 클래스 => Socket
				//System.out.println("접속한 클라이언트 IP : "+client.getInetAddress().getHostAddress());//getInetAddress() : 인터넷
				//System.out.println("접속한 클라이언트 PORT : "+client.getPort());
				// 서버 => 고정 PORT, 클라이언트는 자동 PORT
				Client c = new Client(client);
				waitVc.add(c);
				c.start();
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatServer server = new ChatServer();
		new Thread(server).start();
	}
	// 통신 => 사용자 요청 받기 , 사용자 요청 처리 후에 응답 
	// ==> 통신 소켓 ==> 접속자 마다 생성을 해야 한다 ==> 접속자마다 따로 통신을 수행
	class Client extends  Thread
	{
		private Socket s; // 클라이언트 연결 소켓(역할:쓰레드가 담당하는 클라이언트의 정보를 가지고 있다)
		private OutputStream out; // 클라이언트로 값을 전송
		private BufferedReader in; // 클라이언트로부터 요청 값을 받을 경우에 사용
		
		public Client(Socket  s)
		{
			try
			{
				this.s=s;
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// socket클라이언트의 컴퓨터
				out = s.getOutputStream(); // 서버에 저장 => 클라이언트에서 읽어 간다
				// 메모리에 저장 => 저장된 위치로부터 클라이언트가 읽어 간다 => 신뢰성이 뛰어나다 (TCP)
			}catch(Exception ex) {}
		}
		public void run()
		{
			try
			{
				while(true)
				{
					// 클라이언트로부터 요청값 받기
					String msg = in.readLine();// in=> 클라인언트가 저장해둔 메모리
					System.out.println("Client가 전송한 값 : "+msg);
					// 접속 한 모든 클라이언트로 데이터 전송
					for(Client c: waitVc)
					{
						c.out.write((msg+"\n").getBytes());
						// 반드시 \n을 추가한다
					}
				}
			}catch(Exception ex) {}
		
	   }
	
	}
}
