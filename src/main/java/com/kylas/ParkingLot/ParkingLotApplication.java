package com.kylas.ParkingLot;
import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kylas.ParkingLot.TicketManager.TicketManager;

@SpringBootApplication
public class ParkingLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);

		 TicketManager ticketManager= new TicketManager(1, 3, 5);

		ticketManager.showAvailableSlots();

        try {
            ticketManager.vehicleEntry("MH12TB7750", "Sedan");
        } catch (VehicleNumberPlateFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }catch(DuplicateVehicleEntry e){
			System.out.println("Error: "+e.getMessage());
		}

		try {
			ticketManager.vehicleEntry("MH12tB7750", "Sedan");
		} catch (VehicleNumberPlateFormatException e) {
			System.out.println("Error: "+e.getMessage());
		}catch(DuplicateVehicleEntry e){
			System.out.println("Error: "+e.getMessage());
		}

		ticketManager.showAvailableSlots();
		try {
		ticketManager.vehicleExit("MH12Tb7750");
		} catch (VehicleNumberPlateFormatException e) {
			System.out.println("Error: "+e.getMessage());
		}
		ticketManager.showAvailableSlots();
	}

}
