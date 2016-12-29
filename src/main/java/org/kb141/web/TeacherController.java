package org.kb141.web;

import javax.inject.Inject;

import org.kb141.domain.TeacherVO;
import org.kb141.service.SubjectService;
import org.kb141.service.TeacherService;
import org.kb141.service.TeacherSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TBL_TEACHER TBL_SUBJECT TBL_TEACHER_SUBJECT
 * 
 * @author KB141
 *
 */
@Controller
@RequestMapping("/teacher/*")
public class TeacherController {

	@Inject
	private TeacherService teacherService;

	@Inject
	private SubjectService subjectService;

	@Inject
	private TeacherSubjectService tsService;

	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

	// 리스트 먼저 뽑아보자.

	@GetMapping("/teachers")
	public void getTeacherList(Model model) throws Exception {
		logger.info("TEACHER LIST......");
		model.addAttribute("tList", teacherService.getTeacherList());
	}

	@GetMapping("/subjects")
	public void getSubjectList(Model model) throws Exception {
		logger.info("SUBJECT LIST......");
		model.addAttribute("sList", subjectService.getSubjectList());
	}

	@GetMapping("/ts")
	public void getTSList(Model model) throws Exception {
		logger.info("TS LIST.....");
		model.addAttribute("tsList", tsService.getTeacherSubjectList());
		model.addAttribute("sList", subjectService.getSubjectList());
	}
	
	@GetMapping("/main")
	public void getMainList() throws Exception {
		logger.info("getMainList LIST.....");

	}

	
}
