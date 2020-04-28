package com.mindtree.bohorooms.service;

import java.util.List;

import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;

public interface RoomService {

	Room addRoom(Room room, long bohoId) throws BOHORoomsServiceApplicationException;

	Room getRoomById(long roomId) throws BOHORoomsServiceApplicationException;

	//void checkOut(long userId);

	void checkOut( long userId) throws BOHORoomsServiceApplicationException;



}
