package com.hanbit.serviceImpl;

import com.hanbit.service.LottoService;
import com.hanbiy.domain.LottoBean;

public class LottoServiceImpl implements LottoService {
	int [][] lottos;
	int [] lotto; //돈과 상관없이 생성되는 한줄 (6)로또
	private int count;

	@Override
	public void setCount(LottoBean bean) {
		//// 몇줄로 출력 할것인지 로또 수계산 (최대 5줄)
		int x=bean.getMoney()/1000;
		this.count=(x>=5)?x=5:bean.getMoney()/1000;
		
		}
		
	
	@Override
	public int getCount() {
		//해당로또수만큼 출력
		
		
		return count;
	}
	@Override
	public void setLottos(LottoBean bean) {
		setCount(bean);
		lottos=new int[count][6];
		for(int i=0;i<lottos.length;i++){
			for(int j=0;j<lottos[i].length;j++){
			
				lottos[i][j]=bean.getNumber();
			
			}
			}
		//....
		//로또 만들기
		
	}
	@Override
	public int[][] getLottos() {
		// 만든로또 만들기
		
		return lottos;
	}

	 public boolean isDuplication(int count, int num) {
	      //중복된 번호인지 체크(중복이면 true 리턴)
	      boolean flag = false;
	      for(int i=0; i<lottos[count].length; i++){
	    	  if(lottos[count][i] == num){
	    		  flag = true;
	    	  }
	      }
	      return flag;
	   }
	@Override
	public void sort(int[] arr) {
		 sort(

	    return;
		
	}

	

	

}
