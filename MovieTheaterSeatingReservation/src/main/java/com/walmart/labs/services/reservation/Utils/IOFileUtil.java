package com.walmart.labs.services.reservation.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MovieTheaterSeatingReservation
 * @description:
 * @author: Zhuoxue Wu
 **/
public class IOFileUtil {
    /**
    * @Description: 
    * @Param: [filepath]
    * @return: java.util.List<java.lang.String>
    */
    public static List<String> readFile(String filepath) {
        List<String> content = new ArrayList<String>();
        try {
            File file = new File(filepath); 
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String nextLine = null;
                
                while ((nextLine = bufferedReader.readLine()) != null) {
                    content.add(nextLine);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("Can not find the file");
            }
        }catch (Exception e) {
            System.out.println("Error occur while reading");
            System.out.println("Error Message: " + e.getMessage());
            e.printStackTrace();
        }
        return content;
    }
    
    /**
    * @Description: 
    * @Param: [content, filepath]
    * @return: void
    */
    public static void writeFile(List<String> content, String filepath) {
        File file = new File(filepath);
        try {
            if (file.isFile() && file.exists()) {
                OutputStreamWriter writer = new OutputStreamWriter((new FileOutputStream(file)));
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for (String line : content) {
                    bufferedWriter.write(line + "\n");
                }
                bufferedWriter.close();
                writer.close();
            }else {
                System.out.println("Can not find the file");
            }
        }catch (Exception e) {
            System.out.println("Error occur while writing");
            System.out.println("Error Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
