package com.kylas.ParkingLot.Entity;

import java.util.Random;

public class ParkingTicket {
    private long id;
    private long floorNumber;
    private long slotNumber;
    private String vehicleNo;

    public ParkingTicket(Vehicle vehicle,ParkingSlot slot) {
        this.id = new Random().nextLong(1,100000000);
        this.vehicleNo = vehicle.getVehicleNumPlate();
        this.slotNumber = slot.getSlotId();
        this.floorNumber = slot.getFloorNumber();
    }

    @Override
    public String toString(){
        return ("\nParking ticket id :- "+id+"\nVehicle " + vehicleNo + "\nFloor number" +
                floorNumber + "\nSlot number " + slotNumber);
    }
}
