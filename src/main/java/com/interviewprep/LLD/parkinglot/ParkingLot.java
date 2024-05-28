package com.interviewprep.LLD.parkinglot;

import com.interviewprep.LLD.parkinglot.model.Vehicle;

import java.util.List;

public class ParkingLot {


    private String name;
    private List<ParkingLevel> parkingLevels;
    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }
    public void setParkingLevels(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingLot(List<ParkingLevel> parkingLevels, String name) {
        this.parkingLevels = parkingLevels;
        this.name = name;
    }

    public ParkingSlot findSuitableSlot(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels){
           return parkingLevel.findAvailableSlot(vehicle);
        }
        throw new IllegalStateException("Suitable parking slot not found for vehicle "+vehicle);
    }

}
