package com.walmart.labs.services.reservation.Response;

import com.walmart.labs.services.reservation.Entity.Seat;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveResponseHandler {

    public String processResponse(ReserveResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(response.getReponseId() + " ");
        for (Seat seat: response.getAssignedSeat()) {
            sb.append(seat.getRow());
            sb.append(seat.getCol());
            sb.append(",");
        }
        return sb.toString().substring(0,sb.length() - 1);
    }
}
