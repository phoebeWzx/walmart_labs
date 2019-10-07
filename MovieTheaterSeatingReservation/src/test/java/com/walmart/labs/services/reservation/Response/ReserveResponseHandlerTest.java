package com.walmart.labs.services.reservation.Response;

import com.walmart.labs.services.reservation.Entity.Room;
import com.walmart.labs.services.reservation.Entity.Seat;
import com.walmart.labs.services.reservation.Entity.Theater;
import com.walmart.labs.services.reservation.Request.ReserveRequestHandler;
import com.walmart.labs.services.reservation.ReserveDatabase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveResponseHandlerTest {
    @Test
    public void testReserveResponseHandler() {
        ReserveDatabase.initializeTheater(5, 5);
        Theater theater = ReserveDatabase.THEATER_MAP.get("001");
        Room room = theater.getRoom("001");
        List<Seat> assignedSeat = new ArrayList<>();
        assignedSeat.add(new Seat("A", "1"));
        assignedSeat.add(new Seat("A", "2"));
        assignedSeat.add(new Seat("A", "3"));

        ReserveResponseHandler responseHandler = new ReserveResponseHandler();
        ReserveResponse response = new ReserveResponse("R001", assignedSeat, theater, room);
        String res = responseHandler.processResponse(response);
        assertEquals("R001 A1,A2,A3", res);
    }
}
