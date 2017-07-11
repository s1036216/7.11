package com.hanbit.board.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import com.hanbit.board.domain.AcountBean;
import com.hanbit.board.service.AcountService;

public class AcountServiceImp implements AcountService  {
	Vector<AcountBean> vec;
	AcountBean account;
	public AcountServiceImp(){ 
		vec=new Vector<>(10,10);
		account=new AcountBean();
		
	}
	@Override
	public void AcountCreate(AcountBean bean) {
		// 계좌계설
	 	int random=(int)(Math.random()*99999999+10000000);
		bean.setAcountNo(random);
		
		Calendar now=Calendar.getInstance();
		
		int yy=now.get(now.YEAR);
		int mm=now.get(now.MONTH)+1;
		int dd=now.get(now.DAY_OF_MONTH);
		
		String todaytime=yy+"년"+mm+"월"+dd+"일";
		bean.setDate(todaytime);
		
		
		vec.add(bean);
				
	}

	@Override
	public Vector<AcountBean> list() {
		//계좌 전체목록
		System.out.println("====list: "+vec.toString());
		return vec;
	}

	@Override
	public Vector<AcountBean> findByName(String name) {
		// 이름으로 검색(동명이인허용)
		
		Vector<AcountBean> temp=new Vector<AcountBean>(10,10);
		for(int i=0;i<vec.size();i++){
			if (name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));  //생각
			}
		}
		return temp;
	}

	@Override
	public AcountBean findByNum(int acountNo) {
		account=new AcountBean();
		for(int i=0;i<vec.size();i++){
			if(acountNo==vec.get(i).getAcountNo()){
				account=vec.get(i); 
				break;
			}
		}
		return  account;
	}
	@Override
	public int Count() {
		// 전체계좌수
		return vec.size();
	}
	@Override
	public void updatePass(AcountBean bean) {
		// 비번변경\
		for(int i=0;i<vec.size();i++){
			if(bean.getAcountNo()==vec.get(i).getAcountNo()){
				vec.get(i).setPass(bean.getPass());		
				break;
			}
		}
	}
	@Override
	public void updateIb(AcountBean bean) {
		// 예금입금
		for(int i=0;i<vec.size();i++){
			if(bean.getAcountNo()==vec.get(i).getAcountNo()){
				vec.get(i).setMoney(vec.get(i).getMoney()+bean.getMoney());		
				break;
			}
		}
	}
	@Override
	public void updatecul(AcountBean bean) {
		// 출금

		for(int i=0;i<vec.size();i++){
			if(bean.getAcountNo()==vec.get(i).getAcountNo()){
				vec.get(i).setMoney(vec.get(i).getMoney()-bean.getMoney());		
				break;
			}
	  }
	}	
	@Override
	public void Delete(String acountNo) {
		// 계좌혜지
	}
	@Override
	public String check(AcountBean bean) {
		// TODO Auto-generated method stub
		String check="";
		for(int i=0;i<vec.size();i++){
			if(bean.getAcountNo()==vec.get(i).getAcountNo()){
			if(bean.getMoney()>=vec.get(i).getMoney()){
				updatecul(bean);
				check="출금완료"+vec.get(i).getMoney();
		}else{
			check="출금가능합니다";
		}
		}
		}
		return check;
	}
}
	
