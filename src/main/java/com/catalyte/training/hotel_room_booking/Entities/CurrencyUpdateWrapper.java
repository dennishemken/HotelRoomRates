package com.catalyte.training.hotel_room_booking.Entities;

public class CurrencyUpdateWrapper {
    private Currency oldCurrency, newCurrency;

    public Currency getOldCurrency() {
        return oldCurrency;
    }

    public void setOldCurrency(Currency oldCurrency) {
        this.oldCurrency = oldCurrency;
    }

    public Currency getNewCurrency() {
        return newCurrency;
    }

    public void setNewCurrency(Currency newCurrency) {
        this.newCurrency = newCurrency;
    }
}
