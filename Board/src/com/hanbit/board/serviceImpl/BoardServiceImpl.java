package com.hanbit.board.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService {
	BoardBean board;
	List<BoardBean> list;
	public BoardServiceImpl() {
		board = new BoardBean();
		list =new ArrayList<BoardBean>();
	}
	@Override
	public void writeBoard(BoardBean bean) {
		list.add(bean);
		System.out.println("serviceImpl writeBoard:" + bean.toString());
	}
	@Override
	public int countArticles() {
		return list.size();
	}
	@Override
	public List<BoardBean> list() {
		System.out.println("list" + list.toString());
		return list;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		board = new BoardBean();
		for (BoardBean x:list) {
			if (seq == x.getSeq()) {
				board = x;
				break;
			}
		}
		System.out.println("result: " + board.toString());
		return board;
	}

	@Override
	public List<BoardBean> findByWriter(String writer) {
		List<BoardBean> temp=new	ArrayList<BoardBean>();

		for (BoardBean m:list) {
			if (writer.equals(m.getWriter())) {
				temp.add(m);
			}
		}
		/*}
		for (BoardBean m:list) {
			if (writer.equals(m.getWriter())){
				temp.add(m);
				if(count==temp.size());
				break;
			}
			}
		System.out.println("findByName: " +temp.toString());*/	
	return temp;
	}
	
	
	@Override
	public void updateBoard(BoardBean bean) {
		board = findBySeq(bean.getSeq());
		board.setTitle(bean.getTitle());
		board.setContent(bean.getContent());
		board.setRegDate(bean.getRegDate());
		System.out.println("수정된 info: " + board.toString());
	}

	@Override
	public void deleteBoard(int seq) {
		for (BoardBean x:list) {
			if (seq == x.getSeq()) {
				list.remove(x);
				break;
			}
		}
		
	}

}