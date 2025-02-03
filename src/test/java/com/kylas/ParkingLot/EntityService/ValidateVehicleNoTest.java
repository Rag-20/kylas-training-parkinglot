package com.kylas.ParkingLot.EntityService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValidateVehicleNoTest {

    @InjectMocks
    public ValidateVehicleNo validateVehicleNo;

    @Test
    public void givenValidBikeNo_tryToValidate_shouldValidate(){
        //given
        String bikeNo = "MH23BG1729";
        //when
        boolean isBikeNoIsValid = validateVehicleNo.validateNumberPlateFormat(bikeNo);
        //then
        Assertions.assertThat(isBikeNoIsValid).isTrue();
    }

    @Test
    public void givenInValidBikeNo_tryToValidate_shouldValidate(){
        //given
        String bikeNo = "MH23BsdfghjsdfghjG1729";
        //when
        boolean isBikeNoIsValid = validateVehicleNo.validateNumberPlateFormat(bikeNo);
        //then
        Assertions.assertThat(isBikeNoIsValid).isFalse();
    }

    @Test
    public void givenIncorrectNumberPlateSequence_tryToValidate_shouldValidate(){
        //given
        String bikeNo = "23MHab3345";
        //when
        boolean isBikeNoIsValid = validateVehicleNo.validateNumberPlateFormat(bikeNo);
        //then
        Assertions.assertThat(isBikeNoIsValid).isFalse();
    }

    @Test
    public void givenBikeNoInLowerCase_tryToValidate_shouldValidate(){
        //given
        String bikeNo = "mh12tb3345";
        //when
        boolean isBikeNoIsValid = validateVehicleNo.validateNumberPlateFormat(bikeNo);
        //then
        Assertions.assertThat(isBikeNoIsValid).isFalse();
    }

}