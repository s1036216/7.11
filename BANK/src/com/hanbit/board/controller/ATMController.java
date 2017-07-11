package com.hanbit.board.controller;

import com.hanbit.board.serviceImpl.ATMServiceImpl;

public class ATMController {
	public static void main(String[] args) {
		ATMServiceImpl.ATM atm=new ATMServiceImpl.ATM();
		Runnable kim=new ATMServiceImpl(atm,"김하윤"); //12 decorator : 장식 패턴
		Runnable byon=new ATMServiceImpl(atm,"변용주"); //상수풀에있따다
		Runnable cho=new ATMServiceImpl(atm,"조봉기");  //준비
		Thread th1=new Thread(kim);  //시작
		th1.start();
		Thread th2=new Thread(byon);
		th2.start();
		Thread th3=new Thread(cho);
		th3.start();
		
		
	}
}
