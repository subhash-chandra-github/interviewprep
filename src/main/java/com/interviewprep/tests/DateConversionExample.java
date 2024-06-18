package com.interviewprep.tests;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversionExample {
    public static void main(String[] args) {
        String timestampString = "Wed Jan 16 10:39:02 +0000 2013";
        int offsetMinutes = -300; // Offset in minutes

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
            Date date = sdf.parse(timestampString);

            // Convert offset from minutes to milliseconds
            long offsetMillis = offsetMinutes * 60 * 1000;

            // Adjust the timestamp
            long adjustedTimestamp = date.getTime() + offsetMillis;

            // Create a new Date object with the adjusted timestamp
            Date adjustedDate = new Date(adjustedTimestamp);

            // Print the adjusted date
            System.out.println("Adjusted Date: " + adjustedDate);

            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
