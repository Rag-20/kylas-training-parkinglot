package com.kylas.ParkingLot.Entity;

import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleTypeException;

public class Vehicle {
    private VehicleType vehicleType;
    private String vehicleNumPlate;

    public Vehicle(){}
    public Vehicle(String vehicleNumPlate, String vehicleType) {
        vehicleType.valueOf(vehicleType).toUpperCase();
        this.vehicleNumPlate = vehicleNumPlate.toUpperCase();
    }

    public String getVehicleNumPlate(){
        return vehicleNumPlate;
    }

    public Vehicle create(ParkingLotBuilding parkingLotBuilding,String vehicleNumberPlate, String vehicleType) throws VehicleTypeException, VehicleNumberPlateFormatException, DuplicateVehicleEntry {
        validateNoPlate(vehicleNumberPlate);
        validateVehicleType(vehicleType);
        validateDuplicateEntry(parkingLotBuilding,vehicleNumberPlate.toUpperCase());
        return new Vehicle(vehicleNumberPlate, vehicleType);
    }

    public void validateNoPlate(String vehicleNumberPlate) throws VehicleNumberPlateFormatException {
        if(!validateNumberPlateFormat(vehicleNumberPlate.toUpperCase())) {
            throw new VehicleNumberPlateFormatException();
        }
    }

    private void validateVehicleType(String vehicleType) throws VehicleTypeException {
        try{
            this.vehicleType.valueOf(vehicleType.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new VehicleTypeException();
        }
    }

    private void validateDuplicateEntry(ParkingLotBuilding parkingLotBuilding,String vehicleNumPlate) throws DuplicateVehicleEntry {
        if(isDuplicateEntry(parkingLotBuilding,vehicleNumPlate)){
            throw new DuplicateVehicleEntry();
        }
    }

    private boolean isDuplicateEntry(ParkingLotBuilding lot,String vehicleNumberPlate){
        ParkingSlot slot=lot.getSlotByVehicleNumber(vehicleNumberPlate.toUpperCase());
        if(slot!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validateNumberPlateFormat(String numberPlate){
        if(numberPlate.length()==10) {
            boolean stateInitials = (Character.isUpperCase(numberPlate.charAt(0)) && Character.isUpperCase(numberPlate.charAt(1)));
            boolean stateNumber = (Character.isDigit(numberPlate.charAt(2)) && Character.isDigit(numberPlate.charAt(3)));
            boolean numberPlateInitals = (Character.isUpperCase(numberPlate.charAt(4)) && Character.isUpperCase(numberPlate.charAt(5)));
            boolean digitsAtEnd = (Character.isDigit(numberPlate.charAt(6)) && Character.isDigit(numberPlate.charAt(7)) &&
                    Character.isDigit(numberPlate.charAt(8)) && Character.isDigit(numberPlate.charAt(9)));

            if (stateInitials && stateNumber && numberPlateInitals && digitsAtEnd) {
                return true;
            } else {
                return false;
            }

        }else{
            return false;
        }
    }
    public void setVehicleNumPlate(String vehicleNumPlate) {
        this.vehicleNumPlate = vehicleNumPlate;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
