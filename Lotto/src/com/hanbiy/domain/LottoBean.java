package com.hanbiy.domain;

import java.io.Serializable;

public class LottoBean{
	private int money;
	private int num;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		
		this.money = money;
	}
	public int getNumber() {
		setNumber();
		return num;
	}
	public void setNumber() {
		this.num = (int)(Math.random()*45+1);
	}
}
