package com.interviewprep.LLD.parkinglot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParkingLotSysAdmin {

    public static void main(String[] args) {
        ParkingLevel parkingLevel1 = new ParkingLevel();
        parkingLevel1.setFloorNo(1);
        ParkingSlot parkingSlot1 = new ParkingSlot(1,1,ParkingSlotSize.COMPACT,ParkingSlotStatus.VACANT,parkingLevel1);
        ParkingSlot parkingSlot2 = new ParkingSlot(2,2,ParkingSlotSize.COMPACT,ParkingSlotStatus.VACANT,parkingLevel1);
        ParkingSlot parkingSlot3 = new ParkingSlot(3,3,ParkingSlotSize.COMPACT,ParkingSlotStatus.VACANT,parkingLevel1);
        ParkingSlot parkingSlot4 = new ParkingSlot(4,4,ParkingSlotSize.SMALL,ParkingSlotStatus.VACANT,parkingLevel1);
        ParkingSlot parkingSlot5 = new ParkingSlot(5,5,ParkingSlotSize.SMALL,ParkingSlotStatus.VACANT,parkingLevel1);
        List<ParkingSlot> levelOneParkingSlots = Arrays.asList(parkingSlot1,parkingSlot4,parkingSlot5);
        parkingLevel1.setParkingSlots(levelOneParkingSlots);


        ParkingLot parkingLot = new ParkingLot(Collections.singletonList(parkingLevel1),"Parking Lot Test");

        Vehicle car1 = new Car("CAR1");
        Vehicle car2 = new Car("CAR2");
        Vehicle car3 = new Car("CAR3");
        Vehicle car4 = new Car("CAR4");

        ParkingSlot parkingSlot = parkingLot.findSuitableSlot(car1);
        parkingSlot.parkVehicle(car1);
        parkingSlot = parkingLot.findSuitableSlot(car2);
        System.out.println(parkingSlot);
    }
}
