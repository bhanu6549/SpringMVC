package com.mindtree.bohorooms.service;

import java.util.List;
import java.util.Map;

import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;

public interface UserService {
User addUser(User map, long roomId) throws BOHORoomsServiceApplicationException;

Map<Integer, User> displayAllUsers(long bohoId) throws BOHORoomsServiceApplicationException;

Map<Integer, BOHO> getAllHotels(double price);

User getUserbyId(long userId) throws BOHORoomsServiceApplicationException;

User checkInUser(User map, long roomId) throws BOHORoomsServiceApplicationException;



void checkOut(long roomId) throws BOHORoomsServiceApplicationException;

//void checkOutWithRating(long userId, long bohoId, float rating) throws BOHORoomsServiceApplicationException;

void checkOutWithRating(long userId, long bohoId, float rating) throws BOHORoomsServiceApplicationException;



}
