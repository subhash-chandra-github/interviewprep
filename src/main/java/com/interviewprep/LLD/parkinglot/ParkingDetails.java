package com.interviewprep.LLD.parkinglot;

import java.util.Date;

public class ParkingDetails {

    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;
    private ParkingSlot parkingSlot;

    private double calCalculateFare(){
        return 10.0;
    }

}
