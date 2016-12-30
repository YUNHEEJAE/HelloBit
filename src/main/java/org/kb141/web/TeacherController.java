package org.kb141.web;

import javax.inject.Inject;

import org.kb141.domain.TeacherVO;
import org.kb141.service.CheckService;
import org.kb141.service.SubjectService;
import org.kb141.service.TakeProgramService;
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
	
	@Inject
	private TakeProgramService takeprogramService;
	
	@Inject
	private CheckService checkService;
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
	public void getMainList(Model model,Integer pno) throws Exception {
		logger.debug("getMainList LIST.....");
		int check = checkService.getcheckDate(pno);
		int total = takeprogramService.getstateTotal(pno);
		int late = checkService.getcheckLate(pno);
		int absent = total - check; 
		logger.debug(""+absent);
	
		model.addAttribute("total", total);
		model.addAttribute("check", check);
		model.addAttribute("absent", absent);
		model.addAttribute("late", late);
		model.addAttribute("currdate", checkService);
	}

	
	
}
