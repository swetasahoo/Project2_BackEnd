package com.stackroute.activitystream.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.stackroute.activitystream.BackendService.ServiceApplication;
import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;

@RunWith(SpringRunner.class)
//@SpringBootApplication(scanBasePackages = { "com.stackroute.activitystream.BackendService" })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
@TestPropertySource(properties = "debug=true")
@EnableAutoConfiguration
public class UserTest {

	@Autowired
	User user;

	@Autowired
	UserDao userDAO;

	@Ignore
	@Test(expected = DataIntegrityViolationException.class)
	public void createUserTestCase() {

		user.setName("sofia");
		user.setEmailId("sofi@gmail.com");
		user.setPassword("password");
		user.setAddress("chennai");
		user.setPhoneNo("9856463258");

		
		assertEquals(true, userDAO.save(user));
		
	}
	@Ignore
	@Test
	public void updateUser_Success() {

		user.setEmailId("amit@gmail.com");
		user.setAddress("kolkata");
		assertEquals(true, userDAO.update(user));
		

	}
	@Ignore
	@Test
	public void updateUser_Fail() {

		user.setEmailId("abc@gmail.com");
		user.setAddress("kolkata");
		assertNotEquals(true, userDAO.update(user));
		

	}
	@Ignore
	@Test
	public void userExist_Success() {

		assertEquals(true, userDAO.isUserExist("sweta@gmail.com"));

	}
	@Ignore
	@Test
	public void userExist_Fail() {

		assertNotEquals(true, userDAO.isUserExist("abc@gmail.com"));

	}
	@Ignore
	@Test
	public void getUserbyEmailId_Success()
	{
		
		assertNotNull(userDAO.get("rakesh@gmail.com"));
	}
	@Ignore
	@Test
	public void getUserbyEmailId_Fail()
	{
		
		assertNull(userDAO.get("amiya@gmail.com"));
	}
	@Test
	public void getUserList_Success()
	{
		assertNotNull(userDAO.list());
		
		
	
	}
	@Ignore
	@Test
	public void checkAuthentication() {
		user = userDAO.validate("sweta@gmail.com", "password");
		String actualValue = "sweta@gmail.com";
		String expectValue = user.getEmailId();
		assertEquals("Login Successfull", expectValue, actualValue);

	}
	@Ignore
	@Test
	public void checkAuthentication_Fail() {
		user = userDAO.validate("sweta@gmail.com", "password");
		String actualValue = "priti@gmail.com";
		String expectValue = user.getEmailId();
		assertNotEquals("Login unSuccessfull", expectValue, actualValue);

	}
	@Ignore
	@Test
	public void checkAuthenticationByWrongCredentials() {
		
		assertNull(userDAO.validate("sweta@gmail.com", "p@ssword"));
	}
	@Ignore
	@Test
	public void checkAuthenticationByNullUserName() {
		
		assertNull(userDAO.validate("", "password"));
	}

	@Ignore
	@Test
	public void checkAuthenticationByNullPassword() {
		
		assertNull(userDAO.validate("sweta@gmail.com", ""));
	}

}
