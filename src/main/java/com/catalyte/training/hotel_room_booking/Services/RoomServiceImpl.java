package com.catalyte.training.hotel_room_booking.Services;

import com.catalyte.training.hotel_room_booking.Constants.DefaultRooms;
import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import com.catalyte.training.hotel_room_booking.CustomExceptions.InvalidRoom;
import com.catalyte.training.hotel_room_booking.CustomExceptions.RoomNotFound;
import com.catalyte.training.hotel_room_booking.Entities.Room;
import com.catalyte.training.hotel_room_booking.Utilities.RoomServiceUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl {
    List<Room> currentRooms;

    public RoomServiceImpl() {
        currentRooms = new ArrayList<>();

        currentRooms.add(new Room(DefaultRooms.QUEEN_DOUBLE, DefaultRooms.QUEEN_RATE));
        currentRooms.add(new Room(DefaultRooms.HONEYMOON, DefaultRooms.HONEYMOON_RATE));
        currentRooms.add(new Room(DefaultRooms.PRESIDENTIAL, DefaultRooms.PRESIDENTIAL_RATE));
        currentRooms.add(new Room(DefaultRooms.SINGLE_KING, DefaultRooms.SINGLE_KING_RATE));
    }

    public void addRoom(Room newRoom) {
        //region Guard Clauses
        RoomServiceUtil.validateRoom(newRoom);
        if(currentRooms.indexOf(newRoom) > -1){
            throw new InvalidRoom(ErrorMessages.ROOM_ALREADY_EXISTS_MESSAGE);
        }
        //endregion

        currentRooms.add(newRoom);
    }

    public void updateRoom(Room newRoom, Room oldRoom){
        //region Guard Clauses
        RoomServiceUtil.validateRoom(oldRoom);
        if(currentRooms.indexOf(oldRoom) == -1){
            throw new RoomNotFound();
        }
        RoomServiceUtil.validateRoom(newRoom);
        //endregion

        currentRooms.remove(oldRoom);
        currentRooms.add(newRoom);
    }

    public void removeRoom(Room targetRoom){
        //region Guard Clauses
        RoomServiceUtil.validateRoom(targetRoom);
        if(currentRooms.indexOf(targetRoom) == -1)
        {
            throw new RoomNotFound();
        }
        //endregion

        currentRooms.remove(targetRoom);
    }

    public List<Room> getAllRooms(){
        return currentRooms;
    }

    public Room getRoomByType(String roomType){
        for(Room room : currentRooms){
            if(room.getRoomType().equals(roomType)){
                return room;
            }
        }
        throw new RoomNotFound();
    }
}
