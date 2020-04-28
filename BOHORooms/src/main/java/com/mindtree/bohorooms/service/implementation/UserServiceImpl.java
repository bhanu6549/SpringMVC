package com.mindtree.bohorooms.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bohorooms.dto.BohoUserDTO;
import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;
import com.mindtree.bohorooms.exception.service.customexception.BohoNotFoundException;
import com.mindtree.bohorooms.exception.service.customexception.RoomNotFoundException;
import com.mindtree.bohorooms.exception.service.customexception.UserAlreadyPresentException;
import com.mindtree.bohorooms.exception.service.customexception.UserNotFoundException;
import com.mindtree.bohorooms.repository.BohoRepository;
import com.mindtree.bohorooms.repository.RoomRepository;
import com.mindtree.bohorooms.repository.UserRepository;
import com.mindtree.bohorooms.service.BohoService;
import com.mindtree.bohorooms.service.RoomService;
import com.mindtree.bohorooms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private RoomService roomservice;
	@Autowired
	private BohoService bohoservice;
	@Autowired
	private BohoRepository bohorepository;
	@Autowired
	private RoomRepository roomrepository;
	

	@Override
	public User addUser(User user, long roomId) throws BOHORoomsServiceApplicationException {
	
		Room room = roomservice.getRoomById(roomId);
		if (userrepository.findByUserName(user.getUserName()).isPresent())
			throw new UserAlreadyPresentException("User name Is Already Present");
	
		room.setUser(user);
		userrepository.save(user);
		return userrepository.findByUserName(user.getUserName()).get();
	}

	@Override
	public Map<Integer, User> displayAllUsers(long bohoId) throws BOHORoomsServiceApplicationException {
		Map<Integer,User> map=new HashMap<Integer, User>();
		List<Room> rooms=roomrepository.findAll();
		List<User> users=new ArrayList<User>();
		for(Room room:rooms) {
			if(room.getBoho().getBohoId()==bohoId) {
				User user=room.getUser();
				
				map.put((int) user.getUserId(), user);
			}
			
			
		}
		
		return map;
	}

	@Override
	public Map<Integer, BOHO> getAllHotels(double cost) {
		List<BOHO> hotel=bohorepository.findAll();
		Map<Integer,BOHO> map=new TreeMap<Integer, BOHO>();
		List<Room> rooms=roomrepository.findAll();
		for(BOHO h:hotel) {
			int sum=0;
			for(Room r:rooms) {
				if(r.getBoho().getBohoId()==h.getBohoId())
					sum+=r.getCost();
			}
			if(sum>cost) {
				map.put( (int) h.getBohoId(), h);
			}
		}
		return map;
	}

	@Override
	public User getUserbyId(long userId) throws BOHORoomsServiceApplicationException  {

		return userrepository.findById(userId).orElseThrow(()->new UserNotFoundException("User IS not found"));
	}

	@Override
	public User checkInUser(User user, long roomId) throws BOHORoomsServiceApplicationException {
		Room room = roomservice.getRoomById(roomId);
		if (userrepository.findByUserName(user.getUserName()).isPresent())
			throw new UserAlreadyPresentException("User name Is Already Present");
	
		room.setUser(user);
		userrepository.save(user);
		return userrepository.findByUserName(user.getUserName()).get();
	}

	@Override
	public void checkOut(long userId) throws BOHORoomsServiceApplicationException {
		User user = userrepository.findAll().stream().filter(i -> i.getUserId() == userId).findAny()
				.orElseThrow(() -> new UserNotFoundException("User Id Not Present"));
		userrepository.delete(user);
		
	}

	@Override
	public void checkOutWithRating(long userId,long bohoId, float rating) throws BOHORoomsServiceApplicationException {
		User user = userrepository.findAll().stream().filter(i -> i.getUserId() == userId).findAny()
				.orElseThrow(() -> new UserNotFoundException("User Id Not Present"));
		
		BOHO boho = bohorepository.findAll().stream().filter(i -> i.getBohoId() == bohoId).findAny()
				.orElseThrow(() -> new BohoNotFoundException("Boho Id Not Present"));
	
		
		boho.setRating(rating);
		
		userrepository.delete(user);
		
		
	}
	}

	

