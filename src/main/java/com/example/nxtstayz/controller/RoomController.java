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

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxtstayz.service.HotelJpaService;
import com.example.nxtstayz.service.RoomJpaService;

@RestController
public class RoomController {
  @Autowired
  HotelJpaService hotelJpaService;
  @Autowired
  RoomJpaService roomJpaService;

  @GetMapping("/hotels/rooms")
  public ArrayList<Room> getRooms() {
    return roomJpaService.getRooms();
  }

  @PostMapping("/hotels/rooms")
  public Room addRoom(@RequestBody Room room) {
    return roomJpaService.addRoom(room);
  }

  @GetMapping("/hotels/rooms/{roomId}")
  public Room getRoomById(@PathVariable("roomId") int roomId) {
    return roomJpaService.getRoomById(roomId);
  }

  @PutMapping("/hotels/rooms/{roomId}")
  public Room updateRoom(@PathVariable("roomId") int roomId, @RequestBody Room room) {
    return roomJpaService.updateRoom(roomId, room);
  }

  @DeleteMapping("/hotels/rooms/{roomId}")
  public void deleteRoom(@PathVariable("roomId") int roomId) {
    roomJpaService.deleteRoom(roomId);
  }

  @GetMapping("/rooms/{roomId}/hotel")
  public Hotel hetRoomHotel(@PathVariable("roomId") int roomId) {
    return roomJpaService.getRoomHotel(roomId);
  }

}
