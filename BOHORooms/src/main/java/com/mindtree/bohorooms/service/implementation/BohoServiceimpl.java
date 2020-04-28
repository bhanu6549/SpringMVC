package com.mindtree.bohorooms.service.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.BOHORoomsApplicationException;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;
import com.mindtree.bohorooms.exception.service.customexception.BohoAlreadyPresentException;
import com.mindtree.bohorooms.exception.service.customexception.BohoNotFoundException;
import com.mindtree.bohorooms.exception.service.customexception.RoomNotFoundException;
import com.mindtree.bohorooms.exception.service.customexception.UserBookedException;
import com.mindtree.bohorooms.exception.service.customexception.UserNotFoundException;
import com.mindtree.bohorooms.repository.BohoRepository;
import com.mindtree.bohorooms.repository.RoomRepository;
import com.mindtree.bohorooms.repository.UserRepository;
import com.mindtree.bohorooms.service.BohoService;

@Service
public class BohoServiceimpl implements BohoService {
	@Autowired
	private BohoRepository bohorepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private RoomRepository roomrepository;

	@Override
	public BOHO addBoho(BOHO boho) throws BOHORoomsServiceApplicationException {

		return bohorepository.save(boho);

	}

	@Override
	public BOHO getBohoById(long bohoId) throws BOHORoomsServiceApplicationException {
		return bohorepository.findById(bohoId).orElseThrow(() -> new BohoNotFoundException("BOHO Not Present"));
	}

	@Override
	public List<BOHO> displayAllFacilities(long userId) throws BOHORoomsServiceApplicationException {
		User user = userrepository.findAll().stream().filter(i -> i.getUserId() == userId).findAny()
				.orElseThrow(() -> new UserNotFoundException("User Id Not Found"));
		List<BOHO> bohos = bohorepository.findAll();

		return bohos;

	}

	@Override
	public int displayBoho(long bohoId) {
		BOHO b=bohorepository.findById(bohoId).get();
		List<Room> room =b.getRooms();
		return room.stream().map(e->e.getCost()).reduce(0,(ans,i)->(ans+i));
	}

	@Override
	public List<Room> getFacilities(long userId) throws BOHORoomsServiceApplicationException {
		User user = userrepository.findAll().stream().filter(i -> i.getUserId() == userId).findAny()
				.orElseThrow(() -> new UserNotFoundException("User Id Not Found"));
		List<Room> bohos = roomrepository.findAll();
		List<User> use=userrepository.findAll();
		for (User r : use) {
			if(r.getUserId()>2) {
				return bohos;
			}
				
		}
		throw new UserBookedException("User bokked only one room");
		
		
		
	}
}
