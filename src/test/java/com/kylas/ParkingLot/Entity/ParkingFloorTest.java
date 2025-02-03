package com.kylas.ParkingLot.Entity;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

import java.util.List;

class ParkingFloorTest {

    @Test
    void givenFloorObject_shouldReturnFloorNumber() {
        ParkingFloor parkingFloor=new ParkingFloor(2,10);

        int floor=parkingFloor.getFloorNumber();

        Assertions.assertThat(floor).isEqualTo(2);
    }

    @Test
    void givenFloorObject_shouldReturngSlot() {
        ParkingFloor parkingFloor=new ParkingFloor(2,10);

        List<ParkingSlot> slots = parkingFloor.getSlots();

        Assertions.assertThat(slots.size()).isEqualTo(10);

        for(int i=0;i< slots.size();i++){
            Assertions.assertThat(slots.get(i).getSlotId()).isEqualTo(parkingFloor.getSlots().get(i).getSlotId());
        }
    }
}