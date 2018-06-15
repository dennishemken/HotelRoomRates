package com.catalyte.training.hotel_room_booking.CustomExceptions;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = ErrorMessages.MISSING_ROOM_TYPE_MESSAGE)
public class InvalidRoom extends RuntimeException {
    public InvalidRoom(String reason) {
        super(reason);
    }

    public InvalidRoom() {
        super();
    }
}
