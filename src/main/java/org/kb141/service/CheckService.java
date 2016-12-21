package org.kb141.service;

import java.util.List;

import org.kb141.domain.CheckVO;

public interface CheckService {

	public void create(CheckVO vo);
	
	public List<CheckVO> checkList();
}
