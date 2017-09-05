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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.stackroute.activitystream.BackendService.ServiceApplication;
import com.stackroute.activitystream.dao.CircleDao;
import com.stackroute.activitystream.model.Circle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
@TestPropertySource(properties = "debug=true")
@EnableAutoConfiguration
public class CircleTest {

	@Autowired
	Circle circle;

	@Autowired
	CircleDao circleDAO;

	@Ignore
	@Test(expected = DataIntegrityViolationException.class)
	public void addCircleTestCase() {
		circle.setCircleName("NewCircle");
		circle.setCreatedBy("mitali11@gmail.com");
		circle.setDate();
		circle.setStatus("active");
		assertEquals(true, circleDAO.addCircle(circle));

	}

	@Ignore
	@Test
	public void removeCircleTestCase_Success() {
		circle.setCircleName("doc");
		assertEquals(true, circleDAO.removeCircle(circle));

	}
	@Ignore
	@Test
	public void removeCircleTestCase_Fail() {
		circle.setCircleName("aaa");
		assertNotEquals(true, circleDAO.removeCircle(circle));

	}

	@Ignore
	@Test
	public void getCircleByUserTestCase_Success() {
		circle.setCreatedBy("sweta@gmail.com");
		assertFalse(circleDAO.getCircleByUser(circle.getCreatedBy()).isEmpty());

	}

	@Ignore
	@Test
	public void getCircleByUserTestCase_Fail() {
		circle.setCreatedBy("xyz@gmail.com");
		assertTrue( circleDAO.getCircleByUser(circle.getCreatedBy()).isEmpty());

	}

	@Ignore
	@Test
	public void getAllCircleTestCase() {

		assertNotNull(circleDAO.getAllCircles());

	}

}
