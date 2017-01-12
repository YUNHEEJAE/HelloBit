
package org.kb141.web;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.ClassroomVO;
import org.kb141.domain.Criteria;
import org.kb141.domain.FaculityVO;
import org.kb141.domain.ImageVO;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.NoticeVO;
import org.kb141.domain.PageMaker;
import org.kb141.domain.StudentVO;
import org.kb141.domain.SubjectVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.domain.TeacherSubjectVO;
import org.kb141.domain.TeacherVO;
import org.kb141.service.CheckService;
import org.kb141.service.ClassroomService;
import org.kb141.service.FaculityService;
import org.kb141.service.ImageService;
import org.kb141.service.NoticeService;
import org.kb141.service.ProgramService;
import org.kb141.service.StudentService;
import org.kb141.service.SubjectService;
import org.kb141.service.TakeProgramService;
import org.kb141.service.TeacherService;
import org.kb141.service.TeacherSubjectService;
import org.kb141.util.CookieChecker;
import org.kb141.util.EmotionUtils;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculity")
@Secured("ROLE_FACULITY")
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
	private TeacherSubjectService teacherSubjectService; 
	
	@Inject
	private ImageService imageService;
	
	@Inject
	private CheckService checkService;
	
	@Inject
	private ProgramService programService;
	
	@Inject
	private FaceAPIUtils faceAPI;
	
	@Inject
	private EmotionUtils emotionUtils;
	
	@Inject
	private CookieChecker cookieChecker;
	
	@GetMapping("/main")
	public void faculityMain(Integer pno, HttpServletRequest request, Model model) throws Exception{
		logger.info("FACULITY MAIN");
		
		cookieChecker.cookieChecker(request.getCookies(), pno);
		
		List<CheckTimeVO> result = checkService.getTodayCheck(pno);
		List<CheckTimeVO> chulseok = new ArrayList<CheckTimeVO>();
		List<CheckTimeVO> jigak = new ArrayList<CheckTimeVO>();
		
		for (CheckTimeVO checkTimeVO : result) {
			if(checkTimeVO.getStates().equals("blue") ){
				chulseok.add(checkTimeVO);
			} else {
				jigak.add(checkTimeVO);
			}
		}
		
		int total = takeprogramService.getstateTotal(pno);
		
		model.addAttribute("program", programService.view(pno));
		model.addAttribute("attendanceCnt",checkService.getAttendanceCnt(pno));
		model.addAttribute("result", result );
		model.addAttribute("check", result.size());
		model.addAttribute("late", jigak.size());
		model.addAttribute("total", total);
		model.addAttribute("absent", total - chulseok.size());
		model.addAttribute("lateManList", checkService.getcheckLateMan(pno));
		model.addAttribute("week", checkService.getCheckWeek(pno));
		model.addAttribute("emotionList", emotionUtils.emotionCounter(result));
		model.addAttribute("StudentCheckKLogVO",checkService.getstudentCheckLog(pno));
	}
	
	@GetMapping("/notice")
	public void getNoticeBoard(Criteria cri, Model model) throws Exception {
		logger.info("noticeBoard called....");
		
		cri.setPerPageNum(15);
		model.addAttribute("notice", noticeService.listCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotal(noticeService.listCountCriteria(cri));
		
		model.addAttribute("pageMaker",pageMaker);
	
	}
	
	@GetMapping("/noticeregister")
	public void noticeRegisterGet() throws Exception {
		logger.info("notice register called...");
	}
	
	@PostMapping("/noticeregister")
	public String noticeRegisterPost(NoticeVO vo) throws Exception {
		logger.info("notice register called...");
		
		System.out.println(vo);
		
		noticeService.register(vo);
		
		return "redirect:notice";
	}
	
	@GetMapping("/noticemodify")
	public void noticeModifyGet(Integer nno, Model model) throws Exception {
		logger.info("notice modify called...");
		
		model.addAttribute("NoticeVO", noticeService.view(nno));
		
	}
	
	@PostMapping("/noticemodify")
	public String noticeModifyPost(NoticeVO vo) throws Exception {
		logger.info("notice modify called...");
		
		System.out.println(vo);
		
		noticeService.modify(vo);
		
		return "redirect:notice/view?nno=" + vo.getNno();
	}
	
	@GetMapping("/noticeview")
	public void getNoticeBoardview(Model model,Integer nno) throws Exception {
		logger.info("noticeBoard called....");

			
		model.addAttribute("noticeVO", noticeService.view(nno));
	}
	
	@PostMapping("/noticeRemove")
	public String getNoticeBoardRemove(Integer nno)throws Exception{
		logger.info("noticeBoardRemove called....");
		noticeService.remove(nno);
		return "redirect:notice";
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
	
//	//교수과목 리스트
//	@GetMapping("/teachersubjectlist")
//	public ResponseEntity<List<TeacherSubjectVO>> TeacherSubjectList2() {
//		ResponseEntity<List<TeacherSubjectVO>> entity = null;
//		try {
//			entity = new ResponseEntity<List<TeacherSubjectVO>>(teacherSubjectService.getTeacherSubjectList(), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<List<TeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//	}
	
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
	 
	@GetMapping("/teachersubjectlist")
	public ResponseEntity<List<JoinTeacherSubjectVO>> TeacherSubjectList(){
		ResponseEntity<List<JoinTeacherSubjectVO>> entity = null;
		try{
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(teacherSubjectService.getJoinAllList(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
		}
		logger.info("JoinTeacherSubjectVOList : " + entity);
		return entity;
	}
	
//	@GetMapping("/teachersubjectlist/{pno}")
//	public ResponseEntity<List<JoinTeacherSubjectVO>> TeacherSubjectList(@PathVariable("pno") Integer pno){
//		ResponseEntity<List<JoinTeacherSubjectVO>> entity = null;
//		try{
//			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(teacherSubjectService.getJoinList(pno), HttpStatus.OK);
//		}catch(Exception e){
//			e.printStackTrace();
//			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return entity;
//	}
	
	@GetMapping("/takeprogramlist")
	public void takeprogramlist() throws Exception{
		logger.info("takeprogramlist LIST.....");
	}

	@GetMapping("/statelist") 
	public @ResponseBody List<TakeProgramVO> getStateList(TakeProgramVO vo)throws Exception{
		logger.info("pno :"+  vo);
		return takeprogramService.getstateList(vo);	
	}

	
	@GetMapping("/stateList/{pno}&&{state}") 
	public ResponseEntity<List<TakeProgramVO>> getStateList(@PathVariable("pno") Integer pno, @PathVariable("state") String state)throws Exception{
		logger.info("state List called..........................");
		TakeProgramVO vo = new TakeProgramVO();
		logger.info("============" + state + pno + "=============");
		vo.setPno(pno);
//		if(state.equals("true")){
//			vo.setState(true);
//		}
//		else{
//			vo.setState(false);
//		}
		
		vo.setState(state.equals("true") ? true : false);

		ResponseEntity<List<TakeProgramVO>> entity = null;
		try {
			entity = new ResponseEntity<List<TakeProgramVO>>(takeprogramService.getstateList(vo) , HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<TakeProgramVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}

	// 수강 승인
	@PostMapping(value="/admission")
	public String admissionEnrolment(String[] sid , Integer pno , String groupid,RedirectAttributes rttr)throws Exception{
		
		logger.debug("admission called..........................................................................");
		logger.debug("sid" + Arrays.toString(sid));
		logger.info("pno : " + pno);
		logger.info("groupid" + groupid);
		TakeProgramVO vo = new TakeProgramVO();
	
		
		for(int i = 0 ; i < sid.length ; i ++){
			vo.setState(true);
			vo.setSid(sid[i]);
			vo.setPno(pno);
			String api = faceAPI.createPersonId(sid[i], groupid);
			logger.info("api : " + api);
			vo.setPersonid(api);
			System.out.println(vo);
			takeprogramService.modify(vo);
		}
		
		rttr.addFlashAttribute("result" , "success");
		return "redirect:takeprogramlist";

	}
	
	// 수강 취소 
	@PostMapping(value="/cancel")
	public String CancelEnrolment(String[] sid , Integer pno , String groupid, RedirectAttributes rttr)throws Exception{
		
		TakeProgramVO vo = new TakeProgramVO();

		logger.info("cancel called...");
		
		logger.info("sid && pno " + sid + pno);
		
		for(int i = 0 ; i < sid.length ; i ++){
			vo.setState(false);
			vo.setPno(pno);
			vo.setSid(sid[i]);
			String personid = vo.getPersonid();
			
			faceAPI.deletePersonId(personid, groupid);
		
			takeprogramService.modify(vo);
			
		}
		rttr.addFlashAttribute("result" , "success");
		return "redirect:takeprogramlist";
	}
	

	//  모든 Join한 강사이름, 과목, 등급 리스트 
	@GetMapping("/joinalllist")
	public ResponseEntity<List<JoinTeacherSubjectVO>> joinALlList() {
		ResponseEntity<List<JoinTeacherSubjectVO>> entity = null;
		try {
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(teacherSubjectService.getJoinAllList(), HttpStatus.OK);
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
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(teacherSubjectService.getJoinList(pno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<JoinTeacherSubjectVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@GetMapping("/studentregister")
	public void studentRegister() throws Exception{
		logger.info("Student Create.....");
	}
	
	@PostMapping("/studentregister")
	public String studentRegisterPOST(StudentVO vo,  String filename , RedirectAttributes rttr) throws Exception{
		
		logger.info("register POST....");
		logger.info("VO : " + vo);
		logger.info("filename : " + filename);
		studentService.register(vo , filename);
		rttr.addFlashAttribute("result","success");
		
		return "redirect:list";

	}
	
	
	@GetMapping("/studentview")
	public void StudentView(Model model, String sid) throws Exception {
		logger.info("viewwwwwwwwwwwwwwwwwwww");
		model.addAttribute("studentVO", studentService.view(sid));
	}
	
	@PostMapping("/studentmodify")
	public String StudentModify(StudentVO vo, RedirectAttributes rttr) throws Exception{
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
	public String TeacherRegisterPOST(TeacherVO vo,RedirectAttributes rttr)throws Exception{
		logger.info("Teacher Register.........................");
		logger.info("Teacher vo : " + vo);
		teacherService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/teacherview")
	public void TeacherViewGET(@RequestParam("tid") String tid, Model model) throws Exception{
			logger.info("Teacher view...........");
			logger.info("tid : " + tid);
			model.addAttribute("teacherVO", teacherService.view(tid));
	}
	
	@PostMapping("/teachermodify")
	public String TeacherModifyPOST(TeacherVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("Teacher Modify........");
		logger.info("TeacherVO : " + vo);
		teacherService.modify(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@PostMapping("/teacherremove")
	public String TeacherRemove(String tid,RedirectAttributes rttr) throws Exception{
		logger.info("Teacher Remove..............");
		logger.info("Teacher tid : " + tid);
		teacherService.remove(tid);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	  
	@GetMapping("/teachermodify")
	public void TeacherModifyGET() throws Exception{
		logger.info("Teacher Modify Page .........");
	}
	

	@GetMapping("/faculityregister")
	public void FaculityRegisterGET() throws Exception{
		logger.info("Faculity Register.........");
	}   
	
	@PostMapping("/faculityregister")
	public String FaculityRegisterPOST(FaculityVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("Faculity Register.........................");
		logger.info("Faculity vo : " + vo);
		faculityService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/faculityview")
	public void FaculityViewGET(@RequestParam("fid") String fid, Model model) throws Exception{
			logger.info("Faculity view...........");
			logger.info("fid : " + fid);
			model.addAttribute("faculityVO", faculityService.view(fid));
	}
	
	@PostMapping("/faculitymodify")
	public String FaculityModifyPOST(FaculityVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("Faculity Modify........");
		logger.info("Faculity : " + vo);
		faculityService.modify(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@PostMapping("/faculityremove")
	public String FaculityRemove(String fid,RedirectAttributes rttr) throws Exception{
		logger.info("Faculity Remove..............");
		logger.info("Faculity fid : " + fid);
		faculityService.remove(fid);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@GetMapping("/classroomregister")
	public void ClassRoomCreateGET() throws Exception{
		logger.info("Teacher Create.....");
	}
	
	@PostMapping("/classroomregister")
	public String ClassRoomRegisterPOST(ClassroomVO vo,RedirectAttributes rttr)throws Exception{
		logger.info("ClassRoom Register.........................");
		logger.info("ClassRoom vo : " + vo);
		classroomService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/classroomview")
	public void ClassroomViewGET(@RequestParam("roomname") String roomname, Model model) throws Exception{
			logger.info("Classroom view...........");
			logger.info("roomname : " + roomname);
			model.addAttribute("classroomVO", classroomService.view(roomname));
	}
	
	@PostMapping("/classroommodify")
	public String ClassroomModifyPOST(ClassroomVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("Classroom Modify........");
		logger.info("Classroom : " + vo);
		classroomService.modify(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@PostMapping("/classroomremove")
	public String ClassroomRemove(String roomname,RedirectAttributes rttr) throws Exception{
		logger.info("Classroom Remove..............");
		logger.info("Classroom roomname : " + roomname);
		classroomService.remove(roomname);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/subjectregister")
	public void SubjectCreateGET() throws Exception{
		logger.info("Teacher Create.....");
	}
	
	@PostMapping("/subjectregister")
	public String SubjectRegisterPOST(SubjectVO vo,RedirectAttributes rttr)throws Exception{
		logger.info("Subject Register.........................");
		logger.info("Subject vo : " + vo);
		subjectService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/subjectview")
	public void SubjectViewGET(@RequestParam("subno") Integer subno, Model model) throws Exception{
			logger.info("subject view...........");
			logger.info("subject : " + subno);
			model.addAttribute("subjectVO", subjectService.view(subno));
	}
	
	@PostMapping("/subjectmodify")
	public String SubjectModifyPOST(SubjectVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("subject Modify........");
		logger.info("subject : " + vo);
		subjectService.modify(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@PostMapping("/subjectremove")
	public String SubjectRemove(Integer subno,RedirectAttributes rttr) throws Exception{
		logger.info("subject Remove..............");
		logger.info("subject subno : " + subno);
		subjectService.remove(subno);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	
	@GetMapping("/pictureRegister")
	public void picturePage(String sid , Model model)throws Exception{
		logger.info("picture called.............");
		logger.info("sid : " + sid);
		model.addAttribute("sid" , sid);
		
	}
	
	
	@PostMapping("/pictureRegister")
	public String pictureRegister(String[] persistedId , String sid , RedirectAttributes rttr)throws Exception{
		
	
		logger.info("pictureReg called......");	
		

		logger.info("persistedId :" + persistedId);
		
		logger.info("sid : " + sid);
		ImageVO vo = new ImageVO();
		
		for(int i = 0 ; i < persistedId.length ; i ++){
			
			vo.setSid(sid);
			vo.setPersistedfaceid(persistedId[i]);
			logger.info("vo :" + vo );
			imageService.register(vo);
			logger.info("========================");
		}
		rttr.addFlashAttribute("result" , "success");
		
		return "redirect:list";
		

	}
	
	@GetMapping("/teachersubjectregister")
	public void TeachersubjectCreateGET(Model model) throws Exception{
		logger.info("TeacherSubject Create.....");
		model.addAttribute("teacherVO", teacherService.getTeacherList());
		model.addAttribute("subjectVO", subjectService.getSubjectList());
	}
	
	@PostMapping("/teachersubjectregister")
	public String TeachersubjectRegisterPOST(String tid,String subno,TeacherSubjectVO vo,RedirectAttributes rttr)throws Exception{
		logger.info("TeacherSubject Register.........................");
		logger.info("TeacherVO vo : " + tid);
		logger.info("SubjectVO vo : " + subno);
		vo.setTid(tid);
		vo.setSubno(Integer.decode(subno));
		logger.info("TeacherSubjectVO vo : " + vo);
		
		teacherSubjectService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/teachersubjectview")
	public void TeacherSubjectViewGET(@RequestParam("tsno") Integer tsno, Model model) throws Exception{
			logger.info("teachersubject view...........");
			logger.info("teachersubject : " + tsno);
			model.addAttribute("teachersubjectVO", teacherSubjectService.getTeacherSubject(tsno));
	}
	
	@GetMapping("/overview")
	public void OverViewGET(Criteria cri, Model model)throws Exception{
		logger.info("OverView Start ........................");
		model.addAttribute("allTodayCheck",checkService.getAllTodayCheck());
		
		List<CheckTimeVO> result = checkService.getAllTodayEmotion();
		
		model.addAttribute("allEmotionList", emotionUtils.emotionCounter(result));
		
		model.addAttribute("allCheck", checkService.getAllCheck());
		cri.setPerPageNum(15);
		
		model.addAttribute("allTodayCheckTime",checkService.getAllTodayCheckTime(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(130);
		
		pageMaker.setTotal(checkService.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
}
