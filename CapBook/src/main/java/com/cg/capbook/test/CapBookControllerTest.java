package com.cg.capbook.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.controllers.CapBookController;
import com.cg.capbook.services.CapBookServices;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CapBookController.class, secure = false)

public class CapBookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CapBookServices capBookServices;
	
	UserAccount user=new UserAccount("ap@gmail.com", "Aparajita", "Singh", "1234", "female", "28-09-1995",null);

	String exampleUserJson = "{\"email\":\"ap@gmail.com\",\"firstName\":\"Aparajita \",\"lastName\":\"Singh\",\"password\":\"1234\",\"gender\":\"female\",\"dob\":\"28-09-1995\"}";

	@Test
	public void getUserDetails() throws Exception {

		Mockito.when(
				capBookServices.getUserDetails(Mockito.anyString())).thenReturn(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("getUserDetails").accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{email:ap@gmail.com,firstName:Aparajita,lastName:Singh,password:1234,gender:female,dob:28-09-1995}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


}
