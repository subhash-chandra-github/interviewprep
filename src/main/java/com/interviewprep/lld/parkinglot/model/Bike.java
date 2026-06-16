package com.interviewprep.lld.parkinglot.model;

import com.interviewprep.lld.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {
    Bike(String vehicleNo) {
        super(VehicleType.BIKE);
        this.setVehicleNo(this.getVehicleNo());
    }
}
