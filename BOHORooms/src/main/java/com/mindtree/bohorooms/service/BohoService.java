package com.mindtree.bohorooms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;

public interface BohoService {

	BOHO addBoho(BOHO clientInputDTOToEntity) throws BOHORoomsServiceApplicationException;

	BOHO getBohoById(long bohoId) throws BOHORoomsServiceApplicationException;

	List<BOHO> displayAllFacilities(long userId) throws BOHORoomsServiceApplicationException;

	int displayBoho(long bohoId);

	List<Room> getFacilities(long userId) throws BOHORoomsServiceApplicationException;

}
