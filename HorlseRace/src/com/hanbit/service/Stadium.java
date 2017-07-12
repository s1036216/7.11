package com.hanbit.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
		//System.out.println((i+1)+"등은"+Race.list.get(i));
			StringBuffer buff = new StringBuffer();
			buff.append((i+1)+"등은"+Race.list.get(i));
			 int lottoSerinalNo=(int)(Math.random()*99999+10000);
	            File output=new File("C:\\Users\\hb1001\\JavaProjects\\lottos"+lottoSerinalNo+".txt");// \\는 \t와 같다 총
	            FileWriter fw=null;;//객체 초기화는 null로 한다  마린
	            BufferedWriter bw=null;//객체 초기화는 null로 한다
	            String[] lottoPrint=buff.toString().split("/");
	            try {
	               bw = new BufferedWriter(new FileWriter(output));
	               for(String s:lottoPrint){
	                  s+=System.getProperty("line.separator");//System.getProperty("line.separator") 라인 대행의 의미 
	                  bw.write(s);
	               }
	            } catch (Exception e) {//try에서 오류가 생기면 exception으로 빠지게 한다
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            } finally {//finally를 걸지않으면 오류발생시 프로그램이 망가진다
	               try {
	                  bw.flush();//bw에 오류가나면 bw에 있는것을 비워버려라
	                  bw.close();//flush로 bw를 비운것을 뚜껑을 닫아라 의미
	               } catch (Exception e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	               }
	            }
	          
	            break; 
		}
	}
}
