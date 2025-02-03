package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.ParkingLotBuilding;
import com.kylas.ParkingLot.Entity.ParkingSlot;
import com.kylas.ParkingLot.Entity.Vehicle;
import com.kylas.ParkingLot.Entity.VehicleType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions.*;

class ParkingLotServiceTest {
    ParkingLotService parkingLotService=new ParkingLotService();
    @Test
    void givenVehicle_shouldParkVehicle() {
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,2,5);
        Vehicle vehicle=new Vehicle("MH12TB2232", VehicleType.CAR.name());

        ParkingSlot slot=parkingLotService.vehicleEntry(parkingLotBuilding,vehicle);

        Assertions.assertThat(slot.isOccupied()).isTrue();
    }

    @Test
    void givenVehicle_LotIsFull_shouldNotParkVehicle() {
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,1,1);
        Vehicle vehicle1=new Vehicle("MH12TB2232", VehicleType.CAR.name());
        parkingLotBuilding.parkVehicle(vehicle1,parkingLotBuilding.getFloors().get(0).getSlots().get(0));
        Vehicle vehicle2=new Vehicle("MH12TB2232", VehicleType.CAR.name());

        ParkingSlot slot=parkingLotService.vehicleEntry(parkingLotBuilding,vehicle2);

        Assertions.assertThat(slot).isNull();
    }

    @Test
    void ifVehicleIsPresent_shouldExitVehicle() {
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,1,1);
        Vehicle vehicle1=new Vehicle("MH12TB2232", VehicleType.CAR.name());
        parkingLotBuilding.parkVehicle(vehicle1,parkingLotBuilding.getFloors().get(0).getSlots().get(0));

        parkingLotService.vehicleExit(parkingLotBuilding,"MH12TB2232");

        Assertions.assertThat(parkingLotBuilding.getFloors().get(0).getSlots().get(0).isOccupied()).isFalse();
    }

}