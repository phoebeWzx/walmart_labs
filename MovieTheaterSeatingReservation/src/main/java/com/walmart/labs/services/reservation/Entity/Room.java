package com.walmart.labs.services.reservation.Entity;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class Room extends TheaterEntity<String>{
    private String name;
    private SeatMap seatMap;

    public Room(String id, String name, int row, int col) {
        this.id = id;
        this.name = name;
        seatMap = new SeatMap(row, col);
    }

    public String getName() {
        return this.name;
    }

    public SeatMap getSeatMap() {
        return this.seatMap;
    }


}
