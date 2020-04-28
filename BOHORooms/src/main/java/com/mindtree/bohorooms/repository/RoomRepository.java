package com.mindtree.bohorooms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bohorooms.entity.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	Optional<Room> findByRoomName(String roomName);

}
