package com.simpleaddressbook;
import java.io.Serializable;

public class Address implements Serializable{
	private String address;
	private String city;
	private String state;
	private String zip;		// zip is a String Type because of cases that omits initial zeroes
	
	/**
	 * The default constructor which initializes the member variables to zero values
	 */
	public Address(){
		address = "";
		city = "";
		state = "";
		zip = "";
	}
	
	/**
	 * This constructor initializes the member variables to user input values 
	 * @param address is the street address
	 * @param city is the city name
	 * @param state	is the state name
	 * @param zip is the zip code
	 */
	public Address(String address, String city, String state, String zip){
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	// setters
	/**
	 * Sets the user input street address
	 * @param address is the user input street address
	 */
	public void setStreetAddress(String address){
		this.address = address;
	}
	
	/**
	 * Sets the user input city name
	 * @param city is the user input city name
	 */
	public void setCity(String city){
		this.city = city;
	}
	
	/**
	 * Sets the user input state name
	 * @param state	is the user input state name
	 */
	public void setState(String state){
		this.state = state;
	}
	
	/**
	 * Sets the user input zip code
	 * @param zip is the user input zip code
	 */
	public void setZip(String zip){
		this.zip = zip;
	}

	// getters
	/**
	 * @return Returns the currently listed street address in the entry
	 */
	public String getStreetAddress(){
		return this.address;
	}
	
	/**
	 * @return Returns the currently listed city in the entry
	 */	
	public String getCity(){
		return this.city;
	}
	
	/**
	 * @return Returns the currently listed state in the entry
	 */		
	public String getState(){
		return this.state;
	}
	
	/**
	 * @return Returns the currently listed zip code in the entry
	 */		
	public String getZip(){
		return this.zip;
	}
	
	/**
	 * Overrides the default toString() method to make the address string in mailing format
	 * which is: 
	 *			street address 
	 *			city, state zip
	 * @return string representation of the Address object
	 */
	@Override
	public String toString(){
		return this.address + "\n" + this.city + ", " + this.state + " " + this.zip;
	}
}