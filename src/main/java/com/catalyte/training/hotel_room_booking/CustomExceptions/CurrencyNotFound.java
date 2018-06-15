package com.catalyte.training.hotel_room_booking.CustomExceptions;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = ErrorMessages.CURRENCY_NOT_FOUND_MESSAGE)
public class CurrencyNotFound extends RuntimeException {
}
