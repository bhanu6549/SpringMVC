package com.mindtree.bohorooms.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bohorooms.dto.ResponseBody;
import com.mindtree.bohorooms.dto.UserDTO;
import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.BOHORoomsApplicationException;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;
import com.mindtree.bohorooms.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private ModelMapper modelmapper;
	

	@PostMapping("/users/{roomId}")
	public ResponseEntity<?> addUser(@PathVariable long roomId, @Valid @RequestBody UserDTO user)
			throws BOHORoomsApplicationException {

		return new ResponseEntity<ResponseBody<UserDTO>>(new ResponseBody<UserDTO>(
				modelmapper.map(userservice.addUser(modelmapper.map(user, User.class), roomId), UserDTO.class), null,
				"User Added Successfully", true), HttpStatus.OK);
	}
	@GetMapping("/users/{bohoId}")

	public ResponseEntity<?> getAllUsers(@PathVariable long bohoId ) throws BOHORoomsApplicationException{
		Map<Integer,User> map=userservice.displayAllUsers(bohoId);
		 return new ResponseEntity<Map<Integer,User>>(map, HttpStatus.OK);
	}
	@RequestMapping(value="/gethotels/{cost}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable double cost ){
		Map<Integer,BOHO> map=userservice.getAllHotels(cost);
		 return new ResponseEntity<Map<Integer,BOHO>>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}/{bohoId}/{rating}")
		public ResponseEntity<?> checkOut(@PathVariable long userId,@PathVariable long bohoId,@PathVariable float rating) throws BOHORoomsApplicationException {
			userservice.checkOutWithRating(userId,bohoId,rating);
			return new ResponseEntity<ResponseBody<Void>>(
					new ResponseBody<Void>(null, null, "User Successfuly checkOut and rated also", true), HttpStatus.OK);
		}
	}

	
	
