package com.catalyte.training.hotel_room_booking.Services;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import com.catalyte.training.hotel_room_booking.CustomExceptions.InvalidDates;
import com.catalyte.training.hotel_room_booking.Entities.Reservation;
import com.catalyte.training.hotel_room_booking.Entities.Room;
import com.catalyte.training.hotel_room_booking.Utilities.ReservationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HotelRoomReservationsImpl implements HotelRoomReservations {

    @Autowired
    RoomServiceImpl roomService;
    @Autowired
    CurrencyExchangeServiceImpl currencyExchangeService;

    public Reservation createReservation(String selectedCurrency, Date startDate, Date endDate, String
            selectedRoomType) {
        if (startDate.after(endDate)) {
            throw new InvalidDates(ErrorMessages.START_DATE_BEFORE_END);
        }
        if(startDate.compareTo(endDate) == 0){
            throw new InvalidDates(ErrorMessages.START_DATE_END_DATE_SAME);
        }

        Room selectedRoom = roomService.getRoomByType(selectedRoomType);

        Long totalStay = ReservationUtil.calculateNumberOfDays(startDate, endDate);

        return new Reservation(selectedRoomType, currencyExchangeService.convertCurrency(selectedCurrency, selectedRoom
                .getRoomRate() * totalStay), currencyExchangeService.convertCurrency(selectedCurrency, selectedRoom
                .getRoomRate()), startDate, endDate, selectedCurrency);
    }

}
