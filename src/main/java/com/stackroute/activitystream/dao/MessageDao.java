package com.stackroute.activitystream.dao;



import java.util.List;

import com.stackroute.activitystream.model.Message;

//1
//Actually two daos are not required - MessageDao and UserMessageDao
//  But two tables are required. ( message and user_message)
//  At the time of sending the message, store the information in both the tables.
//  At the time of reading/deleting use user_message table.

//2
//If you want to keep two separate daos
//use MessageDao for sending the message (but store in both the tables.)
//use UserMEssageDao for retreving and deleting the message.

public interface MessageDao {

boolean sendMessage(Message message);
  //This method will return all the messages.  Need to return only the messages related to me.
  //So need to pass email id.  One should not able to read other's messages.
List<Message> getAllMessages();
List<Message> getAllMessageByCircleName(String circleName);
  
  //Need to use pagination concept.
}
