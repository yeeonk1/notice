package org.cloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cloud.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO memberLoginCheck(MemberDTO member) throws Exception;
	void memberJoin(MemberDTO member) throws Exception;
	int idCheck(String userId);
}
