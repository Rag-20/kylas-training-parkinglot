package com.kylas.ParkingLot.ParkingLotExceptions;

public class VehicleTypeException extends Throwable {
    public VehicleTypeException(){
        super("\nVehicle type is not valid!!");
    }
}
