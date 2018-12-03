package com.cg.capbook.controllers;

import javax.servlet.http.HttpSession;

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
	public ResponseEntity<String> acceptUserDetails(@RequestBody UserAccount user,HttpSession session) throws CapBookServicesDownException{
		capBookServices.acceptUserDetails(user);
		session.setAttribute("user", user);
		System.out.println("Yes");
		return new ResponseEntity<>("User Registered successfully",HttpStatus.OK);
	}

	@RequestMapping(
			value="/getUserDetails",
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<UserAccount> getUserDetails(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session){
		UserAccount user;
		try {
			user = capBookServices.getUserDetails(email);
			if(user.getPassword().equals(password)){
				session.setAttribute("user", user);
			 return new ResponseEntity<>(user,HttpStatus.OK);	
			}
			return new ResponseEntity<>(null,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(
			value="/changePassword",
					method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE
			
			)
	public ResponseEntity<UserAccount> changePassword(@RequestParam("email") String email, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,HttpSession session){
		UserAccount user;
		try {
			user = capBookServices.getUserDetails(email);
			if(user.getPassword().equals(oldPassword)){
				//session.setAttribute("user", user);
				capBookServices.changePassword(user, newPassword);
			 return new ResponseEntity<>(user,HttpStatus.OK);	
			}
			return new ResponseEntity<>(null,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
