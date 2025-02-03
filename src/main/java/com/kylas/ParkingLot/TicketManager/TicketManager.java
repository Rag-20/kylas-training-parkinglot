package com.kylas.ParkingLot.TicketManager;
import com.kylas.ParkingLot.Entity.*;
import com.kylas.ParkingLot.EntityService.ParkingLotService;
import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleTypeException;


public class TicketManager {
    private ParkingLotService parkingService;
    private ParkingLotBuilding parkingLot;
    public TicketManager(int id, int numOfFloors, int spotsPerFloor) {
        this.parkingLot = new ParkingLotBuilding(id, numOfFloors, spotsPerFloor);
        this.parkingService = new ParkingLotService();
    }

    public void vehicleEntry(String vehicleNumberPlate, String vehicleType) throws DuplicateVehicleEntry, VehicleNumberPlateFormatException, VehicleTypeException {
        Vehicle vehicle = new Vehicle();

        try {
            vehicle = vehicle.create(parkingLot,vehicleNumberPlate, vehicleType);
        }catch (VehicleNumberPlateFormatException e){
            throw new VehicleNumberPlateFormatException();
        } catch (VehicleTypeException e) {
            throw new VehicleTypeException();
        }catch(DuplicateVehicleEntry e){
            throw new DuplicateVehicleEntry();
        }

        ParkingSlot slot = parkingService.vehicleEntry(parkingLot, vehicle);
        if (slot != null) {
            ParkingTicket parkingTicket=new ParkingTicket(vehicle,slot);
            System.out.println("\nVehicle parked successfully.");
            System.out.println(parkingTicket);
        }else{
            System.out.println("\nParking lot is full!!");
        }
    }

    public void vehicleExit(String vehicleNumberPlate) {
        parkingService.vehicleExit(parkingLot, vehicleNumberPlate.toUpperCase());
    }

    public void showAvailableSlots() {
        int available = parkingLot.getAvailableSlots();
        System.out.println("\nTotal available spots: " + available);
        for (ParkingFloor floor : parkingLot.getFloors()) {
            long slotsAvailable = floor.getSlots().stream().filter(slot -> !slot.isOccupied()).count();
            System.out.println("Floor " + floor.getFloorNumber() + ": " + slotsAvailable + " slots available.");
        }
    }
}

