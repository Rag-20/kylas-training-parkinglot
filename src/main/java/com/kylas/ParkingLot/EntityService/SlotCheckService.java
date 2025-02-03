package com.kylas.ParkingLot.EntityService;


import com.kylas.ParkingLot.Entity.ParkingFloor;
import com.kylas.ParkingLot.Entity.ParkingLotBuilding;

public class SlotCheckService{
    public int getAvailableSlots(ParkingLotBuilding lot) {
        int available = 0;
        for (ParkingFloor floor : lot.getFloors()) {
            available += floor.getSlots().stream().filter(slot -> !slot.isOccupied()).count();
        }
        return available;
    }
}
