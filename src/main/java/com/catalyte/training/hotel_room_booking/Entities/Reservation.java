package com.catalyte.training.hotel_room_booking.Entities;

import java.util.Date;

public class Reservation {
    private String selectedRoom;
    private Double totalCost, costPerNight;
    private Date startDate, endDate;
    private String selectedCurrency;

    public Reservation(String selectedRoom, Double totalCost, Double costPerNight, Date startDate, Date endDate, String selectedCurrency) {
        this.selectedRoom = selectedRoom;
        this.totalCost = totalCost;
        this.costPerNight = costPerNight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.selectedCurrency = selectedCurrency;
    }

    public String getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(String selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(Double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSelectedCurrency() {
        return selectedCurrency;
    }

    public void setSelectedCurrency(String selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }
}
