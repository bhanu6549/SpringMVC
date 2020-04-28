package com.mindtree.bohorooms.controller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bohorooms.dto.ResponseBody;
import com.mindtree.bohorooms.dto.RoomDTO;
import com.mindtree.bohorooms.dto.UserDTO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.BOHORoomsApplicationException;
import com.mindtree.bohorooms.service.RoomService;
import com.mindtree.bohorooms.service.UserService;

@RestController
public class RoomController {
	@Autowired
	private RoomService roomservice;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private UserService userService;

	@PostMapping("/rooms/{bohoId}")
	public ResponseEntity<?> addRoom(@Valid @RequestBody RoomDTO room,@PathVariable long bohoId) throws BOHORoomsApplicationException {
		
	
		return new ResponseEntity<ResponseBody<RoomDTO>>(new ResponseBody<RoomDTO>(
				modelmapper.map(roomservice.addRoom(modelmapper.map(room, Room.class), bohoId), RoomDTO.class),
				null, "Rooms Added Successfully", true), HttpStatus.OK);
	
}
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> checkOut(@PathVariable long userId) throws BOHORoomsApplicationException {
		roomservice.checkOut(userId);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "User Successfully checkOut", true), HttpStatus.OK);
	}
	
	@PostMapping("/checkinuser/{roomId}")
	public ResponseEntity<?> checkInUser(@PathVariable long roomId, @Valid @RequestBody UserDTO user)
			throws BOHORoomsApplicationException {

		return new ResponseEntity<ResponseBody<UserDTO>>(new ResponseBody<UserDTO>(
				modelmapper.map(userService.checkInUser(modelmapper.map(user, User.class), roomId), UserDTO.class),
				null, "User Checked in Successfully", true), HttpStatus.OK);
	}
}
