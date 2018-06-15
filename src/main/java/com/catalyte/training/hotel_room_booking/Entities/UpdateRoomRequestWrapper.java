package com.catalyte.training.hotel_room_booking.Entities;

public class UpdateRoomRequestWrapper {
    private Room newRoom;
    private Room oldRoom;

    public Room getNewRoom() {
        return newRoom;
    }

    public void setNewRoom(Room newRoom) {
        this.newRoom = newRoom;
    }

    public Room getOldRoom() {
        return oldRoom;
    }

    public void setOldRoom(Room oldRoom) {
        this.oldRoom = oldRoom;
    }
}
