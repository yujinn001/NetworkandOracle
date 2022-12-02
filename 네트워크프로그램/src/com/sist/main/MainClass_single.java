package com.sist.main;
/*
 *  -----------|------| => 동기화 (싱글 쓰레드) ==> 단점(A가 멈추면 B는 수행 불가능)
 *       A        B                             => 데드락 / 스타베이션 => 예외처리
 *                                              => 이더넷 (순서가 없다) => 가격이 싸다
 *  ------------------ => 비동기화 (멀티 쓰레드)
 *     A    A   A
 *        B   B   B....
 */
public class MainClass_single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); // 시간이 얼마나 걸리는 지 확인
		
		for(int i =0; i<100; i++)
		{
			System.out.print("★");
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (end-start));
		
		for(int i =0; i<100; i++)
		{
			System.out.print("☆");
		}
		end = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (end-start));
	}

}
