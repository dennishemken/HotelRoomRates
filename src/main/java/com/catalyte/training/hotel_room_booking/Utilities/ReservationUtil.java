package com.catalyte.training.hotel_room_booking.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationUtil {
    private static final Logger logger = LogManager.getLogger();

    public static Long calculateNumberOfDays(Date startDate, Date endDate) {
        long diffInMilies = endDate.getTime() - startDate.getTime();

        return (TimeUnit.DAYS.convert(diffInMilies, TimeUnit.DAYS)) / 1000 / 60 / 60 / 24;
    }
}
