package com.stackroute.activitystream.dao;

import java.util.List;


import com.stackroute.activitystream.model.UserMessage;



public interface UserMessageDao {
	boolean sendMessage(UserMessage userMessage);
	boolean deleteMessage(int messageId, String emailId);
	List<UserMessage> getMyMessage(String emailId);//done
	UserMessage getMessageByMessageId(int messageId);
}
