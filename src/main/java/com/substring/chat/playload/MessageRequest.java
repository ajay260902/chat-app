package com.substring.chat.playload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;
    
    
	public String getRoomId() {
		return roomId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public MessageRequest(String content, String sender, String roomId) {
		super();
		this.content = content;
		this.sender = sender;
		this.roomId = roomId;
	}
	public MessageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


}
