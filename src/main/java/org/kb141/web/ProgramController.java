package org.kb141.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.service.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TBL_PROGRAM
 * TBL_CLASSROOM
 * TBL_CURRICULUM
 * @author KB141
 *
 */
@Controller
@RequestMapping("/program/")
public class ProgramController {
	// CRUD allList
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	@Inject
	ClassroomService classroomservice;
	
	@GetMapping("/classroom")
	public void programpage(ClassroomVO vo, Model model){
		logger.info("program GET .....");
	}
	
	@ResponseBody
	@GetMapping(value="/classroomlist",  produces="application/json")
	public List<ClassroomVO> getClassroomList(Model model) throws Exception{
		logger.info("classroomlist Start......");
		
		List<ClassroomVO> list = new ArrayList<ClassroomVO>();
		list = classroomservice.getClassroomList();
		
		logger.info("get list : " + list);
		
		model.addAttribute("getclassroomlist", classroomservice.getClassroomList());
		return list;
	}
	
	
	
	
	
	
	
	
}
