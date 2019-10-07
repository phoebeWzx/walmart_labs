package com.walmart.labs.services.reservation.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class SeatMap {
    private int rows;
    private int cols;
    private int upRowId;
    private int downRowId;
    private int startRowId;
    private int capacity;
    private int availableSeat;
    private Map<Integer, SeatRow> seatMap;

    public SeatMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.capacity = rows * cols;
        this.availableSeat = this.capacity;
        this.seatMap = new HashMap<Integer, SeatRow>();
        initialMap();
    }

    private void initialMap() {
        for (int i = 0; i < rows; i++) {
            seatMap.put(i, new SeatRow(this.cols, String.valueOf((char)(i + 'A'))));
        }
        this.startRowId = this.rows / 3 * 2;
        this.upRowId = startRowId + 1;
        this.downRowId = startRowId - 1;
    }

    public int getStartRowId() {
        return this.startRowId;
    }

    public int getUpRowId() {
        return this.upRowId;
    }

    public void setUpRowId(int id) {
        this.upRowId = id;
    }

    public int getDownRowId() {
        return this.downRowId;
    }

    public void setDownRowId(int id) {
        this.downRowId = id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getAvailableSeat() {
        return this.availableSeat;
    }

    public void occupySeat() {
        this.availableSeat = this.availableSeat - 1;
    }

    public int getRows() {
        return this.rows;
    }

    public SeatRow getSeatRow(int rowId) {
        return this.seatMap.get(rowId);
    }
}
