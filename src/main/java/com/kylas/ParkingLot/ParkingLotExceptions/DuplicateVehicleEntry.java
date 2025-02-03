package com.kylas.ParkingLot.ParkingLotExceptions;

public class DuplicateVehicleEntry extends Exception{
    public DuplicateVehicleEntry() {
        super("\nVehicle Already exists!!");
    }
}
