package com.stackroute.activitystream.test;


import static org.junit.Assert.*;
import java.util.List;
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
import com.stackroute.activitystream.dao.UserCircleDao;
import com.stackroute.activitystream.model.UserCircle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
@TestPropertySource(properties = "debug=true")
@EnableAutoConfiguration
public class UserCircleTest {

	@Autowired
	 UserCircle userCircle;

	@Autowired
	 UserCircleDao userCircleDAO;

	@Ignore
	@Test
	public void addUserToCircleTestCase_Success() {

		assertEquals(true, userCircleDAO.addUserToCircle("random","pankaj@gmail.com"));
		
	}
	@Ignore
	@Test
	public void addUserToCircleTestCase_Fail() {

		assertNotEquals(true, userCircleDAO.addUserToCircle("doc", "sweta@gmail.com"));
		
	}
	@Ignore
	@Test
	public void removeUserToCircleTestCase_Success() {

		userCircle.setCircleName("doc");
		userCircle.setCircleName("sweta@gmail.com");
		assertEquals(true, userCircleDAO.deleteUserFromCircle(userCircle));
		
	}

	@Test
	public void removeUserToCircleTestCase_Fail() {

		userCircle.setCircleName("unknown");
		userCircle.setCircleName("sweta@gmail.com");
		assertNotEquals(true, userCircleDAO.deleteUserFromCircle(userCircle));
		
	}
	@Ignore
	@Test
	public void getUserByCircleTestCase_Success() {
		
		assertFalse(userCircleDAO.getUserByCircle("doc").isEmpty());
	
	}
	
	@Ignore
	@Test
	public void getUserByCircleTestCase_Failure() {
		
		 assertTrue(userCircleDAO.getUserByCircle("abc").isEmpty());
		 
	
	
	}
}
