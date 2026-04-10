package org.cloud.service;

import java.util.List;

import org.cloud.dto.NoticexDTO;

public interface NoticexService {

	List<NoticexDTO> noticexList() throws Exception;
	int noticexWrite(NoticexDTO noticex) throws Exception;
	NoticexDTO noticexDetail(int id) throws Exception;
	int noticexUpdate(NoticexDTO noticex) throws Exception;
	int noticexDelete(int id) throws Exception;
	int noticexHitUp(int id) throws Exception;
}
