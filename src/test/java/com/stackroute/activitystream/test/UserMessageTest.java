package com.stackroute.activitystream.test;

/*import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;*/
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.BackendService.ServiceApplication;
import com.stackroute.activitystream.dao.MessageDao;
import com.stackroute.activitystream.dao.UserMessageDao;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserMessage;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
@TestPropertySource(properties = "debug=true")
@EnableAutoConfiguration
public class UserMessageTest {

	

	@Autowired
	 UserMessage userMessage;

	@Autowired
	 UserMessageDao userMessageDAO;
	
	@Ignore
	@Test
	public void getMyMessage_Success()
	{
	
	assertFalse(userMessageDAO.getMyMessage("sweta@gmail.com").isEmpty());
	}
	@Ignore
	@Test
	public void getMyMessage_Fail()
	{
	assertTrue(userMessageDAO.getMyMessage("xyz@gmail.com").isEmpty());
	}
	
	@Test
	public void sendMessage_Success()
	{
		userMessage.setMessageSize(50);
		userMessage.setSenderEmailId("sweta@gmail.com");
		userMessage.setReceiverEmailId("mitali@gmail.com");
		userMessage.setTextMessage("tomorrow at 1pm concall");
		userMessage.setSentDate(new Date());
		userMessage.setMessageType("text");
		assertEquals(true, userMessageDAO.sendMessage(userMessage));
		
	}
	@Ignore
	@Test
	public void sendMessage_Fail()
	{
		userMessage.setMessageSize(50);
		userMessage.setSenderEmailId("sweta@gmail.com");
		userMessage.setReceiverEmailId(" ");
		userMessage.setTextMessage("tomorrow at 1pm concall");
		userMessage.setSentDate(new Date());
		userMessage.setMessageType("text");
		assertEquals(false, userMessageDAO.sendMessage(userMessage));
		
	}
	@Ignore
	@Test
	public void deleteMessage_Success()
	{
		
		assertEquals(true, userMessageDAO.deleteMessage(2,"sweta@gmail.com"));
	}
	@Ignore
	@Test
	public void deleteMessage_Fail()
	{
		assertNotEquals(true, userMessageDAO.deleteMessage(5,"sweta@gmail.com"));
	}
	@Ignore
	@Test
	public void getMessageByMessageId_Success()
	{
		assertNotNull(userMessageDAO.getMessageByMessageId(2));
		
		
	}
	@Ignore
	@Test
	public void getMessageByMessageId_Fail()
	{
		assertNull(userMessageDAO.getMessageByMessageId(102));
	}


	
}
