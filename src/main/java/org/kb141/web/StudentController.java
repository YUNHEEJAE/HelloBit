package org.kb141.web;

import javax.inject.Inject;

import org.kb141.domain.StudentVO;
import org.kb141.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


	
	@GetMapping("/register")
	public void registerGET(StudentVO vo) throws Exception{
		
		logger.info("register GET....");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerPOST(@RequestBody StudentVO vo) throws Exception{
		
		logger.info("VO : " + vo);
//		service.register(vo);
	}
	
	
	@GetMapping("/modify")
	public void modifyGET(StudentVO vo) throws Exception{
		service.modify(vo);
	}
	
	@PostMapping("/remove")
	public void removePOST(String sid) throws Exception{
		logger.info("remove" + sid);
		service.remove(sid);
	}
	

	@GetMapping("/list")
	public void getStudentList(Model model) throws Exception {
		logger.info("STUDENT LIST.....");
		model.addAttribute("list", service.getStudentList());

	}

	@GetMapping("/view")
	public void view(@RequestParam("sid") String sid, Model model) throws Exception {
		logger.info("STUDENT VIEW.....");
		model.addAttribute(service.view(sid));

	}

}
