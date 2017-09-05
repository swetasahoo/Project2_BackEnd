package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.stackroute.activitystream.BackendService.ServiceApplication;
import com.stackroute.activitystream.dao.MessageDao;
import com.stackroute.activitystream.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
@TestPropertySource(properties = "debug=true")
@EnableAutoConfiguration
public class MessageTest {


	@Autowired
	Message message;

	@Autowired
	MessageDao messageDAO;

	@Ignore
	@Test
	public void sendMessageTestCase_Success() {

		message.setCircleName("doc");
		message.setMessageDate(new Date());
		message.setTextMessage("welcome to stackroute");
		message.setMessageType("text");
		message.setMessageSize(5l);
		message.setSenderEmailId("sweta@gmail.com");	
		assertEquals(true, messageDAO.sendMessage(message));
		
	}

	@Test
	public void sendMessageTestCase_Fail() {
		//check circlename or sender id or reciever id is blank
		message.setCircleName("doc");
		message.setMessageDate(new Date());
		message.setTextMessage("welcome to stackroute");
		message.setMessageType("text");
		message.setMessageSize(5l);
		message.setSenderEmailId("");
		assertEquals(false, messageDAO.sendMessage(message));
		
	}
	public void  getAllMessageByCircleName_Success()
	{
		assertNotNull(messageDAO.getAllMessageByCircleName("random"));
	}
	
	public void  getAllMessageByCircleName_Fail()
	{
		assertNull(messageDAO.getAllMessageByCircleName("UnknowCircle"));
	}
}
