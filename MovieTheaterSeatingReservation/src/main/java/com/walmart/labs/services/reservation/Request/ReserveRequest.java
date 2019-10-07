package com.walmart.labs.services.reservation.Request;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveRequest {
    private String requestId;
    private int numberOfRequest;
    private String theaterId;
    private String roomId;

    public ReserveRequest(String requestId, int numberOfRequest, String theaterId, String roomId) {
        this.requestId = requestId;
        this.numberOfRequest = numberOfRequest;
        this.theaterId = theaterId;
        this.roomId = roomId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getNumberOfRequest() {
        return this.numberOfRequest;
    }

    public String getTheaterId() {
        return this.theaterId;
    }

    public String getRoomId() {
        return this.roomId;
    }
}
