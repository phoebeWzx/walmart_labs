package com.walmart.labs.services.reservation.Utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class IOFileUtilTest {
    @Test
    public void testReadFile() {
        String filepath = System.getProperty("user.dir") + "/src/main/resources/input.txt";
        List<String> res = IOFileUtil.readFile(filepath);

        assertEquals("R001 3", res.get(0));
        assertEquals("R002 3", res.get(1));
        assertEquals("R003 5", res.get(2));
        assertEquals("R004 15", res.get(3));
        assertEquals("R005 20", res.get(4));
        assertEquals("R006 20", res.get(5));
        assertEquals("R007 17", res.get(6));
        assertEquals("R008 30", res.get(7));
        assertEquals("R009 27", res.get(8));
        assertEquals("R010 15", res.get(9));
        assertEquals("R011 9", res.get(10));

    }

    @Test
    public void testWriteFile() {
        String filepath = System.getProperty("user.dir") + "/src/main/resources/output.txt";
        List<String> test = new ArrayList<>();
        test.add("R001 A1,A2,A3");
        test.add("R002 A4,A5");
        test.add("R003 A6");
        IOFileUtil.writeFile(test, filepath);
        List<String> out = IOFileUtil.readFile(filepath);

        assertEquals("R001 A1,A2,A3", out.get(0));
        assertEquals("R002 A4,A5", out.get(1));
        assertEquals("R003 A6", out.get(2));

    }
}
