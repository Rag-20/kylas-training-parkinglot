package com.kylas.ParkingLot.Entity;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

import java.util.List;

class ParkingLotBuildingTest {

    ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,4,10);
    @Test
    public void givenParkingLotObject_shouldReturnFloors() {
        List<ParkingFloor> floors=parkingLotBuilding.getFloors();

        Assertions.assertThat(floors.size()).isEqualTo(4);

        for(int i=0;i< floors.size();i++){
            Assertions.assertThat(floors.get(i).getFloorNumber()).isEqualTo(parkingLotBuilding.getFloors().get(i).getFloorNumber());
        }
    }


    @Test
    public void givenParkedVehicle_shouldReturnSlotByVehicleNumber() {
        Vehicle vehicle=new Vehicle("Mh12tb2123","bike");
        ParkingSlot slot=parkingLotBuilding.getFloors().get(2).getSlots().get(2);
        parkingLotBuilding.parkVehicle(vehicle,slot);

        ParkingSlot parkingSlot=parkingLotBuilding.getSlotByVehicleNumber(vehicle.getVehicleNumPlate());

        Assertions.assertThat(parkingSlot.getSlotId()).isEqualTo(slot.getSlotId());
    }

    @Test
    public void givenUnparkedVehicle_shouldReturnNull() {
        Vehicle vehicle=new Vehicle("Mh12tb2123","bike");
        ParkingSlot slot=parkingLotBuilding.getFloors().get(2).getSlots().get(2);
        parkingLotBuilding.parkVehicle(vehicle,slot);

        ParkingSlot parkingSlot=parkingLotBuilding.getSlotByVehicleNumber("MH12TB8888");

        Assertions.assertThat(parkingSlot).isNull();
    }

    @Test
    public void givenParkingLotBuilding_shouldReturnAvailable(){

        int availableSlots = parkingLotBuilding.getAvailableSlots();

        Assertions.assertThat(availableSlots).isEqualTo(40);
    }

    @Test
    public void ifVehicleIsParked_shouldReturnAvailable(){
        Vehicle vehicle=new Vehicle("Mh12tb2123","bike");
        ParkingSlot slot=parkingLotBuilding.getFloors().get(2).getSlots().get(2);
        parkingLotBuilding.parkVehicle(vehicle,slot);

        int availableSlots = parkingLotBuilding.getAvailableSlots();

        Assertions.assertThat(availableSlots).isEqualTo(39);
    }
}