package com.walmart.labs.services.reservation.Request;

import com.walmart.labs.services.reservation.Controller.Allocator;
import com.walmart.labs.services.reservation.Entity.Room;
import com.walmart.labs.services.reservation.Entity.Seat;
import com.walmart.labs.services.reservation.Entity.Theater;
import com.walmart.labs.services.reservation.ReserveDatabase;
import com.walmart.labs.services.reservation.Response.ReserveResponse;

import java.util.List;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveRequestHandler {
    private Allocator allocator = new Allocator();

    public ReserveResponse processRequest(ReserveRequest request) {
        Theater theater = ReserveDatabase.THEATER_MAP.get(request.getTheaterId());
        Room room = theater.getRoom(request.getRoomId());
        List<Seat> reservedSeats = allocator.allocate(room.getSeatMap(), request);
        return new ReserveResponse(request.getRequestId(), reservedSeats, theater, room);
    }
}
