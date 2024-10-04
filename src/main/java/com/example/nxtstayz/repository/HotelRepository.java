/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import java.util.*;

public interface HotelRepository {
  ArrayList<Hotel> getHotels();

  Hotel getHotelById(int hotelid);

  Hotel addHotel(Hotel hotel);

  Hotel updateHotel(int hotelid, Hotel hotel);

  void deleteHotel(int hotelid);
   List<Room> getHotelRooms(int hotelid);

}