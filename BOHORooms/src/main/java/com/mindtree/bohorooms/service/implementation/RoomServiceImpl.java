package com.mindtree.bohorooms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;
import com.mindtree.bohorooms.exception.service.customexception.RoomAlreadyPresentException;
import com.mindtree.bohorooms.exception.service.customexception.RoomNotFoundException;
import com.mindtree.bohorooms.exception.service.customexception.UserNotFoundException;
import com.mindtree.bohorooms.repository.BohoRepository;
import com.mindtree.bohorooms.repository.RoomRepository;
import com.mindtree.bohorooms.repository.UserRepository;
import com.mindtree.bohorooms.service.BohoService;
import com.mindtree.bohorooms.service.RoomService;
import com.mindtree.bohorooms.service.UserService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomrepository;
	@Autowired
	private BohoRepository bohorepository;
	@Autowired

	private BohoService bohoservice;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userrepository;

	@Autowired
private RoomService roomservice;
	
	@Override
	public Room getRoomById(long roomId) throws BOHORoomsServiceApplicationException {

		return roomrepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException("room Not Present"));
	}

	@Override
	public Room addRoom(Room room, long bohoId) throws BOHORoomsServiceApplicationException {
		BOHO boho = bohoservice.getBohoById(bohoId);
		if (roomrepository.findByRoomName(room.getRoomName()).isPresent())
			throw new RoomAlreadyPresentException("Room name Is Already Present");

		room.setBoho(boho);
		roomrepository.save(room);
		return roomrepository.findByRoomName(room.getRoomName()).get();
	}

	@Override
	public void checkOut(long userId) throws BOHORoomsServiceApplicationException {

			User user = userrepository.findAll().stream().filter(i -> i.getUserId() == userId).findAny()
					.orElseThrow(() -> new UserNotFoundException("User Id Not Present"));
		
			
			userrepository.delete(user);
			
		}
		
	}


	


