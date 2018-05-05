package com.thepackage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;

public class AddressBook implements Serializable{
	private int changeState;
	private ArrayList<Entry> addressBook;
	
	public AddressBook(){
		addressBook = new ArrayList<Entry>();
	}

	public ArrayList<Entry> getAddressBook(){
		return this.addressBook;
	}
	
	public void addEntry(){
		addressBook.add(this.createEntry());
	}

	// Simply creates a new entry with the user inputs; not added to AddressBook yet 
	public Entry createEntry(){
		Scanner scanner = new Scanner(System.in);
		
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
	
	public void deleteEntry(){
		Scanner scanner = new Scanner(System.in);
		
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
	
	// searches the person entry to allow edits
	public void editEntries(){
		Scanner scanner = new Scanner(System.in);
		
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
				System.out.println("\nInvalid choice! Exiting Entry Edit mode...");
			}
		}
		else {
			System.out.println("\nEntry does not exist!");
		}
	}
	
	public int searchEntry(Name name){
		for (int index = 0; index < addressBook.size(); ++index){
			if (addressBook.get(index).getName().equals(name)){
				return index;
			}
		}
		return -1;
	}
	
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
}