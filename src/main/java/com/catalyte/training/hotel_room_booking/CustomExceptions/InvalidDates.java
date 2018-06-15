package com.catalyte.training.hotel_room_booking.CustomExceptions;
import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDates extends RuntimeException{

    public InvalidDates(String reason){
        super(reason);
    }

    public InvalidDates(){
        super(ErrorMessages.INVALID_DATES_DEFAULT);
    }
}
