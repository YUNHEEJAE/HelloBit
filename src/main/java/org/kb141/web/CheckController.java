package org.kb141.web;

import javax.inject.Inject;

import org.kb141.service.CheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check/*")
public class CheckController {
	private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

	@Inject
	private CheckService service;
	
	
	

}
