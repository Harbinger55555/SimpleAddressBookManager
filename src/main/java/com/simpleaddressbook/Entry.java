package com.simpleaddressbook;
import java.io.Serializable;

/**
 * This class consists of methods to create, or make changes to, an Entry object to be used in the AddressBook class.
 *
 * @author Zaykha Kyaw San
 * @version 1.0
 * @since 2018-05-06
 */
public class Entry implements Comparable<Entry>, Serializable{
	private Name name;
	private Address address;
	private String phone;

	/**
	 * The default constructor which initializes the member variables to zero values.
	 */
	public Entry(){
		name = null;
		address = null;
		phone = "";
	}
	
	/**
	 * This constructor initializes the member variables to user input values.
	 * @param name is the Name object.
	 * @param address is the Address object.
	 * @param phone is the phone number, which is a string.
	 */	
	public Entry(Name name, Address address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	// setters
	/**
	 * Sets the user input phone number.
	 * @param phone is the user input phone number.
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	// getters
	/**
	 * Returns the Name object of the entry.
	 * @return the Name object of the entry.
	 */
	public Name getName(){
		return this.name;
	}
	
	/**
	 * Returns the Address object of the entry.
	 * @return the Address object of the entry.
	 */	
	public Address getAddress(){
		return this.address;
	}

	/**
	 * Returns the phone number string of the entry.
	 * @return the phone number string of the entry.
	 */
	public String getPhone(){
		return this.phone;
	}	

	/**
	 * Overrides the default toString() method to make the entry string in the format:<br>
	 * <pre>
	 * <i>first name last name</i>
	 * <i>street address</i>
	 * <i>city, state zip</i>
	 * <i>phone number</i>
	 * </pre>
	 * @return the string representation of the Entry object.
	 */		
	// prints in mailing format
	@Override
	public String toString(){
		return this.name.toString() + "\n" + this.address.toString() + "\n" + this.phone;
	}

	/**
	 * Overrides the default compareTo() method to compare two Entry objects' zip codes 
	 * by default then breaking ties with their names.
	 * @param another is the Entry object being compared with.
	 * @return negative, 0, or positive integer result of the comparison made.
	 */	
	@Override
	// by default Entries will be compared using zip codes and breaking ties with names
	public int compareTo(Entry another){
		// compare with zip codes
		int res = this.address.getZip().compareTo(another.address.getZip());
		if (res != 0){
			return res;
		}
		else {
			res = this.name.compareTo(another.name);
		}
		return res;
	}
}