package com.interviewprep.LLD.parkinglot;

public class ParkingSlot {
    private int slotId;
    private int slotNumber;
    private ParkingSlotSize slotSize;
    private ParkingSlotStatus parkingSlotStatus;
    private ParkingLevel level;
    private Vehicle vehicle;

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public ParkingSlotSize getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(ParkingSlotSize slotSize) {
        this.slotSize = slotSize;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public ParkingLevel getLevel() {
        return level;
    }

    public void setLevel(ParkingLevel level) {
        this.level = level;
    }

    public ParkingSlot(int slotId, int slotNumber, ParkingSlotSize slotSize, ParkingSlotStatus parkingSlotStatus, ParkingLevel level) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.slotSize = slotSize;
        this.parkingSlotStatus = parkingSlotStatus;
        this.level = level;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (this.parkingSlotStatus == ParkingSlotStatus.ENGAGED || this.parkingSlotStatus == ParkingSlotStatus.UNAVAILABLE) {
            System.out.println("Can not park here engaged/unavailable");
            return false;
        }
        if (isAllowed(vehicle)) {
            this.parkingSlotStatus = ParkingSlotStatus.ENGAGED;
            this.vehicle = vehicle;
            System.out.println("Parked Successfully");
            return true;
        } else {
            return false;
        }
    }

    public boolean isAllowed(Vehicle vehicle) {
        return this.slotSize == vehicle.getSlotSize();
    }

    public boolean unParkVehicle() {
        if (this.parkingSlotStatus == ParkingSlotStatus.ENGAGED) {
            this.parkingSlotStatus = ParkingSlotStatus.VACANT;
            this.vehicle = null;
            return true;
        } else {
            throw new IllegalStateException("No vehicle was parked here");
        }
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotId=" + slotId +
                ", slotNumber=" + slotNumber +
                ", slotSize=" + slotSize +
                ", parkingSlotStatus=" + parkingSlotStatus +
                ", level=" + level +
                ", vehicle=" + vehicle +
                '}';
    }
}
