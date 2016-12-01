/**
 * 
 */
package com.go.jek.parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.go.jek.parkinglot.api.ParkingLot;
import com.go.jek.parkinglot.impl.ParkingLotImpl;

/**
 * @author marwb
 *
 */
public class ParkingLotTest {

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#ParkingLotImpl()}.
	 */

	private ParkingLot parkinglot;
	private int sizeOfParkinglot;
	@Before
	public void InitiateSetUp(){
		parkinglot=new ParkingLotImpl();
		sizeOfParkinglot=6;
	}


	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#createParkingLot(java.lang.String)}.
	 */
	@Test
	public void testCreateParkingLot() {
		
		assertEquals(sizeOfParkinglot, parkinglot.createParkingLot(ParkingLot.CREATE_PARKING_LOT_COMMAND+" "+sizeOfParkinglot));
			
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#parkVehicle(java.lang.String)}.
	 */
	@Test
	public void testParkVehicle() {
		String parkcommand="park KA01HH1234 White";
		
		assertTrue(parkinglot.canparkVehicle(parkcommand));
		
		//fail("Not yet implemented");
	}

	

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#leaveVehicle(java.lang.String)}.
	 */
	@Test
	public void testLeaveVehicle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#getStatus()}.
	 */
	@Test
	public void testGetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkVehicleNumberOfWhiteCars()}.
	 */
	@Test
	public void testCheckVehicleNumberOfWhiteCars() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkSlotNumberofWhiteCars()}.
	 */
	@Test
	public void testCheckSlotNumberofWhiteCars() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.go.jek.parkinglot.impl.ParkingLotImpl#checkSlotNumberForVehicle(java.lang.String)}.
	 */
	@Test
	public void testCheckSlotNumberForVehicle() {
		fail("Not yet implemented");
	}

}
