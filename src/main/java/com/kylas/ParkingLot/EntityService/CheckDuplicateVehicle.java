package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.ParkingLotBuilding;
import com.kylas.ParkingLot.Entity.ParkingSlot;

public class CheckDuplicateVehicle {
    private String vehicleNumberPlate;
    ParkingLotBuilding lot;

    public boolean isDuplicateEntry(ParkingLotBuilding lot,String vehicleNumberPlate){
        ParkingSlot slot=lot.getSlotByVehicleNumber(vehicleNumberPlate.toUpperCase());
        if(slot!=null){
            return true;
        }else{
            return false;
        }
    }
}
