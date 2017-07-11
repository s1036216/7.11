package com.hanbit.service;

import com.hanbit.domain.Horse;
import com.hanbit.serviceImpl.Race;

public class Stadium {
	public static void main(String[] args) {
		Runnable target=new Race();
		Horse h1 = new Horse("1번말","조봉기");
		Horse h2 = new Horse("2번말","변용주");
		Horse h3 = new Horse("3번말","김하윤");
		Thread th1= new Thread(target,h1.getNumber()+h1.getName());
		Thread th2= new Thread(target,h2.getNumber()+h2.getName());
		Thread th3= new Thread(target,h3.getNumber()+h3.getName());
		th1.start();
		th2.start();
		th3.start();
		try{
			th1.join();
			th2.join();
			th3.join();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int i=0;i<Race.list.size();i++){
			System.out.println((i+1)+"등은"+Race.list.get(i));
		}
}
}
