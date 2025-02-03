package com.kylas.ParkingLot.EntityService;


import com.kylas.ParkingLot.Entity.*;

public class ParkingLotService {
    public ParkingSlot vehicleEntry(ParkingLotBuilding lot, Vehicle vehicle) {
        for (ParkingFloor floor : lot.getFloors()) {
            for (ParkingSlot slot : floor.getSlots()) {
                if (!slot.isOccupied()) {
                    slot.setOccupied(true);
                    lot.parkVehicle(vehicle.getVehicleNumPlate(),slot);  // Track the vehicle in the parking lot
                    return slot;
                }
            }
        }
        System.out.println("No parking spots available.");
        return null;
    }

    public void vehicleExit(ParkingLotBuilding lot,String vehicleNumPlate) {
        ParkingSlot slot = lot.getSlotByVehicleNumber(vehicleNumPlate);
        if (slot != null) {
            slot.setOccupied(false);
            lot.unparkVehicle(vehicleNumPlate);  // Remove from the map
            System.out.println("Vehicle " + vehicleNumPlate + " has been unparked from Floor " + slot.getFloorNumber() +
                    ", Spot " + slot.getSlotId());
        } else {
            System.out.println("Vehicle with license plate " + vehicleNumPlate + " not found.");
        }
    }
}

