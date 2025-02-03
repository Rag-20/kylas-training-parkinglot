package com.kylas.ParkingLot;
import com.kylas.ParkingLot.ParkingLotExceptions.DuplicateVehicleEntry;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleNumberPlateFormatException;
import com.kylas.ParkingLot.ParkingLotExceptions.VehicleTypeException;
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
			ticketManager.vehicleEntry("MH12TB7750", "bie");
		}catch(DuplicateVehicleEntry e){
			System.out.println("Error: "+e.getMessage());
		} catch (VehicleNumberPlateFormatException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (VehicleTypeException e) {
			System.out.println("Error: "+e.getMessage());
		}

		try {
			ticketManager.vehicleEntry("MH12tB7750", "bike");
		}catch(DuplicateVehicleEntry e){
			System.out.println("Error: "+e.getMessage());
		}catch (VehicleNumberPlateFormatException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (VehicleTypeException e) {
			System.out.println("Error: "+e.getMessage());
		}

		ticketManager.showAvailableSlots();

		ticketManager.vehicleExit("MH12Tb7750");

		ticketManager.showAvailableSlots();
	}

}
