package com.thepackage;
import java.io.Serializable;

public class Name implements Comparable<Name>, Serializable{
	private String fname;
	private String lname;
	
	public Name(){
		fname = "";
		lname = "";
	}
	
	public Name(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}
	
	// setters
	public void setFirstName(String fname){
		this.fname = fname;
	}
	
	public void setLastName(String lname){
		this.lname = lname;
	}
	
	// getters
	public String getFirstName(){
		return this.fname;
	}
	
	public String getLastName(){
		return this.lname;
	}
	
	@Override
	public String toString(){
		return this.fname + " " + this.lname;
	}

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