package com.kylas.ParkingLot.Entity;

public class Vehicle {
    private String vehicleType;
    private String vehicleNumPlate;

    public Vehicle(String vehicleNumPlate, String vehicleType) {
        this.vehicleType = vehicleType;
        this.vehicleNumPlate = vehicleNumPlate.toUpperCase();
    }


    public String getVehicleNumPlate(){
        return vehicleNumPlate;
    }
}
