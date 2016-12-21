package org.kb141.web;

import javax.inject.Inject;

import javax.inject.Inject;

import org.kb141.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TBL_STUDENT
 * TBL_CHECK
 * TBL_TAKE_PROGRAM
 * @author KB141
 *
 */
@Controller
@RequestMapping("/student/*")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Inject
	private StudentService service;
	
	
	
	
	

	
}
