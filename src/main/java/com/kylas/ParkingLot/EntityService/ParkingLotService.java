package com.kylas.ParkingLot.EntityService;


import com.kylas.ParkingLot.Entity.*;

public class ParkingLotService {
    public ParkingSlot vehicleEntry(ParkingLotBuilding lot, Vehicle vehicle) {
        for (ParkingFloor floor : lot.getFloors()) {
            for (ParkingSlot slot : floor.getSlots()) {
                if (!slot.isOccupied()) {
                    lot.parkVehicle(vehicle,slot);
                    return slot;
                }
            }
        }
        System.out.println("\nNo parking spots available.");
        return null;
    }

    public void vehicleExit(ParkingLotBuilding lot,String vehicleNumPlate) {
        ParkingSlot slot = lot.getSlotByVehicleNumber(vehicleNumPlate);
        if (slot != null) {
            lot.unparkVehicle(vehicleNumPlate,slot);  // Remove from the map
            System.out.println("\nVehicle " + vehicleNumPlate + " has been unparked from Floor " + slot.getFloorNumber() +
                    ", Slot " + slot.getSlotId());
        } else {
            System.out.println("\nVehicle with license plate " + vehicleNumPlate + " not found.");
        }
    }
}

