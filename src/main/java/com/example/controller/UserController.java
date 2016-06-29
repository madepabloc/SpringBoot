package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.model.UserDao;
import com.google.gson.Gson;



@Controller
@EnableAutoConfiguration
public class UserController {
	
	
	@Autowired(required = true)
	UserDao userDao;

	
	
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello World";
	}
	

	
	@RequestMapping(value = "/getAllUsers",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAllUsers(){
		Gson gson = new Gson();
		Collection<User> users = (Collection<User>) userDao.findAll();
	 	return new ResponseEntity<String>(gson.toJson(users), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getUserByEmail(
			@RequestParam(value="email") String email){		
		Gson gson = new Gson();
		
		User user = (User) userDao.findByEmail(email);
		
 		if (user != null){
 			return new ResponseEntity<String>(gson.toJson(user), HttpStatus.OK);
 		}else{
 			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
 		}		 		
	}
	

}
