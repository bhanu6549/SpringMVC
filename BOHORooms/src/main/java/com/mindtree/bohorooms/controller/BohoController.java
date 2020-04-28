package com.mindtree.bohorooms.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bohorooms.dto.BohoDTO;
import com.mindtree.bohorooms.dto.ResponseBody;
import com.mindtree.bohorooms.dto.UserDTO;
import com.mindtree.bohorooms.entity.BOHO;
import com.mindtree.bohorooms.entity.Room;
import com.mindtree.bohorooms.entity.User;
import com.mindtree.bohorooms.exception.BOHORoomsApplicationException;
import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;
import com.mindtree.bohorooms.service.BohoService;

@RestController
public class BohoController {
	@Autowired
	private BohoService bohoService;
	@Autowired
	private ModelMapper modelmapper;

	@PostMapping("/bohos")
	public ResponseEntity<?> addBoho(@Valid @RequestBody BohoDTO boho) throws BOHORoomsApplicationException {

		BOHO clientInputDTOToEntity = modelmapper.map(boho, BOHO.class);
		BOHO serviceOutputEntity = bohoService.addBoho(clientInputDTOToEntity);
		BohoDTO outputStoreDTOToSend = modelmapper.map(serviceOutputEntity, BohoDTO.class);
		return new ResponseEntity<ResponseBody<BohoDTO>>(
				new ResponseBody<BohoDTO>(outputStoreDTOToSend, null, "BOHO Added Successfully", true), HttpStatus.OK);

	}
	
	@GetMapping("/bohos/{userId}")
	public ResponseEntity<?> displayAllLivingFacility(@PathVariable long userId ) throws BOHORoomsApplicationException{
		List<BOHO> map=bohoService.displayAllFacilities(userId);
		 return new ResponseEntity<List<BOHO>>(map, HttpStatus.OK);
}
	@GetMapping("/boho/{bohoId}")
	public int displayBoho(@PathVariable long bohoId){
		int result=bohoService.displayBoho(bohoId);
		return result;
		 
	}
	
	@GetMapping("/getboho/{userId}")
	public ResponseEntity<?> displayLivingFacility(@PathVariable long userId ) throws BOHORoomsApplicationException{
		List<Room> map=bohoService.getFacilities(userId);
		 return new ResponseEntity<List<Room>>(map, HttpStatus.OK);
}
	
}