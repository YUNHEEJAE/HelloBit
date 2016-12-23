package org.kb141.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.NoticeVO;
import org.kb141.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	@GetMapping("/noticeBoard")
	public void getNoticeBoard(Model model)throws Exception{
		logger.info("noticeBoard called....");
		
		
		model.addAttribute("list" , noticeService.getNoticeList());	
	}
	
	
	

	
}
