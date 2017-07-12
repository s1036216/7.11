package com.hanbit.serviceImpl;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Race implements Runnable {
	public static List<String> list= new Vector<>();

	@Override
	public void run() {
		Random ran= new Random();//렌덤클래스
		for(int i=0;i<11;i++){
			//this (이클래스의 객체)를 대상으로 동기화를 건다.
			//synchronized가 한개의 Thread만 허용한다
			synchronized (this) {
				String name=Thread.currentThread().getName();
				System.out.println(name+"라인"+(i*100)+"m 통과!!!");
				if(i*100==1000){
					list.add(name);
				}
			}
		try{
			Thread.sleep(ran.nextInt(3000));
		}catch (Exception e){
			e.printStackTrace();
		}
		}
				
	}
	
}
