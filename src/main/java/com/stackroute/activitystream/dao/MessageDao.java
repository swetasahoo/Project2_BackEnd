package com.stackroute.activitystream.dao;



import java.util.List;

import com.stackroute.activitystream.model.Message;



public interface MessageDao {

boolean sendMessage(Message message);
List<Message> getAllMessages();
List<Message> getAllMessageByCircleName(String circleName);
}
