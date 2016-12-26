package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.domain.FaculityVO;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;
import org.kb141.domain.SubjectVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.domain.TeacherVO;
import org.kb141.service.ClassroomService;
import org.kb141.service.FaculityService;
import org.kb141.service.NoticeService;
import org.kb141.service.StudentService;
import org.kb141.service.SubjectService;
import org.kb141.service.TakeProgramService;
import org.kb141.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculity")
public class FaculityController {

	
	private static final Logger logger = LoggerFactory.getLogger(FaculityController.class);
  
	@Inject
	private NoticeService noticeService;

	@Inject
	private FaculityService faculityService;

	@Inject
	private ClassroomService Classroomservice;

	@Inject
	private TeacherService Teacherservice;
	
	@Inject
	private SubjectService Subjectservice;

	@Inject
	private StudentService Studentservice;
	
	@Inject
	private TakeProgramService TakeProgramservice;
	
	@GetMapping("/noticeBoard")
	public void getNoticeBoard(Model model) throws Exception {
		logger.info("noticeBoard called....");

		model.addAttribute("list", noticeService.getNoticeList());
	}

//	@GetMapping(value = "/faculitylist", produces = "application/json")
//	@ResponseBody
//	public List<FaculityVO> faculitylist(Model model) throws Exception {
//
//		logger.info("faculity list..........");
//		List<FaculityVO> list = new ArrayList<FaculityVO>();
//		list = faculityService.getFaculityList();
//		logger.info("get list :" + list);
//		return list;
//
//	}

	@GetMapping("/list")
	public void list() throws Exception{
		logger.info("Faculity LIST .....");
	}
	
	
	// 교직원 리스트
	@GetMapping("/faculitylist")
	public ResponseEntity<List<FaculityVO>> faculityAllList() {
		ResponseEntity<List<FaculityVO>> entity = null;
		try {
			entity = new ResponseEntity<List<FaculityVO>>(faculityService.getFaculityList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<FaculityVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 강의장 리스트
	@GetMapping("/classroomlist")
	public ResponseEntity<List<ClassroomVO>> classroomList() {
		ResponseEntity<List<ClassroomVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ClassroomVO>>(Classroomservice.getClassroomList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ClassroomVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 강사 리스트
	@GetMapping("/teacherlist")
	public ResponseEntity<List<TeacherVO>> TeacherList() {
		ResponseEntity<List<TeacherVO>> entity = null;
		try {
			entity = new ResponseEntity<List<TeacherVO>>(Teacherservice.getTeacherList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<TeacherVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 과목 리스트
	@GetMapping("/subjectlist")
	public ResponseEntity<List<SubjectVO>> SubjectList() {
		ResponseEntity<List<SubjectVO>> entity = null;
		try {
			entity = new ResponseEntity<List<SubjectVO>>(Subjectservice.getSubjectList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<SubjectVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
	
	// 학생 리스트
	@GetMapping("/studentlist")
	public ResponseEntity<List<StudentVO>> StudentList() {
		ResponseEntity<List<StudentVO>> entity = null;
		try {
			entity = new ResponseEntity<List<StudentVO>>(Studentservice.getStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<StudentVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/takeprogramlist")
	public void takeprogramlist() throws Exception{
		logger.info("takeprogramlist LIST.....");
	}

	@GetMapping("/statelist")
	public String getStateList(TakeProgramVO vo)throws Exception{
		
		logger.info("pno :"+  vo);
		return "";	
	}

	
}
