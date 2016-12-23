package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CurriculumVO;
import org.kb141.service.CurriculumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TBL_PROGRAM
 * TBL_CLASSROOM
 * TBL_CURRICULUM
 * @author KB141
 *
 */
@Controller
@RequestMapping("/program")
public class ProgramController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	
	@Inject
	private CurriculumService curriculumService;
	
	@ResponseBody
	@GetMapping(value="/allcurriculumlist", produces="application/json")
	public List<CurriculumVO> allCurriculumList() throws Exception {
		logger.info("커리큘럼 전체 리스트");
		return curriculumService.getAllCurriculumList();
	}
	
	@ResponseBody
	@GetMapping(value="curriculumlist", produces="application/json")
	public List<CurriculumVO> curriculumList(Integer pno) throws Exception{
		logger.info("커리큘럼 PNO로 검색한 리스트");
		return curriculumService.view(pno);
	}
	
	@PostMapping("/registercurriculum")
	public String registerCurriculum(CurriculumVO vo) throws Exception {
		logger.info("curriculum Register Post...");
		logger.info("VO : " + vo);
		
		curriculumService.register(vo);
				
		return "success";
	}
	
	
}
