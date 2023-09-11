package com.interviewprep.LLD.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private List<ParkingSlot> parkingSlots;
    private int floorNo;

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    private List<ParkingSlot> getVacantSlots(){
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for(ParkingSlot parkingSlot : this.parkingSlots){
            if(parkingSlot.getParkingSlotStatus() == ParkingSlotStatus.VACANT){
                availableSlots.add(parkingSlot);
            }
        }
        return availableSlots;
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle){
        for(ParkingSlot parkingSlot : getVacantSlots()){
            if(parkingSlot.getParkingSlotStatus() == ParkingSlotStatus.VACANT && parkingSlot.isAllowed(vehicle)){
                    return parkingSlot;
                }
        }
        throw new IllegalStateException("Suitable parking slot not found for vehicle : "+vehicle);
    }
}
