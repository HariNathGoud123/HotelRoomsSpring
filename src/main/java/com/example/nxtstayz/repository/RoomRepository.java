/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

package com.example.nxtstayz.repository;

import java.util.ArrayList;
import com.example.nxtstayz.model.*;

public interface RoomRepository {

  ArrayList<Room> getRooms();

  Room getRoomById(int roomId);

  Room addRoom(Room room);

  Room updateRoom(int roomid, Room room);

  void deleteRoom(int roomId);

  Hotel getRoomHotel(int roomId);

}