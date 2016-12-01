package com.go.jek.parkinglot.impl;
/**
 * 
 */


/**
 * @author marwb
 *
 */
public class Vehicle {

	/**
	 * 
	 */
	
	private String registrationNumber;
	private String color;
	public Vehicle(String registrationNumber,String color) {
		// TODO Auto-generated constructor stub
		this.registrationNumber=registrationNumber;
		this.color=color;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getColor() {
		return color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationNumber == null)
				? 0
				: registrationNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", color="
				+ color + "]";
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
}
