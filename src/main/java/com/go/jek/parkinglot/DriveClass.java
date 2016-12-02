package com.go.jek.parkinglot;
/**
 * 
 */

import java.io.IOException;
import java.util.Scanner;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.impl.ParkingLotImpl;

/**
 * @author marwb
 *
 */
public class DriveClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*try {
			LaunchShell.launchShell("cmd.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Scanner sc = new Scanner(System.in);

		ParkingLot parkingLot = new ParkingLotImpl();
		while (sc.hasNext()) {
			String command = sc.nextLine();

			if (command.contains(ParkingLot.CREATE_PARKING_LOT_COMMAND)) {
				parkingLot.createParkingLot(command);
			} else if (command.contains(ParkingLot.PARKING_COMMAND)) {
				parkingLot.canparkVehicle(command);
			} else if (command.contains(ParkingLot.LEAVE_COMMAND)) {

				parkingLot.leaveVehicle(command);
			} else if (command.contains(ParkingLot.STATUS)) {
				parkingLot.getStatus();
			} else if (command.equals(ParkingLot.WHITE_CAR_REG_NUMBER_INFO)) {
				parkingLot.checkVehicleNumberOfWhiteCars();
			} else if (command.equals(ParkingLot.WHITE_CAR_PARK_SLOT_INFO)) {
				parkingLot.checkSlotNumberofWhiteCars();
			} else if (command.contains(ParkingLot.QUERY_STATUS_OF_CAR)) {
				parkingLot.checkSlotNumberForVehicle(command);
			}

		}

		sc.close();

	}

}
