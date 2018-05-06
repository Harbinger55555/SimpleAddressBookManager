package com.simpleaddressbook;
import java.io.Serializable;

public class Name implements Comparable<Name>, Serializable{
	private String fname;
	private String lname;
	
	/**
	 * The default constructor which initializes the member variables to zero values
	 */	
	public Name(){
		fname = "";
		lname = "";
	}

	/**
	 * This constructor initializes the member variables to user input values 
	 * @param fname is the first name
	 * @param lname	is the last name
	 */
	public Name(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}
	
	// setters
	/**
	 * Sets the user input first name
	 * @param fname is the user input first name
	 */
	public void setFirstName(String fname){
		this.fname = fname;
	}

	/**
	 * Sets the user input last name
	 * @param lname is the user input last name
	 */	
	public void setLastName(String lname){
		this.lname = lname;
	}
	
	// getters
	/**
	 * @return the currently listed first name of the entry
	 */
	public String getFirstName(){
		return this.fname;
	}
	
	/**
	 * @return the currently listed last name of the entry
	 */	
	public String getLastName(){
		return this.lname;
	}
	
	/**
	 * Overrides the default toString() method to make the name string in the format:
	 * 		first name last name
	 * @return the string representation of the Name object
	 */	
	@Override
	public String toString(){
		return this.fname + " " + this.lname;
	}
	
	/**
	 * Overrides the default compareTo() method to compare two Name objects' hexadecimal values
	 * of their last names initially then breaking ties with their first names
	 * @param another is the Name object being compared with
	 * @return negative, 0, or positive integer result of the comparison made
	 */
	@Override
	public int compareTo(Name another){
		// compare last names
		int res = this.lname.compareTo(another.lname);
		// break ties with first names
		if (res != 0){
			return res;
		}
		else {
			res = this.fname.compareTo(another.fname);
		}
		return res;
	}
	
	/**
	 * Overrides the default equals() method to check if it is being compared with
	 * itself, an object of another class, or another Name object
	 * @param another is an object of any type being compared with
	 * @return true if it is compared with itself <br>
	 * 		   false if it is compared with an object of another class <br>
	 *		   boolean result of the comparison made between the two Name objects' string representations
	 */
	@Override
    public boolean equals(Object another) {
 
        // Return True if object is compared with itself  
        if (another == this) {
            return true;
        }
 
        // Check if another is an instance of Name or not; "null instanceof [type]" also returns false
        if (!(another instanceof Name)) {
            return false;
        }
         
        // typecast another to Name to compare 
        Name o = (Name) another;
         
        return this.toString().equals(o.toString());
    }
}