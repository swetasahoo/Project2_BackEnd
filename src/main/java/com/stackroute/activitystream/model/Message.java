package com.stackroute.activitystream.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="message")
@Component
//public class Message extends ResourceSupport  implements Serializable {

public class Message implements Serializable
{
	
	@Id
	@GeneratedValue
	private int messageId;
	private String textMessage;
	private String senderEmailId;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date messageDate;
	private long messageSize;
	private long messageMaxSize;
	private String messageType;
	private String  circleName;
	
	//where is receiverEmailID ?  User can send message one-to-one.
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getTextMessage() {
		return textMessage;	
		
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public long getMessageSize() {
		return messageSize;
	}
	public void setMessageSize(long messageSize) {
		this.messageSize = messageSize;
	}
	public long getMessageMaxSize() {
		return messageMaxSize;
	}
	public void setMessageMaxSize(long messageMaxSize) {
		this.messageMaxSize = messageMaxSize;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	
	
	
	

}
