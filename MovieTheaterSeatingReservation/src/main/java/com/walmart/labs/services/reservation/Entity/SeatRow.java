package com.walmart.labs.services.reservation.Entity;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class SeatRow extends TheaterEntity<String>{
    private Deque<Seat> row;
    private int capacity;

    public SeatRow(int size, String id) {
        this.id = id;
        this.row = new LinkedList<Seat>();
        this.capacity = size;
    }

    public boolean isFull() {
        return capacity == row.size();
    }

    public void addLastSeat(Seat seat) {
        row.addLast(seat);
    }

    public void addFirstSeat(Seat seat) {
        row.addFirst(seat);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.row.size();
    }

}
