package com.go.jek.parkinglot.api;
/**
 * 
 */

import com.go.jek.parkinglot.exception.ParkingSpaceNotCreatedException;

/**
 * @author marwb
 *
 */
public interface ParkingLot {
	String WHITE_CAR_REG_NUMBER_INFO="registration_numbers_for_cars_with_colour White";
	String 	WHITE_CAR_PARK_SLOT_INFO="slot_numbers_for_cars_with_colour White";
	String QUERY_STATUS_OF_CAR="slot_number_for_registration_number";
	String STATUS_NOT_FOUND="Not Found";
	String CREATE_PARKING_LOT_COMMAND="create_parking_lot";
	String ALLOCATION_STATUS_OUTPUT="Allocated slot number:";
	String PARKING_COMMAND="park";
	String 	LEAVE_COMMAND="leave";
	String EMPTY_STRING=" ";
	String SLOT="slots";
	String 	PARKING_LOT_CREATED_STATUS="Created a parking lot with";
	
	String WHITE_COLOR="white";
	String STATUS="status";
	String PARKING_LOT_FULL="Sorry, parking lot is full";
	int getTotalVehiclesParked();
	int createParkingLot(String command);
	boolean isParkingSpaceFull() throws ParkingSpaceNotCreatedException;
	boolean  canParkVehicle(String parkCommand);
	boolean  leaveVehicle(String leaveCommand);
	void getStatus();
	String checkVehicleNumberOfWhiteCars();
	String checkSlotNumberofWhiteCars();
	
	int checkSlotNumberForVehicle(String regno);
	

}
