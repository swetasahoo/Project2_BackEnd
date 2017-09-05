package com.stackroute.activitystream.dao;



import java.util.List;

import com.stackroute.activitystream.model.Message;



public interface MessageDao {

boolean sendMessage(Message message);
  //This method will return all the messages.  Need to return only the messages related to me.
  //So need to pass email id.  One should not able to read other's messages.
List<Message> getAllMessages();
List<Message> getAllMessageByCircleName(String circleName);
  
  //Need to use pagination concept.
}
