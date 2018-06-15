package com.catalyte.training.hotel_room_booking.Services;

import com.catalyte.training.hotel_room_booking.Entities.Reservation;

import java.util.Date;

public interface HotelRoomReservations {
    Reservation createReservation(String selectedCurrency, Date startDate, Date endDate, String selectedRoom);
}
