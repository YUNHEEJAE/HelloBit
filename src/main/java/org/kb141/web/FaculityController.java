package org.kb141.web;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.domain.FaculityVO;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;
import org.kb141.domain.SubjectVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.domain.TeacherVO;
import org.kb141.service.ClassroomService;
import org.kb141.service.FaculityService;
import org.kb141.service.NoticeService;
import org.kb141.service.ProgramService;
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
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculity")
public class FaculityController {

	
	private static final Logger logger = LoggerFactory.getLogger(FaculityController.class);
  
	@Inject
	private NoticeService noticeService;

	@Inject
	private FaculityService faculityService;

	@Inject
	private ClassroomService classroomService;

	@Inject
	private TeacherService teacherService;
	
	@Inject
	private SubjectService subjectService;

	@Inject
	private StudentService studentService;
	
	@Inject
	private TakeProgramService takeprogramService;
	
	@Inject
	private ProgramService programService;
	
	
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
			entity = new ResponseEntity<List<ClassroomVO>>(classroomService.getClassroomList(), HttpStatus.OK);
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
			entity = new ResponseEntity<List<TeacherVO>>(teacherService.getTeacherList(), HttpStatus.OK);
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
			entity = new ResponseEntity<List<SubjectVO>>(subjectService.getSubjectList(), HttpStatus.OK);
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
			entity = new ResponseEntity<List<StudentVO>>(studentService.getStudentList(), HttpStatus.OK);
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
<<<<<<< HEAD
	// 승인 상태 리스트 가져오기
	@GetMapping("/statelist")
=======

	@GetMapping("/statelist") 
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
	public @ResponseBody List<TakeProgramVO> getStateList(TakeProgramVO vo)throws Exception{
		logger.info("pno :"+  vo);
		return takeprogramService.getstateList(vo);	
	}
<<<<<<< HEAD
	
	// 수강 승인
	@PostMapping(value="/admission")
	public String admissionEnrolment(String[] sid , Integer pno , RedirectAttributes rttr)throws Exception{
		
		logger.info("admission called....");
		
		logger.info("sid" + Arrays.toString(sid));
		
		logger.info("pno : " + pno);
		
		TakeProgramVO vo = new TakeProgramVO();
		
		for(int i = 0 ; i < sid.length ; i ++){
			vo.setState(true);
			vo.setSid(sid[i]);
			vo.setPno(pno);
		}
		
		TakeProgramservice.modify(vo);
		
		rttr.addFlashAttribute("result" , "success");
		
		return "redirect:takeprogramlist";
		
		
		

	}
=======
	
	//  모든 Join한 강사이름, 과목, 등급 리스트 
	@GetMapping("/joinalllist")
	public ResponseEntity<List<JoinTeacherSubjectVO>> joinALlList() {
		ResponseEntity<List<JoinTeacherSubjectVO>> entity = null;
		try {
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(programService.getAllTeacherSubjectList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 프로그램 별 join한 강사이름, 과목, 등급 리스트
	@GetMapping("/teachersubjectlist/{pno}")
	public ResponseEntity<List<JoinTeacherSubjectVO>> teacherSubjectList(@PathVariable("pno") Integer pno) {
		ResponseEntity<List<JoinTeacherSubjectVO>> entity = null;
		try {
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(programService.getTeacherSubjectList(pno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

	@GetMapping("/teacherregister")
	public void TeacherCreateGET() throws Exception{
		logger.info("Teacher Create.....");
	}
	
	@PostMapping("/teacherregister")
	public String TeacherRegisterPOST(TeacherVO vo)throws Exception{
		logger.info("Teacher Register.........................");
		logger.info("Teacher vo : " + vo);
		teacherService.register(vo);
		return "success";
	}
	
	@GetMapping("/teachermodify/{tid}")
	public void TeacherModifyGET(String tid, Model model) throws Exception{
		logger.info("Teacher Modify ......");
		
		
	}
	
	@PostMapping("/teachermodify")
	public String TeacherModifyPOST(TeacherVO vo) throws Exception{
		logger.info("Teacher Modify........");
		logger.info("TeacherVO : " + vo);
		teacherService.modify(vo);
		return "success";
	}
	
	@GetMapping("/faculityregister")
	public void FaculityRegisterGET() throws Exception{
		logger.info("Faculity Register.........");
	}
	
	@PostMapping("/faculityregister")
	public String FaculityRegisterPOST(FaculityVO vo) throws Exception{
		
		
		
		return "success";
	}
	
	
	
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git

	
}
