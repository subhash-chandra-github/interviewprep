package com.interviewprep.LLD.parkinglot;

public class Vehicle {

    private String vehicleNo;
    private VehicleType type;
    private ParkingSlotSize slotSize;

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    Vehicle(VehicleType type){
        this.type=type;
    }

    public ParkingSlotSize getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(ParkingSlotSize slotSize) {
        this.slotSize = slotSize;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", type=" + type +
                ", slotSize=" + slotSize +
                '}';
    }
}
