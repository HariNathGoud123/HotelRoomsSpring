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
import com.example.nxtstayz.repository.HotelRepository;
import com.example.nxtstayz.repository.HotelJpaRepository;
import com.example.nxtstayz.repository.RoomJpaRepository;

@Service
public class HotelJpaService implements HotelRepository {
	@Autowired
	HotelJpaRepository hotelJpaRepository;
	@Autowired
	RoomJpaRepository roomJpaRepository;

	@Override
	public ArrayList<Hotel> getHotels() {
		List<Hotel> hotelList = hotelJpaRepository.findAll();
		return new ArrayList<>(hotelList);
	}

	@Override
	public Hotel getHotelById(int hotelid) {
		try {
			Hotel hotel = hotelJpaRepository.findById(hotelid).get();
			return hotel;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		hotelJpaRepository.save(hotel);
		return hotel;
	}

	@Override
	public Hotel updateHotel(int hotelid, Hotel hotel) {
		try {
			Hotel newHotel = hotelJpaRepository.findById(hotelid).get();
			if (hotel.getHotelName() != null) {
				newHotel.setHotelName(hotel.getHotelName());
			}
			if (hotel.getLocation() != null) {
				newHotel.setLocation(hotel.getLocation());
			}
			if (hotel.getRating() != 0) {
				newHotel.setRating(hotel.getRating());
			}
			hotelJpaRepository.save(newHotel);
			return newHotel;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteHotel(int hotelid) {
		try {
			hotelJpaRepository.deleteById(hotelid);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}

	@Override
	public List<Room> getHotelRooms(int hotelid) {
		try {
			Hotel hotel = hotelJpaRepository.findById(hotelid).get();
			return roomJpaRepository.findByHotel(hotel);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}