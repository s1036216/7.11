package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;// 1순위 큰놈\
	int count; // 4번째 (인스턴스변수)
	MemberBean member;
	public MemberServiceImpl() { // 2번 생성자 만들고
		member = new MemberBean();
		list = new ArrayList<MemberBean>(); // 3리스트를 초기화
		count = 0;// 초기화
	}
	@Override
	public void addMember(MemberBean bean) {
		list.add(bean);
	}
	@Override
	public List<MemberBean> list() {
		System.out.print(list);
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new	ArrayList<MemberBean>();
		int count=0;
		for (MemberBean m:list) {
			if (name.equals(m.getName())) {
				count++;
			}
		}
		for (MemberBean m:list) {
			if (name.equals(m.getName())){
				temp.add(m);
				if(count==temp.size());
				break;
			}
			}
		
	return temp;
	}
	@Override
	public MemberBean findById(String id) {
		for (MemberBean m:list) {
			if (id.equals(m.getId())) {
				member = m;
			}
		}
		return member;
	}
	@Override
	public int count() {
		return list.size();
	}
	@Override
	public void update(MemberBean bean) {
	findById(bean.getId()).setName(bean.getName());
	findById(bean.getId()).setSsn(bean.getSsn());
	findById(bean.getId()).setPassword(bean.getPassword());
	
	}
	@Override
	public void delete(String id) {
		for (MemberBean m:list){
			if(id.equals(m.getId())){
				list.remove(m);
			}	
		}
	}
}