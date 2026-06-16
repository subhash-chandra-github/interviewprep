package com.interviewprep.lld.parkinglot.model;

import com.interviewprep.lld.parkinglot.enums.ParkingSlotSize;
import com.interviewprep.lld.parkinglot.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleNo) {
        super(VehicleType.CAR);
        this.setVehicleNo(vehicleNo);
        this.setSlotSize(ParkingSlotSize.COMPACT);
    }
}
