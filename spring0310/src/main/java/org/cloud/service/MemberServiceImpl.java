package org.cloud.service;

import org.cloud.dto.MemberDTO;
import org.cloud.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDTO memberLoginCheck(MemberDTO member) throws Exception {
		
		return memberMapper.memberLoginCheck(member);
	}
	
	@Override
	public void memberJoin(MemberDTO member) throws Exception {
		memberMapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String userId) {

		return memberMapper.idCheck(userId);
	}
}
