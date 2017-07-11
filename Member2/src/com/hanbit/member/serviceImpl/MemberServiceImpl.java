package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;// 1순위 큰놈\
	// 4번째 (인스턴스변수)
	Map<String,MemberBean> map;
	MemberBean member;
	public MemberServiceImpl() { // 2번 생성자 만들고
		member = new MemberBean();
		list = new ArrayList<MemberBean>(); // 3리스트를 초기화
		
	}
	@Override
	public void addMember(MemberBean bean) {
		map.put(bean.getId(),bean);
	}
	@Override
	public List<MemberBean> list() {
		List<MemberBean>list=new ArrayList<>();
		Set<String>keys=map.keySet();
		for(String s:keys){
			list.add(map.get(s));
		}
		return list;
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new	ArrayList<MemberBean>();
			for(MemberBean x:list){
				if(name.equals(x.getName())){
					temp.add(map.get(x));
				}
			}
		
	return temp;
	}
	@Override
	public MemberBean findById(String id) {
		
		return map.get(id);
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
