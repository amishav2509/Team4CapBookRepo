package com.cg.capbook.test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.daoservices.UserAccountDAO;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;
import com.cg.capbook.services.CapBookServices;
import com.cg.capbook.services.CapBookServicesImpl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CapBookServiceTest {
   @Configuration
	static class CapBookServiceTestContextConfiguration {
	@Bean
	public CapBookServices capBookServices() {
	return new CapBookServicesImpl();
	}
	@Bean
	public UserAccountDAO userAccountDAO() {
	return Mockito.mock(UserAccountDAO.class);
	}
	}

	//We Autowired the UserAccountDAO bean so that it is injected from the configuration
	@Autowired
	private CapBookServices capBookServices;
	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Before
	public void setup() {
	UserAccount user = new UserAccount("ap@gmail.com", "Aparajita", "Singh", "1234", "female", "28-09-1995",null);
	Mockito.when(userAccountDAO.findById("ap@gmail.com")).thenReturn(Optional.of(user));
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void testGetUserDetailsFailure() throws AccountNotFoundException, CapBookServicesDownException {
		capBookServices.getUserDetails("abc@gmail.com");
	}
	@Test()
	public void testGetUserDetailsSuccess() throws AccountNotFoundException, CapBookServicesDownException {
		UserAccount user = capBookServices.getUserDetails("ap@gmail.com");
	assertEquals("Aparajita", user.getFirstName());
	assertEquals("Singh", user.getLastName());
	assertEquals("1234", user.getPassword());
	assertEquals("female", user.getGender());
	assertEquals("28-09-1995", user.getDob());
	}
	
	@After
	public void verify() {
	Mockito.verify(userAccountDAO, VerificationModeFactory.times(1)).findById(Mockito.anyString());
	// This is allowed here: using container injected mocks
	Mockito.reset(userAccountDAO);
	}
}
