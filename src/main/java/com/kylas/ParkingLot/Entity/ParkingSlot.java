package com.kylas.ParkingLot.Entity;

public class ParkingSlot {
    private int slotNumber;
    private int floorNumber;
    private boolean occupied;

    public ParkingSlot(int floorNumber, int slotId) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotId;
        this.occupied = false;
    }

    public int getSlotId() {
        return slotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}