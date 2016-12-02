package com.go.jek.parkinglot;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.impl.ParkingLotImpl;

/**
 * @author marwb
 *
 */
public class DriveClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/*try {
			LaunchShell.launchShell("cmd.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ParkingLot parkingLot = new ParkingLotImpl();
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/my_program file_inputs.txt"))));
		String command;
		try {
			while ((command = br.readLine()) != null) {
			  
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		br.close();
		/*Scanner sc = new Scanner(System.in);
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
*/
		

	}

}
