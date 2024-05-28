package com.interviewprep.LLD.parkinglot;

import com.interviewprep.LLD.parkinglot.model.Vehicle;

import java.util.Date;

public class Ticket {

    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;
    private ParkingSlot parkingSlot;

    private double calCalculateFare(){
        return 10.0;
    }

}
