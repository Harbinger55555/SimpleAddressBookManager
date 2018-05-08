package com.simpleaddressbook;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * This class consists of methods to create, or make changes to, an AddressBook object to be used in the AddressBookManager class.
 * It also includes a method to output all the entries in the AddressBook object.
 *
 * @author Zaykha Kyaw San
 * @version 1.0
 * @since 2018-05-06
 */
public class AddressBook implements Serializable{
	private ArrayList<Entry> addressBook;

	/**
	 * The default constructor initializes a new address book which is an arraylist of entries.
	 */
	public AddressBook(){
		addressBook = new ArrayList<Entry>();
	}

	// getters
	/**
	 * Returns the arraylist of entries, which is the address book.
	 * @return the arraylist of entries, which is the address book.
	 */	
	public ArrayList<Entry> getAddressBook(){
		return this.addressBook;
	}

	/**
	 * Adds into the address book, the newly created Entry object returned from createEntry() method.
	 * @param simulatedUserInput is the pre-entered user inputs, for testing purposes, for the prompts that createEntry method will be making.
	 */
	public void addEntry(String simulatedUserInput){
		addressBook.add(this.createEntry(simulatedUserInput));
	}
	
	// Simply creates a new entry with the user inputs; not added to AddressBook yet
	// Prompts user to input first name, last name, street address, city, state, zip code, and phone number
	// and creates an Entry object with the values.
	// Parameter simulatedUserInput is the pre-entered user inputs for the prompts for testing purposes.
	private Entry createEntry(String simulatedUserInput){
		Scanner scanner = null;
		
		// if there is no default simulatedUserInput, scanner will take in user inputs instead
		if (simulatedUserInput.equals("")){
			scanner = new Scanner(System.in);
		}
		else{
			ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
			System.setIn(in);
			scanner = new Scanner(in);
		}
		
		// take inputs for first name and last name
		System.out.println("\nPlease enter the first name: ");
		String fname = scanner.nextLine();
		System.out.println("\nPlease enter the last name: ");
		String lname = scanner.nextLine();
		Name name = new Name(fname, lname);
		
		// take inputs for street address, city, state, and zip code
		System.out.println("\nPlease enter the street address: ");
		String staddress = scanner.nextLine();
		System.out.println("\nPlease enter the city: ");
		String city = scanner.nextLine();
		System.out.println("\nPlease enter the state: ");
		String state = scanner.nextLine();
		System.out.println("\nPlease enter the zip code: ");
		String zip = scanner.nextLine();
		Address address = new Address(staddress, city, state, zip);
		
		// take input for phone number
		System.out.println("\nPlease enter the phone number: ");
		String phone = scanner.nextLine();
		
		// make a new Entry using the inputs
		Entry entry = new Entry(name, address, phone);
		
		return entry;
	}

	/**
	 * Prompts user to input first name and last name of an entry to be deleted.<br>
	 * Deletes an existing entry if the first name and last name inputs matches the entry's values.
	 * @param simulatedUserInput is the pre-entered System inputs, for testing purposes.
	 */	
	public void deleteEntry(String simulatedUserInput){
		Scanner scanner = null;
		
		// if there is no default simulatedUserInput, scanner will take in user inputs instead
		if (simulatedUserInput.equals("")){
			scanner = new Scanner(System.in);
		}
		else{
			ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
			System.setIn(in);
			scanner = new Scanner(in);
		}
		
		// take inputs for first name and last name to search for the matching entry in the AddressBook
		System.out.println("\nPlease enter the first name of the person: ");
		String fname = scanner.nextLine();
		System.out.println("\nPlease enter the last name of the person: ");
		String lname = scanner.nextLine();
		Name name = new Name(fname, lname);

		int index = searchEntry(name);
		if (index != -1){
			addressBook.remove(index);
			System.out.println("\nEntry successfully deleted!");
		}
		else{
			System.out.println("\nEntry does not exist!");
		}
	}

	/**
	 * Prompts user to input first name and last name of an entry to edit.<br>
	 * If the entry exists, provides the user with a menu to select what field 
	 * of the Entry object to edit, and allows the user to make changes to the corresponding field.<br>
	 * Exits the entry edit mode if input is not an integer or is not among the available choices.
	 * @param simulatedUserInput is the pre-entered System inputs, for testing purposes.
	 * @throws InputMismatchException if simulatedUserInput is not an integer string.
	 */
	// searches the person entry to allow edits
	public void editEntries(String simulatedUserInput) throws InputMismatchException{
		Scanner scanner = null;
		
		// if there is no default simulatedUserInput, scanner will take in user inputs instead
		if (simulatedUserInput.equals("")){
			scanner = new Scanner(System.in);
		}
		else{
			ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
			System.setIn(in);
			scanner = new Scanner(in);
		}
		
		// take inputs for first name and last name to search for the matching entry in the AddressBook
		System.out.println("\nPlease enter the first name of the person: ");
		String fname = scanner.nextLine();
		System.out.println("\nPlease enter the last name of the person: ");
		String lname = scanner.nextLine();
		Name name = new Name(fname, lname);

		int index = searchEntry(name);
		if (index != -1){
			try {
				System.out.println("\n------------------------------------------------------------");
				System.out.println("		     Entry Edit Menu");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 => Street Address");
				System.out.println("2 => City");
				System.out.println("3 => State");
				System.out.println("4 => Zip code");
				System.out.println("5 => Phone Number");
				System.out.println("Please enter the corresponding number of the field you want to edit: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // to eliminate the \n
				switch (choice){
					case 1:
						System.out.println("\nPlease enter new Street Address: ");
						this.addressBook.get(index).getAddress().setStreetAddress(scanner.nextLine());
						break;
					case 2:
						System.out.println("\nPlease enter new City: ");
						this.addressBook.get(index).getAddress().setCity(scanner.nextLine());
						break;
					case 3:
						System.out.println("\nPlease enter new State: ");
						this.addressBook.get(index).getAddress().setState(scanner.nextLine());
						break;
					case 4:
						System.out.println("\nPlease enter new Zip Code: ");
						this.addressBook.get(index).getAddress().setZip(scanner.nextLine());
						break;
					case 5:
						System.out.println("\nPlease enter new Phone Number: ");
						this.addressBook.get(index).setPhone(scanner.nextLine());
						break;
					default:
						System.out.println("\nInvalid Choice! Exiting Entry Edit mode...");
						break;
				}
			}
			catch (InputMismatchException e){
				if (simulatedUserInput.equals("")){
					System.out.println("\nInvalid choice! Exiting Entry Edit mode...");
				}
				else{
					throw new InputMismatchException();
				}
			}
		}
		else {
			System.out.println("\nEntry does not exist!");
		}
	}

	private int searchEntry(Name name){
		for (int index = 0; index < addressBook.size(); ++index){
			if (addressBook.get(index).getName().equals(name)){
				return index;
			}
		}
		return -1;
	}

	/**
	 * If the parameter sortType is 1, sorts the entries in the address book by last names and breaking ties with first names.<br>
	 * Else, sorts the entries by zip codes, breaking ties with the names.
	 * @param sortType is the integer value used to determine the sort type.
	 */	
	public void sortEntries(int sortType){
		if (sortType == 1){
			// sort by last name; break ties with first name
			sortByName();
		}
		else {
			// sort with zip code; break ties with name
			sortZipCode();
		}
	}
	
	private void sortByName(){
		// sort by last name; break ties with first name
		Collections.sort(this.addressBook, new Comparator<Entry>() {
			public int compare(Entry left, Entry right){
				int res = left.getName().compareTo(right.getName());
				return res;
			}
		});
		System.out.println("\nEntries sorted by name!");
	}
	
	private void sortZipCode(){
		// sort with zip code; break ties with name
		// no special code needed since entries are compared by zip codes and break ties with name by default
		Collections.sort(this.addressBook);
		System.out.println("\nEntries sorted by zip codes!");
	}

	/**
	 * Outputs the entries in the address book or
	 * outputs that the address book is empty if there are no existing entries.
	 */		
	public void printEntries(){
		System.out.println("\n------------------------------------------------------------");
		System.out.println("			 Entries list");
		System.out.println("------------------------------------------------------------");
		if (addressBook.size() != 0){
			for (Entry e : addressBook){
				System.out.println(e);
				System.out.println();
			}
		}
		else {
			System.out.println("\nThe address book is empty!");
		}
	}
	
	/**
	 * Overrides the default equals() method to check if it is being compared with
	 * itself, an object of another class, or another AddressBook object.
	 * @param another is an object of any type being compared with.
	 * @return true if it is compared with itself.<br>
	 * 		   false if it is compared with an object of another class.<br>
	 *		   boolean result of the comparison made between the two AddressBook objects' arraylists of entries.
	 */
	@Override
    public boolean equals(Object another) {
 
        // Return True if object is compared with itself  
        if (another == this) {
            return true;
        }
 
        // Check if another is an instance of AddressBook or not; "null instanceof [type]" also returns false
        if (!(another instanceof AddressBook)) {
            return false;
        }
         
        // typecast another to AddressBook to compare 
        AddressBook o = (AddressBook) another;
        
		// comparing the arraylist of entries of the two AddressBook Objects
		ArrayList<Entry> ab1 = this.getAddressBook();
		ArrayList<Entry> ab2 = o.getAddressBook();
		// checking for null
        if(ab1 == null && ab2 == null)
            return true;
        if((ab1 == null && ab2 != null) || (ab1 != null && ab2 == null))
            return false;
        if(ab1.size() != ab2.size())
            return false;
        for(Object item: ab1)
        {
            if(!ab2.contains(item))
                return false;
        }
        return true;
    }
}