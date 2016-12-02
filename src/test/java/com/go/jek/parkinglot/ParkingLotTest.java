/**
 * 
 */
package com.go.jek.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.impl.ParkingLotImpl;

import junit.framework.Assert;

/**
 * @author marwb
 *
 *Order was imposed because junit does not run methods in order of 
 *appearance in file
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ParkingLotTest {

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#ParkingLotImpl()}.
	 */

	private static ParkingLot parkinglot;
	private static int sizeOfParkinglot;
	@BeforeClass
	public static void InitiateSetUp(){
		parkinglot=new ParkingLotImpl();
		sizeOfParkinglot=6;
	}


	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#createParkingLot(java.lang.String)}.
	 */
	@Test
	public void atestCreateParkingLot() {
		
		assertEquals(sizeOfParkinglot, parkinglot.createParkingLot(ParkingLot.CREATE_PARKING_LOT_COMMAND+" "+sizeOfParkinglot));
			
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#parkVehicle(java.lang.String)}.
	 */
	@Test
	public void btestParkVehicle() {
		String parkcommand="park KA01HH1234 blue";
		
		assertTrue(parkinglot.canParkVehicle(parkcommand));
		
		//fail("Not yet implemented");
	}

	

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#leaveVehicle(java.lang.String)}.
	 */
	@Test
	public void ctestLeaveVehicle() {
		
	String leaveCommand="leave 1";
	System.out.println("testing leave function for vehicle at sot 1");
	assertTrue(parkinglot.leaveVehicle(leaveCommand));
	
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#getStatus()}.
	 */
	/*@Test
	public void testGetStatus() {
	//	fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkVehicleNumberOfWhiteCars()}.
	 */
	@Test
	public void dtestCheckVehicleNumberOfWhiteCars() {
		String parkvehicle="park KA01HH1234 White";
		String parkvehicle1="park KA01HH9999 White";
		assertTrue(parkinglot.canParkVehicle(parkvehicle));
		assertTrue(parkinglot.canParkVehicle(parkvehicle1));
		
		Assert.assertEquals("Returned vehicle number", "KA01HH1234,KA01HH9999", parkinglot.checkVehicleNumberOfWhiteCars());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkSlotNumberofWhiteCars()}.
	 */
	@Test
	public void etestCheckSlotNumberofWhiteCars() {
		//fail("Not yet implemented");
		
		
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkSlotNumberForVehicle(java.lang.String)}.
	 * We have to introduce a method which will count no of vehicles parked,since vehicles are always parked from
	 * 
	 * nearest to location.if 1,2,3 is occupied then 4th place will be where vehicle will be parked.In thsi way we have to remember when we sent the
	 * vehicle for parking,we need to know which number was vehicle that is whether it was 1st,2nd or third
	 */
	@Test
	public void ftestCheckSlotNumberForVehicle() {
		String command="park KA01HH3141 Black";
		assertTrue(parkinglot.canParkVehicle(command));
		Assert.assertEquals(parkinglot.getTotalVehiclesParked(), parkinglot.checkSlotNumberForVehicle("status KA01HH3141"));
		
		
		
	}

}
