/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

package com.example.nxtstayz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.model.Hotel;
import java.util.*;

@Repository
public interface RoomJpaRepository extends JpaRepository<Room, Integer> {
  List<Room> findByHotel(Hotel hotel);
}