package com.walmart.labs.services.reservation.Cotrollor;

import com.walmart.labs.services.reservation.Controller.Allocator;
import com.walmart.labs.services.reservation.Entity.Seat;
import com.walmart.labs.services.reservation.Entity.SeatMap;
import com.walmart.labs.services.reservation.Request.ReserveRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class AllocatorTest {
    @Test
    public void testAllocate() {
        SeatMap seatMap = new SeatMap(5,5);
        ReserveRequest request = new ReserveRequest("R001",2,"001","001");
        List<Seat> assignedSeat = new Allocator().allocate(seatMap, request);
        assertEquals("C1", assignedSeat.get(0).getRow() + assignedSeat.get(0).getCol());
        assertEquals("C2", assignedSeat.get(1).getRow() + assignedSeat.get(1).getCol());

        ReserveRequest request1 = new ReserveRequest("R001",5,"001","001");
        List<Seat> assignedSeat1 = new Allocator().allocate(seatMap, request1);
        assertEquals("C3", assignedSeat1.get(0).getRow() + assignedSeat1.get(0).getCol());
        assertEquals("C4" , assignedSeat1.get(1).getRow() + assignedSeat1.get(1).getCol());
        assertEquals("C5" , assignedSeat1.get(2).getRow() + assignedSeat1.get(2).getCol());
        assertEquals("B5" , assignedSeat1.get(3).getRow() + assignedSeat1.get(3).getCol());
        assertEquals("B4" , assignedSeat1.get(4).getRow() + assignedSeat1.get(4).getCol());

        SeatMap seatMap1 = new SeatMap(3,2);
        ReserveRequest request3 = new ReserveRequest("R001",7,"001","001");
        List<Seat> assignedSeat2 = new Allocator().allocate(seatMap1, request3);
        assertEquals(0, assignedSeat2.size());
    }

}
