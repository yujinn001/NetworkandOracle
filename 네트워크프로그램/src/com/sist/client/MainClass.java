package com.sist.client;
import java.net.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 서버IP를 가지고 있어야 한다
			Socket s= 
					new Socket("localhost",3355); // 서버주소, 서버 PORT
		}catch(Exception ex) {}
	}
	

}
