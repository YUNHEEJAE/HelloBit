package org.kb141.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.ProgramVO;
import org.kb141.service.CheckService;
import org.kb141.service.ProgramService;
import org.kb141.service.SubjectService;
import org.kb141.service.TakeProgramService;
import org.kb141.service.TeacherService;
import org.kb141.service.TeacherSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private ProgramService programService;
	
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
	public void getMainList(Model model,Integer pno, HttpServletRequest request) throws AccessDeniedException, UnsupportedEncodingException {
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("MY_PROGRAM")){
				String myProgramsComma = URLDecoder.decode(cookie.getValue(),"UTF-8");
				String[] myPrograms = myProgramsComma.split(",");
				boolean flag = true;
				for (String string : myPrograms) {
					if(pno == Integer.parseInt(string)){
						flag = false;
					}
				}
				if(flag){
					throw new AccessDeniedException("HAS NO Authority");
				}
					
			}
		}
		
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
		
		model.addAttribute("attendanceCnt",checkService.getAttendanceCnt(pno));
		model.addAttribute("check", result.size());
		model.addAttribute("late", jigak.size());
		model.addAttribute("absent", total - chulseok.size());
		model.addAttribute("total", total);
		model.addAttribute("lateManList", checkService.getcheckLateMan(pno));
		model.addAttribute("week", checkService.getCheckWeek(pno));
	}
	
	@ResponseBody
	@GetMapping("/myProgram/{tid}")
	public List<ProgramVO> getMyProgramList(@PathVariable("tid") String tid) throws Exception {
		return programService.getTeacherList(tid);
	}
	
	
}
