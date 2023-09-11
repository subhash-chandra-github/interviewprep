package com.interviewprep.LLD.parkinglot;

public class Bike extends Vehicle{
    Bike(String vehicleNo) {
        super(VehicleType.BIKE);
        this.setVehicleNo(this.getVehicleNo());
    }
}
