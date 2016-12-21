package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.TakeProgramVO;
import org.kb141.persistence.TakeProgramDAO;
import org.springframework.stereotype.Service;

@Service
public class TakeProgramServiceImpl implements TakeProgramService{
	
	@Inject
	private TakeProgramDAO takeprogramDAO;
		
	
	@Override
	public void join(TakeProgramVO vo) {
		try {
			takeprogramDAO.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public TakeProgramVO view(String sid) {
		TakeProgramVO result = null;
		
		try {
			result = takeprogramDAO.read(sid);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void modify(TakeProgramVO vo) {
		try {
			takeprogramDAO.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String sid) {
		try {
			takeprogramDAO.delete(sid);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<TakeProgramVO> getAllList() {
		List<TakeProgramVO> result = null;
		
		try {
			result = takeprogramDAO.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

	@Override
	public List<TakeProgramVO> getList(Integer pno) {
		List<TakeProgramVO> result = null;
		
		try {
			result = takeprogramDAO.list(pno);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}
}
