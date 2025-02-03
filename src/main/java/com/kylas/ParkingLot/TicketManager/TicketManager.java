package com.kylas.ParkingLot.TicketManager;

 import com.kylas.ParkingLot.Entity.*;
 import com.kylas.ParkingLot.EntityService.CheckDuplicateVehicle;
 import com.kylas.ParkingLot.EntityService.ParkingLotService;
 import com.kylas.ParkingLot.EntityService.SlotCheckService;
 import com.kylas.ParkingLot.EntityService.ValidateVehicleNo;
 import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
 import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;


public class TicketManager {
    private ParkingLotService parkingService;
    private SlotCheckService slotCheckService;
    private ParkingLotBuilding parkingLot;
    private ValidateVehicleNo validateVehicleNo;
    public TicketManager(int id, int numOfFloors, int spotsPerFloor) {
        this.parkingLot = new ParkingLotBuilding(id, numOfFloors, spotsPerFloor);
        this.parkingService = new ParkingLotService();
        this.slotCheckService = new SlotCheckService();
    }

    public void vehicleEntry(String vehicleNumberPlate, String vehicleType) throws VehicleNumberPlateFormatException, DuplicateVehicleEntry {
        Vehicle vehicle;
        validateVehicleNo=new ValidateVehicleNo();
        CheckDuplicateVehicle duplicateVehicle=new CheckDuplicateVehicle();

        if(validateVehicleNo.validateNumberPlateFormat(vehicleNumberPlate.toUpperCase())) {
            if(!duplicateVehicle.isDuplicateEntry(parkingLot,vehicleNumberPlate)) {
                vehicle = new Vehicle(vehicleNumberPlate, vehicleType);
            }else{
                throw new DuplicateVehicleEntry();
            }
        }else{
            throw new VehicleNumberPlateFormatException();
        }

        ParkingSlot slot = parkingService.vehicleEntry(parkingLot, vehicle);
        if (slot != null) {
            ParkingTicket parkingTicket=new ParkingTicket(vehicle.getVehicleNumPlate(), slot.getFloorNumber(), slot.getSlotId());
            System.out.println("Vehicle parked successfully.");
            parkingTicket.generateTicket();
        }else{
            System.out.println("Parking lot is full!!");
        }
    }

    public void vehicleExit(String vehicleNumberPlate) throws VehicleNumberPlateFormatException {
        if(validateVehicleNo.validateNumberPlateFormat(vehicleNumberPlate.toUpperCase())) {
        parkingService.vehicleExit(parkingLot, vehicleNumberPlate.toUpperCase());
        }else{
            throw new VehicleNumberPlateFormatException();
        }
    }

    public void showAvailableSlots() {
        int available = slotCheckService.getAvailableSlots(parkingLot);
        System.out.println("Total available spots: " + available);
        for (ParkingFloor floor : parkingLot.getFloors()) {
            long floorAvailable = floor.getSlots().stream().filter(slot -> !slot.isOccupied()).count();
            System.out.println("Floor " + floor.getFloorNumber() + ": " + floorAvailable + " spots available.");
        }
    }
}

