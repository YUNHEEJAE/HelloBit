package org.kb141.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.StudentVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.service.StudentService;
import org.kb141.service.TakeProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.FlashAttributeResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * TBL_STUDENT TBL_CHECK TBL_TAKE_PROGRAM
 * 
 * @author KB141
 *
 */
//test git by zetsubou

@Controller
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Inject
	private StudentService studentService;
	
	@Inject
	private TakeProgramService takeprogramService;
	
	@GetMapping("/register")
	public void registerGET(StudentVO vo, Model model) throws Exception{
		
		logger.info("register GET....");
	}
	

	@PostMapping("/register")
	public String registerPOST(StudentVO vo,  String filename , RedirectAttributes rttr) throws Exception{
		
		logger.info("register POST....");
		logger.info("VO : " + vo);
		logger.info("filename : " + filename);
		studentService.register(vo , filename);
		rttr.addFlashAttribute("result","success");
		
		return "redirect:list";
		

	}
	
	
	@PostMapping("/modify")
	public void modifyGET(StudentVO vo) throws Exception{
		studentService.modify(vo);
	}
	
	@PostMapping("/remove")
	public void removePOST(String sid) throws Exception{
		logger.info("remove" + sid);
		studentService.remove(sid);
	}
	

	
	@GetMapping("/list")
	public void getStudentList(Model model) throws Exception {
		logger.info("STUDENT LIST.....");
		model.addAttribute("list", studentService.getStudentList());

	}

	@GetMapping("/main")
	public void view(@RequestParam("sid") String sid, Model model) throws Exception {
		logger.info("STUDENT VIEW.....");
		model.addAttribute(studentService.view(sid));
		model.addAttribute("programVO", studentService.getViewProgram(sid));
	}
	
	@PostMapping("/enrolment")
	public String enrolment(TakeProgramVO vo , RedirectAttributes rttr) throws Exception{
	
		logger.info("수강신청 !!");
		logger.info("VO : " + vo);
	
		rttr.addFlashAttribute("result" , "success");
		
//		takeprogramService.join(vo);
		return "redirect:../program/list";
	
		
	}
	
	@GetMapping(value="/myprogram",produces="application/json")
	@ResponseBody
	public TakeProgramVO myprogram(String sid) throws Exception{
		
		
		logger.info("수강중인 과목");
		logger.info("sid : "+sid);
	
		TakeProgramVO vo = new TakeProgramVO();
		vo = takeprogramService.view(sid);
		
		logger.info("vo :"+ vo);
		return vo;
	}
	
	
	@PostMapping("/changeprogram")
	public void changeProgram(TakeProgramVO vo) throws Exception{
		logger.info("수강변경 !!");
		logger.info("VO : " + vo);
		takeprogramService.modify(vo);
	}
	

	@GetMapping(value="/alllist", produces="application/json")
	@ResponseBody
	public List<TakeProgramVO> getList(Model model) throws Exception {
		
		logger.info("list called...");
		
		List<TakeProgramVO> list = new ArrayList<TakeProgramVO>();
		
		list = takeprogramService.getAllList();
		
		logger.info("get list : "  + list);
		
		return list;
		
	}
	
	@GetMapping(value="/programstudentlist" , produces="application/json" )
	@ResponseBody
	public List<TakeProgramVO> getprogramStudentList(Integer pno)throws Exception{
		
		List<TakeProgramVO> list = new ArrayList<TakeProgramVO>();
		
		logger.info("pno" + pno);
		
		list = takeprogramService.getList(pno);
		
		logger.info("list" + list);
		
		return list;
		
	}
	
	@GetMapping("/login")
	public void login() throws Exception {
		logger.info("LOGIN CALLED...");
		
	}
	
	
	
	@GetMapping("/chartTest")
	public void chartTest() throws Exception{
		logger.info("CHART CALLED.....");
	}
	
}
