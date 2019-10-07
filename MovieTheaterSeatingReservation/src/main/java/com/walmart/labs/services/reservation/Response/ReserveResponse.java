package com.walmart.labs.services.reservation.Response;

import com.walmart.labs.services.reservation.Entity.Room;
import com.walmart.labs.services.reservation.Entity.Seat;
import com.walmart.labs.services.reservation.Entity.Theater;

import java.util.List;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveResponse {
    private String reponseId;
    private List<Seat> assignedSeat;
    private Theater theater;
    private Room room;

    public ReserveResponse(String reponseId, List<Seat> assignedSeat, Theater theater, Room room) {
        this.reponseId = reponseId;
        this.assignedSeat = assignedSeat;
        this.theater = theater;
        this.room = room;
    }

    public String getReponseId() {
        return this.reponseId;
    }

    public List<Seat> getAssignedSeat() {
        return this.assignedSeat;
    }

    public Theater getTheater() {
        return this.theater;
    }

    public Room getRoom() {
        return this.room;
    }
}
