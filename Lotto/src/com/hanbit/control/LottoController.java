package com.hanbit.control;

import java.util.Random;

import javax.swing.JOptionPane;

import com.hanbit.service.LottoService;
import com.hanbit.serviceImpl.LottoServiceImpl;
import com.hanbiy.domain.LottoBean;

/*
 * 얼마치구입하십니까?
 * 5200
 * 1 2 3 4 6 8
 * 2 32
 * 1
 * 2
 * 2
 * 
 */
public class LottoController {
	public static void main(String[] args) {
		Random ran=new Random();
		LottoBean bean=new LottoBean();
		LottoService service=new LottoServiceImpl();	
		while(true){
				switch(JOptionPane.showInputDialog("0.종료 1.구입금액")){
				case "0":
					return;
				case "1":
					bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("금액")));
					service.setLottos(bean);
					int [][] lottos=service.getLottos();
					for(int i=0;i<lottos.length;i++){
						for(int j=0;j<lottos[i].length;j++){
							System.out.print(lottos[i][j]+"\t");
						}
						System.out.println();
					}
					break;
				
				
				}
			}
		
	}
}