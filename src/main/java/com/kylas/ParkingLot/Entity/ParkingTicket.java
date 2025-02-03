package com.kylas.ParkingLot.Entity;

import java.util.Random;

public class ParkingTicket {
    private long id;
    private long floorNumber;
    private long slotNumber;
    private String vehicleNo;

    public ParkingTicket(String vehicleNo, long slotNumber, long floorNumber) {
        this.id = new Random().nextLong();
        this.vehicleNo = vehicleNo;
        this.slotNumber = slotNumber;
        this.floorNumber = floorNumber;
    }

    public void generateTicket(){
        System.out.println("Parking ticket :- "+id+"\nVehicle " + vehicleNo + "\nFloor number" +
                floorNumber + "\nSlot number " + slotNumber);
    }
}
