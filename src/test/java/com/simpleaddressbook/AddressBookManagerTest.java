package com.simpleaddressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookManagerTest{
	@Test
	public void createNewAddressBook(){
		// given
		AddressBookManager abm = new AddressBookManager();
		
		// when
		abm.newAddressBook(1);
		
		// then
		Assert.assertNotNull(abm.getCurrentAddressBook());
	}

	// This tests both the save and saveAs methods, since calling save for a 
	// new and unnamed address book will call saveAs as well
	// This will also test the open method since only way to know if the address book actually
	// saved is to open the saved file and test it
	@Test
	public void saveAddressBook(){
		// given
		AddressBookManager abm = new AddressBookManager();
		abm.newAddressBook(1);
		String simulatedFileNameInput = "savedABFile" + System.getProperty("line.separator");
		AddressBook ab = new AddressBook();
		
		// when
		abm.saveAddressBook(1, simulatedFileNameInput);
		
		// given
		// this is to reinitialize the abm member variables to default values
		abm.setCurrentAddressBook(null);
		abm.setCurrentFileName("");
		
		// when
		abm.openAddressBook(1, simulatedFileNameInput);
		
		// then
		Assert.assertEquals(ab, abm.getCurrentAddressBook());
		Assert.assertEquals("savedABFile", abm.getCurrentFileName());
	}
}