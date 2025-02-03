package com.kylas.ParkingLot.Entity;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

class ParkingSlotTest {

    @Test
    public void givenParkingSlotObject_shouldReturnSlotId() {
        ParkingSlot parkingSlot=new ParkingSlot(2,3);

        int slot= parkingSlot.getSlotId();

        Assertions.assertThat(slot).isEqualTo(3);
    }


    @Test
    public void givenParkingSlotObject_shouldReturnFloorNumber() {
        ParkingSlot parkingSlot=new ParkingSlot(2,3);

        int floorNumber= parkingSlot.getFloorNumber();

        Assertions.assertThat(floorNumber).isEqualTo(2);
    }

    @Test
    public void givenParkingSlotObject_slotNotOccupied_shouldValidateStatusOfSlot() {
        ParkingSlot parkingSlot=new ParkingSlot(2,3);

        boolean status= parkingSlot.isOccupied();

        Assertions.assertThat(status).isFalse();
    }

    @Test
    public void givenParkingSlotObject_slotOccupied_shouldValidateStatusOfSlot() {
        ParkingSlot parkingSlot=new ParkingSlot(2,3);
        parkingSlot.setOccupied(true);
        boolean status= parkingSlot.isOccupied();

        Assertions.assertThat(status).isTrue();
    }

    @Test
    public void givenParkingSlotObject_setStatus_shouldValidateStatus() {
        ParkingSlot parkingSlot=new ParkingSlot(2,3);
        parkingSlot.setOccupied(true);

        Assertions.assertThat(parkingSlot.isOccupied()).isTrue();
    }
}