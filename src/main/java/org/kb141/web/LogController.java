package org.kb141.web;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.kb141.domain.CheckVO;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
//@ServerEndpoint("/log")
public class LogController {

	@OnOpen
	public void logOpen(){
		System.out.println("log opened...........");
	}
	
	@OnMessage
	public void logMsg(CheckVO vo){
		System.out.println(vo);
	}
	
	
}
