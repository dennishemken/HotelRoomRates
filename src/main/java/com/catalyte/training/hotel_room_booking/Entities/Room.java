package com.catalyte.training.hotel_room_booking.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Room {
    String roomType;
    Double roomRate;

    @JsonCreator
    public Room(@JsonProperty("roomType") String room, @JsonProperty("roomRate") Double roomRate){
        this.roomType = room;
        this.roomRate = roomRate;
    }

    public void setRoomRate(Double newRate){
        this.roomRate = newRate;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomType, room.roomType) && Objects.equals(roomRate, room.roomRate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomType, roomRate);
    }
}
