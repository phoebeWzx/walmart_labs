package com.walmart.labs.services.reservation.Entity;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class Seat extends TheaterEntity<String>{
    private String row;
    private String col;

    public Seat(String row, String col) {
        //this.id = id;
        this.row = row;
        this.col = col;
    }
    public String getRow() {
        return this.row;
    }
    public String getCol() {
        return this.col;
    }


}
