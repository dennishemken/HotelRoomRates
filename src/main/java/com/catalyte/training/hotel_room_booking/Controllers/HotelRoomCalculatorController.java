package com.catalyte.training.hotel_room_booking.Controllers;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import com.catalyte.training.hotel_room_booking.Entities.Reservation;
import com.catalyte.training.hotel_room_booking.Entities.ReservationRequest;
import com.catalyte.training.hotel_room_booking.Services.HotelRoomReservationsImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RoomCalculator")
public class HotelRoomCalculatorController {

    @Autowired
    HotelRoomReservationsImpl hotelRoomReservations;

    @ApiOperation("This API takes in a reservation request and will return a " + "" + "final Reservation object " +
            "based" + " on this")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Reservation.class), @ApiResponse(code
            = 400, message = ErrorMessages.INVALID_DATES_DEFAULT)})
    @RequestMapping(method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody ReservationRequest reservationRequest) {
        if (reservationRequest.getStartDate() == null || reservationRequest.getEndDate() == null ||
                reservationRequest.getRoomType() == null || reservationRequest.getSelectedCurrency() == null) {
            throw new IllegalArgumentException("The request body is missing " + "one of the required data fields");
        }

        return hotelRoomReservations.createReservation(reservationRequest.getSelectedCurrency(), reservationRequest
                .getStartDate(), reservationRequest.getEndDate(), reservationRequest.getRoomType());
    }

}
