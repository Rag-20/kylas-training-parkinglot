package com.kylas.ParkingLot.Entity;
import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, int numOfSlots) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
        for (int i = 1; i <= numOfSlots; i++) {
            slots.add(new ParkingSlot(floorNumber, i));
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
