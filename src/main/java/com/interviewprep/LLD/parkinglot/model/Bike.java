package com.interviewprep.LLD.parkinglot.model;

import com.interviewprep.LLD.parkinglot.enums.VehicleType;
import com.interviewprep.LLD.parkinglot.model.Vehicle;

public class Bike extends Vehicle {
    Bike(String vehicleNo) {
        super(VehicleType.BIKE);
        this.setVehicleNo(this.getVehicleNo());
    }
}
