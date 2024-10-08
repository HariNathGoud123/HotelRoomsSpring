/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */
package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.repository.RoomRepository;
import com.example.nxtstayz.repository.RoomJpaRepository;
import com.example.nxtstayz.repository.HotelJpaRepository;

@Service
public class RoomJpaService implements RoomRepository {
	@Autowired
	RoomJpaRepository roomJpaRepository;
	@Autowired
	HotelJpaRepository hotelJpaRepository;

	@Override
	public ArrayList<Room> getRooms() {
		List<Room> roomList = roomJpaRepository.findAll();
		return new ArrayList<>(roomList);
	}

	@Override
	public Room getRoomById(int roomId) {
		try {
			Room room = roomJpaRepository.findById(roomId).get();
			return room;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Room addRoom(Room room) {
		Hotel hotel = room.getHotel();
		int hotelId = hotel.getHotelId();
		try {
			Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
			room.setHotel(newHotel);
			roomJpaRepository.save(room);
			return room;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Room updateRoom(int roomid, Room room) {
		try {
			Room newRoom = roomJpaRepository.findById(roomid).get();
			if (room.getRoomNumber() != null) {
				newRoom.setRoomNumber(room.getRoomNumber());
			}
			if (room.getRoomType() != null) {
				newRoom.setRoomType(room.getRoomType());
			}
			if (room.getPrice() != 0) {
				newRoom.setPrice(room.getPrice());
			}
			if (room.getHotel() != null) {
				int hotelid = room.getHotel().getHotelId();
				Hotel newHotel = hotelJpaRepository.findById(hotelid).get();
				newRoom.setHotel(newHotel);
			}
			roomJpaRepository.save(newRoom);
			return newRoom;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteRoom(int roomId) {
		try {
			roomJpaRepository.deleteById(roomId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Hotel getRoomHotel(int roomId) {
		try {
			Room room = roomJpaRepository.findById(roomId).get();
			return room.getHotel();

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
