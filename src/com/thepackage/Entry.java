package com.thepackage;
import java.io.Serializable;

public class Entry implements Comparable<Entry>, Serializable{
	private Name name;
	private Address address;
	private String phone;
	
	public Entry(){
		name = null;
		address = null;
		phone = "";
	}
	
	public Entry(Name name, Address address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	// setters
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	// getters
	public Name getName(){
		return this.name;
	}
	
	public Address getAddress(){
		return this.address;
	}

	public String getPhone(){
		return this.phone;
	}	
	
	// prints in mailing format
	@Override
	public String toString(){
		return this.name.toString() + "\n" + this.address.toString() + "\n" + this.phone;
	}
	
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