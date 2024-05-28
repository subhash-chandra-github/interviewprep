package com.interviewprep.LLD.parkinglot.model;

import com.interviewprep.LLD.parkinglot.enums.ParkingSlotSize;
import com.interviewprep.LLD.parkinglot.enums.VehicleType;
import com.interviewprep.LLD.parkinglot.model.Vehicle;

public class Car extends Vehicle {

    public Car(String vehicleNo) {
        super(VehicleType.CAR);
        this.setVehicleNo(vehicleNo);
        this.setSlotSize(ParkingSlotSize.COMPACT);
    }
}
