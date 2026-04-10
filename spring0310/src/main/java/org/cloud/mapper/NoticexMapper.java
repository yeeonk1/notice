package org.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.cloud.dto.NoticexDTO;

@Mapper
public interface NoticexMapper {

	List<NoticexDTO> noticexList() throws Exception;
	int noticexWrite(NoticexDTO noticex) throws Exception;
	NoticexDTO noticexDetail(int id) throws Exception;
	int noticexUpdate(NoticexDTO noticex) throws Exception;
	int noticexDelete(int id) throws Exception;
	int noticexHitUp(int id) throws Exception;
}
