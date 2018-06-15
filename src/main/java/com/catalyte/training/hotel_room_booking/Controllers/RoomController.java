package com.catalyte.training.hotel_room_booking.Controllers;

import com.catalyte.training.hotel_room_booking.Entities.Room;
import com.catalyte.training.hotel_room_booking.Entities.UpdateRoomRequestWrapper;
import com.catalyte.training.hotel_room_booking.Services.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("Rooms")
@RestController
public class RoomController {
    @Autowired
    RoomServiceImpl roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> getRooms(@RequestParam(required =false) String roomType){
       return StringUtils.isEmpty(roomType) ? roomService.getAllRooms() : Collections.singletonList(roomService.getRoomByType
               (roomType));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRoom(@RequestBody Room newRoom){
        roomService.addRoom(newRoom);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateRoom(@RequestBody UpdateRoomRequestWrapper updateRoomRequestWrapper){
        roomService.updateRoom(updateRoomRequestWrapper.getNewRoom(), updateRoomRequestWrapper.getOldRoom());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRoom(@RequestBody Room targetRoom){
        roomService.removeRoom(targetRoom);
    }
}
