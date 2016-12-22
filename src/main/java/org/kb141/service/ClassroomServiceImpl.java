package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.persistence.ClassroomDAO;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	ClassroomDAO Classroomdao;

	@Override
	public void register(ClassroomVO vo) {
		try {
			Classroomdao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClassroomVO view(String roomname) {

		ClassroomVO result = null;

		try {
			result = Classroomdao.read(roomname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void modify(ClassroomVO vo) {
		try {
			Classroomdao.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String roomname) {
		try {
			Classroomdao.delete(roomname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ClassroomVO> getClassroomList() {
		List<ClassroomVO> result = null;

		try {
			result = Classroomdao.allList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
