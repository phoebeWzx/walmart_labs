package com.walmart.labs.services.reservation;

import com.walmart.labs.services.reservation.Entity.Room;
import com.walmart.labs.services.reservation.Entity.Theater;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReserveDatabase {
    private static final String ROOM_ID = "001";
    private static final String ROOM_NAME = "First Movie Room";
    private static final String THEATER_ID = "001";
    private static final String THEATER_NAME = "First Theater";
    public static Map<String, Theater> THEATER_MAP = new HashMap<String, Theater>();


    public static void initializeTheater(int rows, int cols) {
        Room room = new Room(ROOM_ID, ROOM_NAME, rows, cols);
        Theater theater = new Theater(THEATER_ID, THEATER_NAME);
        theater.addRoom(room);
        THEATER_MAP.put(THEATER_ID, theater);
    }
}
