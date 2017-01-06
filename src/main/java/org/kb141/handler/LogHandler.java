package org.kb141.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@CrossOrigin
@Configuration
@EnableWebSocket
public class LogHandler extends TextWebSocketHandler implements WebSocketConfigurer  {
	
	private List<WebSocketSession> connectedUsers;
	
	public LogHandler(){
		connectedUsers = new ArrayList<WebSocketSession>();
	}
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry wsh) {
			wsh.addHandler(logHandler(), "/logWebsocket").setAllowedOrigins("http://localhost:8081/web");
		
	}
	@Bean
	public WebSocketHandler logHandler(){

		return new LogHandler();
	}
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
				System.out.println(session.getId());
				connectedUsers.remove(session);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "님이 접속하셨습니다.");
		System.out.println("연결 IP: " + session.getRemoteAddress().getHostName());
		connectedUsers.add(session); 
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			System.out.println(message.getPayload());
		
			for (WebSocketSession webSocketSession : connectedUsers) {
				System.out.println(webSocketSession);
				if (!session.getId().equals(webSocketSession.getId())) {
					webSocketSession.sendMessage(
							new TextMessage(message.getPayload()));
				}
			}
					
	}




	
}
