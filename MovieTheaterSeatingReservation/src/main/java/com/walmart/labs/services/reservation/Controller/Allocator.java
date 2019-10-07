package com.walmart.labs.services.reservation.Controller;

import com.walmart.labs.services.reservation.Entity.Seat;
import com.walmart.labs.services.reservation.Entity.SeatMap;
import com.walmart.labs.services.reservation.Entity.SeatRow;
import com.walmart.labs.services.reservation.Request.ReserveRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MovieTheaterSeatingReservation
 * @description: The Allocator class for the seat
 * @author: Zhuoxue Wu
 **/
public class Allocator {
    /**
    * @Description: The allocate Method for allocator
    * @Param: [seatMap, request]
    * @return: java.util.List<com.walmart.labs.services.reservation.Entity.Seat>
    */
    /*
    * Assumption & Rules:
    * 1. Start from the 2/3 row of the theater room, spread from this row to upper row and down row.
    * 2. There are two pointer, up and down.
    *    Up point start from 2/3 row to the last row of the room.
    *    Down point start form 2/3 to the first row of the room.
    * 3. Every request will be allocated to the row which is the nearest to the 2/3 row
    * 4. The system will allocate seats as near as possible for the request,
    *    which have to allocate customs in different row
    * */
    public List<Seat> allocate(SeatMap seatMap, ReserveRequest request) {
        List<Seat> assignedSeat = new ArrayList<Seat>();
        int numberOfRequest = request.getNumberOfRequest();
        // If the number of request is bigger than current available seat, return empty list and error message
        if (seatMap.getAvailableSeat() < numberOfRequest) {
            System.out.println("The number of you request " +
                    request.getRequestId() + " with " + numberOfRequest +
                    " is out of capacity");
            return assignedSeat;
        }
        // startRow is the 2/3 of total rows of room
        int startRowId = seatMap.getStartRowId();
        SeatRow startRow = seatMap.getSeatRow(startRowId);

        // Initial up and down;
        int upRowId = seatMap.getUpRowId();
        int downRowId = seatMap.getDownRowId();

        int curRowId = startRowId;
        // if startRow is full, choose the nearer row
        if (startRow.isFull()) {
            curRowId = pickNearRow(upRowId, downRowId, startRowId, seatMap.getRows());
        }

        while (numberOfRequest > 0 && seatMap.getAvailableSeat() >= numberOfRequest) {
            // get current row and assign the seat
            SeatRow curRow = seatMap.getSeatRow(curRowId);
            assignSeat(curRowId, startRowId, assignedSeat, seatMap);

            // if current row is full, move the up row to upper row or move the down to downer row
            if (curRow.isFull()) {
                curRowId = getNextRowID(curRowId, startRowId, seatMap);

                // if current row out of boundary, change to the other side
                if (seatMap.getUpRowId() >= seatMap.getRows()) {
                    curRowId = seatMap.getDownRowId();
                }
                if (seatMap.getDownRowId() < 0) {
                    curRowId = seatMap.getUpRowId();
                }
            }

            // update the number of request
            numberOfRequest--;
            // update current available seat
            seatMap.occupySeat();
        }

        return assignedSeat;
    }

    /**
    * @Description: Move up pointer to upper or move down pointer to downer
    * @Param: [curRowId, startRowId, seatMap]
    * @return: int
    */
    private int getNextRowID(int curRowId, int startRowId, SeatMap seatMap) {
        int nextRowId = 0;
        // curRow is up pointer
        if (curRowId > startRowId) {
            nextRowId = curRowId + 1;
            seatMap.setUpRowId(nextRowId);
        } else {
            // else is the down pointer
            nextRowId = curRowId - 1;
            seatMap.setDownRowId(nextRowId);
        }
        return nextRowId;
    }

    /**
    * @Description: Assign seat function to ensure seats can be together
    * @Param: [rowId, startId, assignedSeat, seatMap]
    * @return: void
    */
    private void assignSeat(int rowId, int startId, List<Seat> assignedSeat, SeatMap seatMap) {
        SeatRow row = seatMap.getSeatRow(rowId);
        int distance = Math.abs(startId - rowId);
        // if the distance of current row and 2/3 row is even, add seat from right to left
        if (distance % 2 == 0) {
            Seat seat = new Seat(row.getId(), String.valueOf(row.getSize() + 1));
            row.addLastSeat(seat);
            assignedSeat.add(seat);
        } else {
            // else add seat from left to right
            Seat seat = new Seat(row.getId(), String.valueOf(row.getCapacity() - row.getSize()));
            row.addFirstSeat(seat);
            assignedSeat.add(seat);
        }
    }

    /**
    * @Description: pick the next good view row, which is the nearest of 2/3 row
    * @Param: [up, down, start, totalRows]
    * @return: int
    */
    private int pickNearRow(int up, int down, int start, int totalRows) {
        if (up >= totalRows) {
            return down;
        }
        if (down < 0) {
            return up;
        }
        int upDistance = Math.abs(up - start);
        int downDistance = Math.abs(down - start);
        return upDistance > downDistance ? down : up;
    }

}
