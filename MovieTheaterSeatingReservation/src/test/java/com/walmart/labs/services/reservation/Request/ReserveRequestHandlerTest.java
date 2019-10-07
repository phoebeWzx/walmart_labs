package com.walmart.labs.services.reservation.Request;

import com.walmart.labs.services.reservation.ReserveDatabase;
import com.walmart.labs.services.reservation.Response.ReserveResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveRequestHandlerTest {
    @Test
    public void testReserveRequestHandler() {
        ReserveDatabase.initializeTheater(5, 5);
        ReserveRequestHandler requestHandler = new ReserveRequestHandler();
        ReserveRequest request = new ReserveRequest("R001", 5, "001", "001");
        ReserveResponse response = requestHandler.processRequest(request);
        assertEquals("R001", response.getReponseId());
        assertEquals("001", response.getRoom().getId());
        assertEquals("001", response.getTheater().getId());
        assertEquals(5, response.getAssignedSeat().size());
    }
}
