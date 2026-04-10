package org.cloud.service;

import org.cloud.dto.MemberDTO;

public interface MemberService {

	MemberDTO memberLoginCheck(MemberDTO member) throws Exception;
	void memberJoin(MemberDTO member) throws Exception;
	int idCheck(String userId);
}
