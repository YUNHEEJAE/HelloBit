package org.kb141.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.domain.CurriculumVO;
import org.kb141.domain.ProgramVO;
import org.kb141.service.ClassroomService;
import org.kb141.service.CurriculumService;
import org.kb141.service.ProgramService;
import org.kb141.service.TakeProgramService;
import org.kb141.service.TeacherSubjectService;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TBL_PROGRAM TBL_CLASSROOM TBL_CURRICULUM
 * 
 * @author KB141
 *
 */
@Controller
@RequestMapping("/program")
public class ProgramController {
	// CRUD allList
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	@Inject
	private ClassroomService classroomservice;
	
	@Inject
	private CurriculumService curriculumService;
	
	@Inject
	private TakeProgramService takeprogramService;

	@Inject
	private ProgramService programService;
	
	@Inject
	private TeacherSubjectService teacherSubjectService;
	
	@Inject
	private FaceAPIUtils faceAPI;
	

	@Inject
	private ProgramService service;
	
	@GetMapping("/classroom")
//	@Secured("ROLE_FACULITY")
	public void programpage(ClassroomVO vo, Model model){
		logger.info("program GET .....");
	}
	
	
	
	@ResponseBody
//	@Secured("ROLE_FACULITY")
	@GetMapping(value="/classroomlist",  produces="application/json")
	public List<ClassroomVO> getClassroomList(Model model) throws Exception{
		logger.info("classroomlist Start......");
		
		List<ClassroomVO> list = new ArrayList<ClassroomVO>();
		list = classroomservice.getClassroomList();
		
		logger.info("get list : " + list);
		
		model.addAttribute("getclassroomlist", classroomservice.getClassroomList());
		return list;
	}
	

	
	@ResponseBody
//	@Secured("ROLE_FACULITY")
	@GetMapping(value="/allcurriculumlist", produces="application/json")
	public List<CurriculumVO> allCurriculumList() throws Exception {
		logger.info("커리큘럼 전체 리스트");
		return curriculumService.getAllCurriculumList();
	}
	
	@ResponseBody
//	@Secured("ROLE_FACULITY")
	@GetMapping(value="curriculumlist", produces="application/json")
	public List<CurriculumVO> curriculumList(Integer pno) throws Exception{
		logger.info("커리큘럼 PNO로 검색한 리스트");
		return curriculumService.view(pno);
	}
	
	@PostMapping("/registercurriculum")
//	@Secured("ROLE_FACULITY")
	public String registerCurriculum(CurriculumVO vo) throws Exception {
		logger.info("curriculum Register Post...");
		logger.info("VO : " + vo);
		
		curriculumService.register(vo);
				
		return "success";
	}
	


	
	@GetMapping("/list")
//	@Secured({"ROLE_FACULITY", "ROLE_STUDENT"})
	public void list() throws Exception{
		logger.info("PROGRAM LIST.....");
	}
	
	
	@GetMapping("/allList")
//	@Secured({"ROLE_FACULITY", "ROLE_STUDENT"})
	public ResponseEntity<List<ProgramVO>> allList() {
		ResponseEntity<List<ProgramVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ProgramVO>>(programService.getProgramList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ProgramVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}


	@GetMapping("/view")
//	@Secured({"ROLE_FACULITY", "ROLE_STUDENT"})
	public void viewProgram(Integer pno , Model model)throws Exception{
		logger.info("view called .............");

		model.addAttribute("view" , programService.view(pno));
		model.addAttribute("joinList", teacherSubjectService.getJoinList(pno));
		model.addAttribute("stateCount" , takeprogramService.getstateTotal(pno));
		
	}
	
	
	@GetMapping("/categoryList/{category}")
//	@Secured({"ROLE_FACULITY", "ROLE_STUDENT"})
	public ResponseEntity<List<ProgramVO>> categoryList(@PathVariable("category") String category){
		
		ResponseEntity<List<ProgramVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ProgramVO>>(programService.getCategoryList(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ProgramVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/register")
//	@Secured("ROLE_FACULITY")
	public void register(Model model) throws Exception {
		logger.info("Program Register Called....");
		model.addAttribute("classroomList", classroomservice.getClassroomList());
		model.addAttribute("joinAllList", teacherSubjectService.getJoinAllList());
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@PostMapping("/register")
//	@Secured("ROLE_FACULITY")
	public String registerPost(ProgramVO vo, String curriculums) throws Exception {
		logger.info("Program Register Post Called....");
		logger.info("VO : " + vo);
		logger.info("Curri " + curriculums);
		
		String pcourse = vo.getPcourse();
		
		String personGroupId = vo.getPersongroupid(); 
		
		faceAPI.createPersonGroupId(pcourse, personGroupId);
		
		programService.register(vo, curriculums);
		return "redirect:list";
	}
	
	@GetMapping("/modify")
//	@Secured("ROLE_FACULITY")
	public void modify(Integer pno, Model model) throws Exception {
		logger.info("PNO : " + pno);
		model.addAttribute("classroomList", classroomservice.getClassroomList());
		model.addAttribute("joinAllList", teacherSubjectService.getJoinAllList());
		model.addAttribute("currdata", programService.view(pno));
	}
	
	@PostMapping("/modify")
//	@Secured("ROLE_FACULITY")
	public String modifyPost(ProgramVO vo, String curriculums) throws Exception {
		logger.info("Program Modify Post Called....");
		logger.info("VO : " + vo);
		logger.info("Curri " + curriculums);
		
		programService.modify(vo, curriculums);
		
		return "redirect:view?pno=" + vo.getPno();
	}
	

	
}
