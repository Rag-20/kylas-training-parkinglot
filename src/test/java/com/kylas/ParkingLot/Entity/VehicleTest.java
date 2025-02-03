package com.kylas.ParkingLot.Entity;
import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleTypeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleTest {
    Vehicle vehicle=new Vehicle();

    @Test
    public void givenVehicleNumber_shouldGetVehicleNumber(){
        vehicle.setVehicleNumPlate("MH12TB2250");

        String vehicleNumber = vehicle.getVehicleNumPlate();

        Assertions.assertThat(vehicleNumber).isEqualTo("MH12TB2250");
    }

    @Test
    public void ifVehicleNumberIsNotSet_shouldGetNull(){

        String vehicleNumber = vehicle.getVehicleNumPlate();

        Assertions.assertThat(vehicleNumber).isNull();
    }

    @Test
    public void givenIncorrectVehicleNumberFormat_shouldThrowError(){
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,2,5);

       Assertions.assertThatThrownBy(()->vehicle.create(parkingLotBuilding,"MH12ttT2232","bike"))
               .isInstanceOf(VehicleNumberPlateFormatException.class)
               .hasMessage("\nVehicle Number Plate Format Error!!");
    }

    @Test
    public void givenIncorrectVehicleType_shouldThrowError(){
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,2,5);

        Assertions.assertThatThrownBy(()->vehicle.create(parkingLotBuilding,"MH12TB2232","plane"))
                .isInstanceOf(VehicleTypeException.class)
                .hasMessage("\nVehicle type is not valid!!");
    }

    @Test
    public void givenDuplicateVehicle_shouldThrowError(){
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,2,5);
        vehicle=new Vehicle("MH12TB2232","bike");
        parkingLotBuilding.parkVehicle(vehicle,parkingLotBuilding.getFloors().get(1).getSlots().get(1));

        Assertions.assertThatThrownBy(()->vehicle.create(parkingLotBuilding,"MH12TB2232","bike"))
                .isInstanceOf(DuplicateVehicleEntry.class)
                .hasMessage("\nVehicle Already exists!!");
    }

    @Test
    public void shouldInitialiseVehicleObject(){
        ParkingLotBuilding parkingLotBuilding=new ParkingLotBuilding(1,2,5);
        vehicle=new Vehicle("MH12TB2232","bike");

        Assertions.assertThatCode(()->vehicle.create(parkingLotBuilding,"MH12TB2232","bike"))
                .doesNotThrowAnyException();
    }
}