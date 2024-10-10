/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.nxtstayz.service.HotelJpaService;

@RestController
public class HotelController {
  @Autowired
  HotelJpaService hotelJpaService;

  @GetMapping("/hotels")

  public ArrayList<Hotel> getHotels() {
    return hotelJpaService.getHotels();
  }

  @PostMapping("/hotels")
  public Hotel addHotel(@RequestBody Hotel hotel) {
    return hotelJpaService.addHotel(hotel);
  }

  @GetMapping("/hotels/{hotelId}")
  public Hotel getHotelById(@PathVariable("hotelId") int hotelid) {
    return hotelJpaService.getHotelById(hotelid);
  }

  @PutMapping("/hotels/{hotelId}")
  public Hotel updateHotel(@PathVariable("hotelId") int hotelid, @RequestBody Hotel hotel) {
    return hotelJpaService.updateHotel(hotelid, hotel);
  }

  @DeleteMapping("/hotels/{hotelId}")
  public void deleteHotel(@PathVariable int hotelId) {
    hotelJpaService.deleteHotel(hotelId);
  }

  @GetMapping("/hotels/{hotelId}/rooms")
  public List<Room> getHotelrooms(@PathVariable("hotelId") int hotelid) {
    return hotelJpaService.getHotelRooms(hotelid);
  }

}
