package com.catalyte.training.hotel_room_booking.Utilities;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import com.catalyte.training.hotel_room_booking.CustomExceptions.InvalidRoom;
import com.catalyte.training.hotel_room_booking.Entities.Room;

import java.util.List;

public class RoomServiceUtil {
    public static void validateRoom(Room room){
        if (room.getRoomType().isEmpty()) {
            throw new InvalidRoom();
        }

        if (room.getRoomRate().isNaN()) {
            throw new InvalidRoom(ErrorMessages.INVALID_ROOM_RATE_MESSAGE);
        }
    }
}
