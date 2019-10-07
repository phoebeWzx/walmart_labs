package com.walmart.labs.services.reservation.Entity;

import java.util.*;

/**
 * @program: MovieTheaterSeatingReservation
 * @description: The theater class for the seating reservation system.
 * @author: Zhuoxue Wu
 **/
public class Theater extends TheaterEntity<String>{
    private String name;
    private Map<String, Room> rooms;

    public Theater(String id, String name) {
        this.id = id;
        this.name = name;
        this.rooms = new HashMap<String, Room>();
    }

    public String getName() {
        return this.name;
    }

    public Room getRoom(String roomId) {
        return this.rooms.get(roomId);
    }

    public void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }
}
