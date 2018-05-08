package com.simpleaddressbook;

import java.util.InputMismatchException;
import org.junit.Test;

public class BadInputsTest{
	@Test(expected = InputMismatchException.class)
	public void fileMenuBadInput(){
		// given
		AddressBookManager abm = new AddressBookManager();
		String simulatedBadUserInput = "not an integer" + System.getProperty("line.separator");
		
		// when
		abm.fileMenu(simulatedBadUserInput);
	}
	
	@Test(expected = InputMismatchException.class)
	public void addressBookMenuBadInput(){
		// given
		AddressBookManager abm = new AddressBookManager();
		String simulatedBadUserInput = "not an integer" + System.getProperty("line.separator");
		abm.newAddressBook(1);
		
		// when
		abm.editAddressBook(1, simulatedBadUserInput);
	}
	
	@Test(expected = InputMismatchException.class)
	public void entryMenuBadInput(){
		// given
		AddressBook ab = new AddressBook();
		String simulatedUserInput = "Zaykha" + System.getProperty("line.separator") 
		   + "Kyaw San" + System.getProperty("line.separator")
		   + "601 Fairmont St Nw" + System.getProperty("line.separator")
		   + "Washington" + System.getProperty("line.separator")
		   + "D.C" + System.getProperty("line.separator")
		   + "20059" + System.getProperty("line.separator")
		   + "202 749 2878" + System.getProperty("line.separator");
		// adding the Entry, with the simulated inputs, to the address book
		ab.addEntry(simulatedUserInput);
		String simulatedBadUserInput = "Zaykha" + System.getProperty("line.separator")
									 + "Kyaw San" + System.getProperty("line.separator")
									 + "not an integer" + System.getProperty("line.separator");
		
		// when
		ab.editEntries(simulatedBadUserInput);
	}
}