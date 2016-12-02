package com.go.jek.parkinglot;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.impl.ParkingLotImpl;

/**
 * @author marwb
 *
 */
public class DriveClass {

	public InputStream getClassLoaderPath(String filename) {
		return getClass().getClassLoader().getResourceAsStream(filename);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DriveClass driveclass = new DriveClass();
		ParkingLot parkingLot = new ParkingLotImpl();
		String command="";
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			command = sc.nextLine().trim();
			if (command.contains(".txt")) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(driveclass.getClassLoaderPath(command)));

				
				try {
					while ((command = br.readLine()) != null) {

						if (command.contains(
								ParkingLot.CREATE_PARKING_LOT_COMMAND)) {
							parkingLot.createParkingLot(command);
						} else if (command
								.contains(ParkingLot.PARKING_COMMAND)) {
							parkingLot.canParkVehicle(command);
						} else if (command.contains(ParkingLot.LEAVE_COMMAND)) {

							parkingLot.leaveVehicle(command);
						} else if (command.contains(ParkingLot.STATUS)) {
							parkingLot.getStatus();
						} else if (command
								.equals(ParkingLot.WHITE_CAR_REG_NUMBER_INFO)) {
							parkingLot.checkVehicleNumberOfWhiteCars();
						} else if (command
								.equals(ParkingLot.WHITE_CAR_PARK_SLOT_INFO)) {
							parkingLot.checkSlotNumberofWhiteCars();
						} else if (command
								.contains(ParkingLot.QUERY_STATUS_OF_CAR)) {
							parkingLot.checkSlotNumberForVehicle(command);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br.close();
				
			} else {
				/*String command;
				command = sc.nextLine();
*/
				if (command.contains(ParkingLot.CREATE_PARKING_LOT_COMMAND)) {
					parkingLot.createParkingLot(command);
				} else if (command.contains(ParkingLot.PARKING_COMMAND)) {
					parkingLot.canParkVehicle(command);
				} else if (command.contains(ParkingLot.LEAVE_COMMAND)) {

					parkingLot.leaveVehicle(command);
				} else if (command.contains(ParkingLot.STATUS)) {
					parkingLot.getStatus();
				} else if (command
						.equals(ParkingLot.WHITE_CAR_REG_NUMBER_INFO)) {
					parkingLot.checkVehicleNumberOfWhiteCars();
				} else if (command
						.equals(ParkingLot.WHITE_CAR_PARK_SLOT_INFO)) {
					parkingLot.checkSlotNumberofWhiteCars();
				} else if (command.contains(ParkingLot.QUERY_STATUS_OF_CAR)) {
					parkingLot.checkSlotNumberForVehicle(command);
				}

			}
		}
		sc.close();
	}

}
