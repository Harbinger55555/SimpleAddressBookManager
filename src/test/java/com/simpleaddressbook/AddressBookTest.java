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
	
	@Test
	public void sortByName(){
		// given
		AddressBook ab = new AddressBook();
		String simulatedUserInput1 = "Zaykha" + System.getProperty("line.separator") 
		   + "Kyaw San" + System.getProperty("line.separator")
		   + "601 Fairmont St Nw" + System.getProperty("line.separator")
		   + "Washington" + System.getProperty("line.separator")
		   + "D.C" + System.getProperty("line.separator")
		   + "11111" + System.getProperty("line.separator")
		   + "202 749 2878" + System.getProperty("line.separator");
		String simulatedUserInput2 = "Jerry" + System.getProperty("line.separator") 
		   + "Wei" + System.getProperty("line.separator")
		   + "555 St" + System.getProperty("line.separator")
		   + "Hidden City" + System.getProperty("line.separator")
		   + "London" + System.getProperty("line.separator")
		   + "22222" + System.getProperty("line.separator")
		   + "555 592 5260" + System.getProperty("line.separator");
		String simulatedUserInput3 = "Kaleshwar" + System.getProperty("line.separator") 
		   + "Singh" + System.getProperty("line.separator")
		   + "Avenue St" + System.getProperty("line.separator")
		   + "Leaf City" + System.getProperty("line.separator")
		   + "Maryland" + System.getProperty("line.separator")
		   + "10001" + System.getProperty("line.separator")
		   + "826 947 1523" + System.getProperty("line.separator");
		String simulatedUserInput4 = "Aaron" + System.getProperty("line.separator") 
		   + "Wei" + System.getProperty("line.separator")
		   + "777 St" + System.getProperty("line.separator")
		   + "Water City" + System.getProperty("line.separator")
		   + "London" + System.getProperty("line.separator")
		   + "59875" + System.getProperty("line.separator")
		   + "123 456 7890" + System.getProperty("line.separator");
		// adding the Entries, with the simulated inputs, to the address book
		ab.addEntry(simulatedUserInput1);
		ab.addEntry(simulatedUserInput2);
		ab.addEntry(simulatedUserInput3);
		ab.addEntry(simulatedUserInput4);
		
		Name name = new Name("Zaykha", "Kyaw San");
		Address address = new Address("601 Fairmont St Nw", "Washington", "D.C", "11111");
		String phone = "202 749 2878";
		Entry entry1 = new Entry(name, address, phone);
		name = new Name("Jerry", "Wei");
		address = new Address("555 St", "Hidden City", "London", "22222");
		phone = "555 592 5260";
		Entry entry2 = new Entry(name, address, phone);
		name = new Name("Kaleshwar", "Singh");
		address = new Address("Avenue St", "Leaf City", "Maryland", "10001");
		phone = "826 947 1523";
		Entry entry3 = new Entry(name, address, phone);
		name = new Name("Aaron", "Wei");
		address = new Address("777 St", "Water City", "London", "59875");
		phone = "123 456 7890";
		Entry entry4 = new Entry(name, address, phone);

		// when
		ab.sortEntries(1);
		
		// then
		Assert.assertEquals(entry1, ab.getAddressBook().get(0));
		Assert.assertEquals(entry3, ab.getAddressBook().get(1));
		Assert.assertEquals(entry4, ab.getAddressBook().get(2));
		Assert.assertEquals(entry2, ab.getAddressBook().get(3));		
	}
	
	@Test
	public void sortByZip(){
		// given
		AddressBook ab = new AddressBook();
		String simulatedUserInput1 = "Zaykha" + System.getProperty("line.separator") 
		   + "Kyaw San" + System.getProperty("line.separator")
		   + "601 Fairmont St Nw" + System.getProperty("line.separator")
		   + "Washington" + System.getProperty("line.separator")
		   + "D.C" + System.getProperty("line.separator")
		   + "11111" + System.getProperty("line.separator")
		   + "202 749 2878" + System.getProperty("line.separator");
		String simulatedUserInput2 = "Jerry" + System.getProperty("line.separator") 
		   + "Wei" + System.getProperty("line.separator")
		   + "555 St" + System.getProperty("line.separator")
		   + "Hidden City" + System.getProperty("line.separator")
		   + "London" + System.getProperty("line.separator")
		   + "22222" + System.getProperty("line.separator")
		   + "555 592 5260" + System.getProperty("line.separator");
		String simulatedUserInput3 = "Kaleshwar" + System.getProperty("line.separator") 
		   + "Singh" + System.getProperty("line.separator")
		   + "Avenue St" + System.getProperty("line.separator")
		   + "Leaf City" + System.getProperty("line.separator")
		   + "Maryland" + System.getProperty("line.separator")
		   + "10001" + System.getProperty("line.separator")
		   + "826 947 1523" + System.getProperty("line.separator");
		String simulatedUserInput4 = "Aaron" + System.getProperty("line.separator") 
		   + "Wei" + System.getProperty("line.separator")
		   + "777 St" + System.getProperty("line.separator")
		   + "Water City" + System.getProperty("line.separator")
		   + "London" + System.getProperty("line.separator")
		   + "59875" + System.getProperty("line.separator")
		   + "123 456 7890" + System.getProperty("line.separator");
		// adding the Entries, with the simulated inputs, to the address book
		ab.addEntry(simulatedUserInput1);
		ab.addEntry(simulatedUserInput2);
		ab.addEntry(simulatedUserInput3);
		ab.addEntry(simulatedUserInput4);
		
		Name name = new Name("Zaykha", "Kyaw San");
		Address address = new Address("601 Fairmont St Nw", "Washington", "D.C", "11111");
		String phone = "202 749 2878";
		Entry entry1 = new Entry(name, address, phone);
		name = new Name("Jerry", "Wei");
		address = new Address("555 St", "Hidden City", "London", "22222");
		phone = "555 592 5260";
		Entry entry2 = new Entry(name, address, phone);
		name = new Name("Kaleshwar", "Singh");
		address = new Address("Avenue St", "Leaf City", "Maryland", "10001");
		phone = "826 947 1523";
		Entry entry3 = new Entry(name, address, phone);
		name = new Name("Aaron", "Wei");
		address = new Address("777 St", "Water City", "London", "59875");
		phone = "123 456 7890";
		Entry entry4 = new Entry(name, address, phone);

		// when
		ab.sortEntries(2);
		
		// then
		Assert.assertEquals(entry3, ab.getAddressBook().get(0));
		Assert.assertEquals(entry1, ab.getAddressBook().get(1));
		Assert.assertEquals(entry2, ab.getAddressBook().get(2));
		Assert.assertEquals(entry4, ab.getAddressBook().get(3));		
	}
}