package org.kb141.web;

import javax.inject.Inject;

import org.kb141.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TBL_STUDENT TBL_CHECK TBL_TAKE_PROGRAM
 * 
 * @author KB141
 *
 */
@Controller
@RequestMapping("/student/*")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Inject
	private StudentService service;


	@GetMapping("/list")
	public void getStudentList(Model model) throws Exception {
		logger.info("STUDENT LIST.....");
		model.addAttribute("list", service.getStudentList());

	}


	
	//http://localhost:8081/web/student/view?sid=sih
	@GetMapping("/view")
	public void view(@RequestParam("sid") String sid, Model model) throws Exception {
		logger.info("STUDENT VIEW.....");
		model.addAttribute(service.view(sid));

	}

}
