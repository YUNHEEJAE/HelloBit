
package org.kb141.web;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ClassroomVO;
import org.kb141.domain.FaculityVO;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.StudentVO;
import org.kb141.domain.SubjectVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.domain.TeacherSubjectVO;
import org.kb141.domain.TeacherVO;
import org.kb141.service.ClassroomService;
import org.kb141.service.FaculityService;
import org.kb141.service.NoticeService;
import org.kb141.service.ProgramService;
import org.kb141.service.StudentService;
import org.kb141.service.SubjectService;
import org.kb141.service.TakeProgramService;
import org.kb141.service.TeacherService;
import org.kb141.service.TeacherSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Inject
	private TeacherSubjectService teacherSubjectService; 
	
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
	
	//교수과목 리스트
	@GetMapping("/teachersubjectlist")
	public ResponseEntity<List<TeacherSubjectVO>> TeacherSubjectList() {
		ResponseEntity<List<TeacherSubjectVO>> entity = null;
		try {
			entity = new ResponseEntity<List<TeacherSubjectVO>>(teacherSubjectService.getTeacherSubjectList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<TeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
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

	@GetMapping("/statelist") 
	public @ResponseBody List<TakeProgramVO> getStateList(TakeProgramVO vo)throws Exception{
		logger.info("pno :"+  vo);
		return takeprogramService.getstateList(vo);	
	}


//	@GetMapping("/stateList/{state}&&{pno}")
//	public ResponseEntity<List<TakeProgramVO>> showStateList(@PathVariable("state") String state , @PathVariable("pno") Integer pno)throws Exception{
//		logger.info("vo :" + state + pno);
//		TakeProgramVO vo = new TakeProgramVO();
//		if(state=="true"){
//			vo.setState(true);
//		}
//		vo.setState(false);
//		vo.setPno(pno);
//		ResponseEntity<List<TakeProgramVO>> entity = null;
//		try{
//			entity = new ResponseEntity<List<TakeProgramVO>>(takeprogramService.getstateList(vo) , HttpStatus.OK);
//		}catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<List<TakeProgramVO>>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return entity;
//	}
	

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
		
		takeprogramService.modify(vo);
		
		rttr.addFlashAttribute("result" , "success");
		
		return "redirect:takeprogramlist";

	}

	
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

	
	@GetMapping("/studentView")
	public void StudentView(Model model, String sid) throws Exception {
		logger.info("viewwwwwwwwwwwwwwwwwwww");
		model.addAttribute("studentVO", studentService.view(sid));
	}
	
	@PostMapping("/studentModify")
	public String StudentModify(StudentVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("Student Modify..............");
		logger.info("Student vo : " + vo);
		studentService.modify(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@PostMapping("/studentRemove")
	public String StudentRemove(String sid,RedirectAttributes rttr) throws Exception{
		logger.info("Student Remove..............");
		logger.info("Student sid : " + sid);
		studentService.remove(sid);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
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
	
//	@GetMapping("/teachermodify/{tid}")
//	public ResponseEntity<TeacherVO> TeacherModifyGET(@PathVariable("tid") String tid) throws Exception{
//		logger.info("Teacher Modify ......");
//		
//		ResponseEntity<TeacherVO> entity = null;
//		try{
//			entity = new ResponseEntity<TeacherVO>(teacherService.view(tid),HttpStatus.OK);
//		}catch(Exception e){
//			e.printStackTrace();
//			entity = new ResponseEntity<TeacherVO>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return entity;
//	}
	
	@GetMapping("/teachermodify")
	public void TeacherModifyGET() throws Exception{
		logger.info("Teacher Modify Page .........");
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
	@GetMapping("/classroomregister")
	public void ClassRoomCreateGET() throws Exception{
		logger.info("Teacher Create.....");
	}
	
	@PostMapping("/classroomregister")
	public String ClassRoomRegisterPOST(ClassroomVO vo)throws Exception{
		logger.info("ClassRoom Register.........................");
		logger.info("ClassRoom vo : " + vo);
		classroomService.register(vo);
		return "success";
	}
	
	

}
