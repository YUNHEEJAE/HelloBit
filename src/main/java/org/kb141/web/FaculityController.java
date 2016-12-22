package org.kb141.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.FaculityVO;
import org.kb141.service.FaculityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/faculity")
public class FaculityController {
	
	private static final Logger logger = LoggerFactory.getLogger(FaculityController.class);
	
	@Inject
	private FaculityService faculityService;
	

	@GetMapping(value="/faculitylist",produces="application/json")
	@ResponseBody
	public List<FaculityVO> faculitylist(Model model) throws Exception{
		
		logger.info("faculity list..........");
		List<FaculityVO> list = new ArrayList<FaculityVO>();
		list = faculityService.getFaculityList();
		logger.info("get list :" + list);
		return list;
		
	}
	
}
