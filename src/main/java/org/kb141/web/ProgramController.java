package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ProgramVO;
import org.kb141.service.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TBL_PROGRAM TBL_CLASSROOM TBL_CURRICULUM
 * 
 * @author KB141
 *
 */
@Controller
@RequestMapping("/program/")
public class ProgramController {
	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);

	@Inject
	private ProgramService service;

	
	@GetMapping("/list")
	public void list() throws Exception{
		logger.info("PROGRAM LIST.....");
	}
	
	
	@GetMapping("/allList")
	public ResponseEntity<List<ProgramVO>> allList() {
		ResponseEntity<List<ProgramVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ProgramVO>>(service.getProgramList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ProgramVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
