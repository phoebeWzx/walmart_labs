package com.walmart.labs.services.reservation;

import com.walmart.labs.services.reservation.Request.ReserveRequest;
import com.walmart.labs.services.reservation.Request.ReserveRequestHandler;
import com.walmart.labs.services.reservation.Response.ReserveResponse;
import com.walmart.labs.services.reservation.Response.ReserveResponseHandler;
import com.walmart.labs.services.reservation.Utils.IOFileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class ReservationService {
    private ReserveRequestHandler requestHandler = new ReserveRequestHandler();
    private ReserveResponseHandler responseHandler = new ReserveResponseHandler();

    public static void main(String[] args) {
        ReservationService service = new ReservationService();
        String input = "";
        String output = "";
        if (args.length == 4) {
            if (args[0].trim().equals("-i") && args[2].trim().equals("-o")) {
                input = args[1];
                output = args[3];
            } else {
                System.out.println("Wrong input!");
            }
        }else {
            System.out.println("Wrong input size!");
        }

        String inputPath = System.getProperty("user.dir") + "/src/main/resources/" + input;
        String outputPath = System.getProperty("user.dir") + "/src/main/resources/" + output;
        service.seatReserve(inputPath, outputPath);
    }

    public void seatReserve(String inputPath, String outputPath) {
        List<String> input = IOFileUtil.readFile(inputPath);
        List<String> output = new ArrayList<String>();
        ReserveDatabase.initializeTheater(10, 20);

        for (String string : input) {
            String[] line = string.split(" ");
            if (line.length == 2) {
                try {
                    String id = line[0];
                    int numberOfRequest = Integer.parseInt(line[1]);
                    if (!id.isEmpty()) {
                        ReserveResponse response = requestHandler.processRequest(
                                new ReserveRequest(id, numberOfRequest, "001", "001"));
                        output.add(responseHandler.processResponse(response));
                    }

                }catch(NumberFormatException e) {
                    System.out.println("format Error");
                }
            }
        }
        IOFileUtil.writeFile(output, outputPath);

    }
}
