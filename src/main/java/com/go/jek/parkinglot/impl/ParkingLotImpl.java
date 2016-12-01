package com.go.jek.parkinglot.impl;
/**
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.exception.ParkingSpaceNotCreatedException;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author marwb
 *
 */
public class ParkingLotImpl implements ParkingLot {

	/**
	 * 
	 */

	private TreeSet<Integer> vehicleSlotFreed;
	private int sizeOfParkingLot;

	private TreeMap<Integer, Vehicle> treemap;

	private List<Integer> slotNumberForWhiteCars = new ArrayList<>();
	private List<String> registrationNumberForWhite = new ArrayList<>();
	public ParkingLotImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#createParkingLot(int)
	 */
	@Override
	public int createParkingLot(String createParkingLot) {
		// TODO Auto-generated method stub
		
		String []arr=createParkingLot.split(EMPTY_STRING);
		this.sizeOfParkingLot = Integer.parseInt(arr[1]);
		this.vehicleSlotFreed = new TreeSet<>();

		for (int j = 1; j <= sizeOfParkingLot; j++) {
			vehicleSlotFreed.add(j);
		}
		treemap = new TreeMap<>();
		StringBuilder sb = new StringBuilder(PARKING_LOT_CREATED_STATUS);
		sb.append(EMPTY_STRING).append(sizeOfParkingLot).append(EMPTY_STRING)
				.append(SLOT);

	System.out.println(sb);
	
	return vehicleSlotFreed.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#checkIfParkingSpaceAvaliable()
	 */
	@Override
	public boolean isParkingSpaceFull() throws ParkingSpaceNotCreatedException {
		// TODO Auto-generated method stub

		if (null == treemap)
			throw new ParkingSpaceNotCreatedException(
					"Parking Space Not Created,Can't park the cars");
		return sizeOfParkingLot == treemap.size();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#parkVehicle(java.lang.String)
	 */
	@Override
	public boolean canparkVehicle(String parkCommand) {
		// TODO Auto-generated method stub
		if (parkCommand == null || parkCommand.isEmpty()) {
			return false;
		}

		String[] arr = parkCommand.split(EMPTY_STRING);
		String regNumber = arr[1].trim();
		
		String vehicleColor = arr[2].trim();
		try {
			if (!isParkingSpaceFull()) {
				Vehicle vehicle = new Vehicle(regNumber, vehicleColor);
				int lotnumber = vehicleSlotFreed.pollFirst();
				treemap.put(lotnumber, vehicle);
				if (vehicleColor.equalsIgnoreCase(WHITE_COLOR)) {
					updateCarMetaDataForwhiteCars(lotnumber, regNumber);
				}

				System.out.println(ALLOCATION_STATUS_OUTPUT + " " + lotnumber);

			} else{
				System.out.println(PARKING_LOT_FULL);
				return false;
			}
		} catch (ParkingSpaceNotCreatedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
			return false;

		}
		return true;
	}

	public void updateCarMetaDataForwhiteCars(int lotnumber, String regNumber) {
		registrationNumberForWhite.add(regNumber);
		slotNumberForWhiteCars.add(lotnumber);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#leaveVehicle(int)
	 */
	@Override
	public void leaveVehicle(String leavecommand) {
		// TODO Auto-generated method stub

		
		String[]arr=leavecommand.split(EMPTY_STRING);
		int parkinglot=Integer.parseInt(arr[1]);
		vehicleSlotFreed.add(parkinglot);
		if (slotNumberForWhiteCars.contains(parkinglot)) {
			slotNumberForWhiteCars.remove(parkinglot);
		}
		String carreg = "";
		if (treemap.containsKey(parkinglot)) {
			Vehicle vehicle = treemap.get(parkinglot);
			String color = vehicle.getColor();
			carreg = vehicle.getRegistrationNumber();
			if (color.equalsIgnoreCase(WHITE_COLOR)) {
				registrationNumberForWhite.remove(carreg);
			}
			treemap.remove(parkinglot);

		}

		System.out
				.println(SLOT + " " + "NUMBER " + parkinglot + " " + "is free");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#getStatus()
	 */
	@Override
	public void getStatus() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, Vehicle> entry : treemap.entrySet()) {
			sb.append(entry.getKey()).append("\t")
					.append(entry.getValue().getRegistrationNumber())
					.append("\t").append(entry.getValue().getColor())
					.append("\n");
		}

		System.out.println(sb.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#checkVehicleNumberOfWhiteCars()
	 */
	@Override
	public void checkVehicleNumberOfWhiteCars() {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		for (String regnumber : registrationNumberForWhite) {
			sb.append(regnumber).append(",");
		}

		System.out.println(sb);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.arralist.ParkingLot#checkSlotNumberofWhiteCars()
	 */
	@Override
	public void checkSlotNumberofWhiteCars() {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();

		for (Integer in : slotNumberForWhiteCars) {

			sb.append(in).append(" ,");

		}

		System.out.println(sb);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.arralist.ParkingLot#checkSlotNumberForVehicle(java.lang.String)
	 */
	@Override
	public void checkSlotNumberForVehicle(String command) {
		// TODO Auto-generated method stub

		String regno=command.split(EMPTY_STRING)[1];
		boolean is_vehicle_found = false;

		for (Entry<Integer, Vehicle> entry : treemap.entrySet()) {
			if (entry.getValue().getRegistrationNumber()
					.equalsIgnoreCase(regno)) {
				is_vehicle_found = true;
				System.out.println(entry.getKey());
				break;
			}
		}

		if (!is_vehicle_found)
			System.out.println(STATUS_NOT_FOUND);

	}

}
