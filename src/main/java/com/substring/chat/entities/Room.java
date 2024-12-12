package com.substring.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
public class Room {
    @Id
    private String id;//Mongo db : unique identifier
    private String roomId;
    private List<Message> messages = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Room(String id, String roomId, List<Message> messages) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.messages = messages;
	}
	public Room() {
		super();
	}
	
	


}
