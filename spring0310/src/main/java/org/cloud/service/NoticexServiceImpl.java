package org.cloud.service;

import java.util.List;

import org.cloud.controller.NoticexController;
import org.cloud.dto.NoticexDTO;
import org.cloud.mapper.NoticexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticexServiceImpl implements NoticexService {

	@Autowired
	private NoticexMapper noticexMapper;

	@Override
	public List<NoticexDTO> noticexList() throws Exception {
		List<NoticexDTO> noticexList = noticexMapper.noticexList();
		return noticexList;
	}
	
	@Override
	public int noticexWrite(NoticexDTO noticex) throws Exception {
		noticexMapper.noticexWrite(noticex);
		return 0;
	}
	
	@Override
	public NoticexDTO noticexDetail(int id) throws Exception {
		
		return noticexMapper.noticexDetail(id);
	}
	
	@Override
	public int noticexUpdate(NoticexDTO noticex) throws Exception {
		noticexMapper.noticexUpdate(noticex);
		return 0;
	}
	
	@Override
	public int noticexDelete(int id) throws Exception {
		noticexMapper.noticexDelete(id);
		return 0;
	}
	
	@Override
	public int noticexHitUp(int id) throws Exception {
		noticexMapper.noticexHitUp(id);
		return 0;
	}
}
