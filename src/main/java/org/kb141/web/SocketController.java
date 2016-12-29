package org.kb141.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socket")
public class SocketController {
	      
	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	@GetMapping("/chatting")
	public String viewChattingPage() {
		logger.info("CHATTING........");
		return "socket/chatting";
	}

}
