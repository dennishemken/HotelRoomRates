package com.catalyte.training.hotel_room_booking.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Currency {
    private String currencyName;
    private Double currencyExchangeRate;

    @JsonCreator
    public Currency(@JsonProperty("currencyName") String currencyName, @JsonProperty("currencyExchangeRate") Double
            currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(currencyName, currency.currencyName) && Objects.equals(currencyExchangeRate, currency
                .currencyExchangeRate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currencyName, currencyExchangeRate);
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(Double currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }
}
