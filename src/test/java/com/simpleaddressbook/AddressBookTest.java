package com.simpleaddressbook;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AddressBookTest{
	@Test
	public void addNewPerson(){
		// given
		AddressBook ab = new AddressBook();
		String simulatedUserInput = "Zaykha" + System.getProperty("line.separator") 
		   + "Kyaw San" + System.getProperty("line.separator")
		   + "601 Fairmont St Nw" + System.getProperty("line.separator")
		   + "Washington" + System.getProperty("line.separator")
		   + "D.C" + System.getProperty("line.separator")
		   + "20059" + System.getProperty("line.separator")
		   + "202 749 2878" + System.getProperty("line.separator");
		
		Name name = new Name("Zaykha", "Kyaw San");
		Address address = new Address("601 Fairmont St Nw", "Washington", "D.C", "20059");
		String phone = "202 749 2878";
		Entry entry = new Entry(name, address, phone);
		
		// when
		ab.addEntry(simulatedUserInput);
		
		// then
		Assert.assertEquals(1, ab.getAddressBook().size());
		Assert.assertEquals(entry, ab.getAddressBook().get(0));
	}
	
	@Test
	public void editPerson(){
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
		
		// creating simulated inputs for each entry edit choice
		String editStreetAddress = "Zaykha" + System.getProperty("line.separator") 
								 + "Kyaw San" + System.getProperty("line.separator")
								 + 1 + System.getProperty("line.separator") 
								 + "555 St" + System.getProperty("line.separator");
		String editCity = "Zaykha" + System.getProperty("line.separator") 
						+ "Kyaw San" + System.getProperty("line.separator")
						+ 2 + System.getProperty("line.separator") 
						+ "Sky City" + System.getProperty("line.separator");
		String editState = "Zaykha" + System.getProperty("line.separator") 
						 + "Kyaw San" + System.getProperty("line.separator")
						 + 3 + System.getProperty("line.separator") 
						 + "Cloud State" + System.getProperty("line.separator");
		String editZip = "Zaykha" + System.getProperty("line.separator") 
					   + "Kyaw San" + System.getProperty("line.separator")
					   + 4 + System.getProperty("line.separator") 
					   + "11111" + System.getProperty("line.separator");
		String editPhone = "Zaykha" + System.getProperty("line.separator") 
						 + "Kyaw San" + System.getProperty("line.separator")
						 + 5 + System.getProperty("line.separator") 
						 + "000 000 0000" + System.getProperty("line.separator");
		
		Name name = new Name("Zaykha", "Kyaw San");
		Address address = new Address("555 St", "Sky City", "Cloud State", "11111");
		String phone = "000 000 0000";
		Entry entry = new Entry(name, address, phone);
		
		// when
		ab.editEntries(editStreetAddress);
		ab.editEntries(editCity);
		ab.editEntries(editState);
		ab.editEntries(editZip);
		ab.editEntries(editPhone);
		
		// then
		Assert.assertEquals(entry, ab.getAddressBook().get(0));
	}
	
	@Test
	public void deletePerson(){
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
		
		// creating simulated input for the first name and last name of the entry
		String nameInEntry = "Zaykha" + System.getProperty("line.separator") 
								 + "Kyaw San" + System.getProperty("line.separator");

		// when
		ab.deleteEntry(nameInEntry);
		
		// then
		Assert.assertEquals(0, ab.getAddressBook().size());
	}
}