package com.kylas.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotBuilding {
    private long id;
    private List<ParkingFloor> floors;
    private Map<String, ParkingSlot> vehicleParkedMap;

    public ParkingLotBuilding(long id, int numOfFloors, int numOfSlotsPerFloor) {
        this.id = id;
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numOfFloors; i++) {
            floors.add(new ParkingFloor(i, numOfSlotsPerFloor));
        }
        this.vehicleParkedMap = new HashMap<>();
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void parkVehicle(String vehicleNumberPlate, ParkingSlot slot) {
        vehicleParkedMap.put(vehicleNumberPlate, slot);
    }

    public ParkingSlot unparkVehicle(String vehicleNumber) {
        return vehicleParkedMap.remove(vehicleNumber);
    }

    public ParkingSlot getSlotByVehicleNumber(String vehicleNumber) {
        return vehicleParkedMap.get(vehicleNumber);
    }

}
