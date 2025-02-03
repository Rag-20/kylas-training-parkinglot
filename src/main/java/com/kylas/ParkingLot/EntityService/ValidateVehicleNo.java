package com.kylas.ParkingLot.EntityService;

public class ValidateVehicleNo {
    public boolean validateNumberPlateFormat(String numberPlate){
           if(numberPlate.length()==10) {
               if (Character.isUpperCase(numberPlate.charAt(0))
                       && Character.isUpperCase(numberPlate.charAt(1))
                       && Character.isUpperCase(numberPlate.charAt(4))
                       && Character.isUpperCase(numberPlate.charAt(5))
                       && Character.isDigit(numberPlate.charAt(2))
                       && Character.isDigit(numberPlate.charAt(3))
                       && Character.isDigit(numberPlate.charAt(6))
                       && Character.isDigit(numberPlate.charAt(7))
                       && Character.isDigit(numberPlate.charAt(8))
                       && Character.isDigit(numberPlate.charAt(9))
               ){
                   return true;
               } else {
                   return false;
               }
           }else{
               return false;
           }

    }
}
