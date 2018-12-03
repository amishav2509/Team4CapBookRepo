package com.cg.capbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;
import com.cg.capbook.services.CapBookServices;
@RestController
public class CapBookController {
	//String msg=null;
	@Autowired
	private CapBookServices capBookServices;
	@RequestMapping(
			value="/acceptUserDetails",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<String> acceptUserDetails(@RequestBody UserAccount user) throws CapBookServicesDownException{
		capBookServices.acceptUserDetails(user);
		//System.out.println("Yes");
		return new ResponseEntity<>("User Registered successfully",HttpStatus.OK);
	}

	@RequestMapping(
			value="/getUserDetails",
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<UserAccount> getUserDetails(@RequestParam("email") String email,@RequestParam("password") String password) {
		UserAccount user;
		try {
			user = capBookServices.getUserDetails(email);
			if(user.getPassword()!=password){
				String msg="Incorrect password";
			 //return new ResponseEntity<>(msg,HttpStatus.OK);	
			}
			return new ResponseEntity<>(user,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
