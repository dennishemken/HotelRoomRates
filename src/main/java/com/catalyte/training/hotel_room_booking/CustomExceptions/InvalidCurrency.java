package com.catalyte.training.hotel_room_booking.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidCurrency extends RuntimeException {
    public InvalidCurrency(String reason) {
        super(reason);
    }
}
