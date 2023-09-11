package com.interviewprep.LLD.parkinglot;

public class Car extends Vehicle{

    Car(String vehicleNo) {
        super(VehicleType.CAR);
        this.setVehicleNo(vehicleNo);
        this.setSlotSize(ParkingSlotSize.COMPACT);
    }
}
