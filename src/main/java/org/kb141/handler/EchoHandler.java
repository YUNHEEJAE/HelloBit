package org.kb141.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class EchoHandler extends TextWebSocketHandler {
   

	private List<WebSocketSession> connectedUsers;

	public EchoHandler() {
		connectedUsers = new ArrayList<WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// super.afterConnectionEstablished(session);
		System.out.println(session.getId() + "님이 접속하셨습니다.");
		System.out.println("연결 IP: " + session.getRemoteAddress().getHostName());
		connectedUsers.add(session);
		
		for (WebSocketSession webSocketSession : connectedUsers) {
			System.out.println(webSocketSession);
			if (!session.getId().equals(webSocketSession.getId())) {
				webSocketSession.sendMessage(
						new TextMessage(session.getId() + "님이 접속하셨습니다." ));
			}
		}

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// super.handleTextMessage(session, message);
		// Payload : 사용자가 보낸 메시지
		System.out.println(session.getId() + "님이 메시지를 전송하셨습니다.");
		System.out.println(message.getPayload());

		for (WebSocketSession webSocketSession : connectedUsers) {
			System.out.println(webSocketSession);
			if (!session.getId().equals(webSocketSession.getId())) {
				webSocketSession.sendMessage(
						new TextMessage(session.getRemoteAddress().getHostName() + " : " + message.getPayload()));
			}
		}

	}

	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// super.afterConnectionClosed(session, status);
		System.out.println(session.getId() + "님이 접속을 종료하셨습니다.");
		
		
		connectedUsers.remove(session);
		for (WebSocketSession webSocketSession : connectedUsers) {
			System.out.println(webSocketSession);
			if (!session.getId().equals(webSocketSession.getId())) {
				webSocketSession.sendMessage(
						new TextMessage(session.getId() + "님이 퇴장하셨습니다." ));
			}
		}
		
		
	}

}
