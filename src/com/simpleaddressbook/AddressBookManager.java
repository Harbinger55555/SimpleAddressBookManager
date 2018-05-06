package com.simpleaddressbook;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.util.InputMismatchException;

public class AddressBookManager{
	private AddressBook currentAddressBook;
	private String currentFileName;
	
	/**
	 * The default constructor which initializes the member variables to zero values
	 */		
	public AddressBookManager(){
		currentAddressBook = null;
		currentFileName = "";
	}

	/**
	 * Provides the user with a File menu and performs the corresponding function of the selection made <br>
	 * Choosing to edit the currently opened address book will provide the user with another
	 * menu to select what to do with the entries in the address book <br>
	 * Throws IOException if address book file does not exist <br>
	 * Throws ClassNotFoundException if the Java Virtual Machine tries to load a particular
	 *		  class and the specified class cannot be found in the classpath
	 * @exception InputMismatchException if user inputs for the File Menu or the Address Book 
	 *			  Edit Menu are not integers
	 */
	public void fileMenu(){
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------");
			System.out.println("			 File Menu");
			System.out.println("------------------------------------------------------------");
			System.out.println("1 => Create a new address book");
			System.out.println("2 => Open an address book");
			System.out.println("3 => Edit current address book");
			System.out.println("4 => Close current address book");
			System.out.println("5 => Save");
			System.out.println("6 => Save As");
			System.out.println("7 => Quit Program");
			System.out.println("Please enter the corresponding number of your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // to eliminate the \n
			switch (choice){
				case 1:
					newAddressBook();
					break;
				case 2:
					openAddressBook();
					break;
				case 3:
					editAddressBook();
					break;
				case 4:
					closeAddressBook(0);
					break;
				case 5:
					saveAddressBook(0);
					break;
				case 6:
					saveAddressBookAs(0);
					break;
				case 7:
					quitProgram();
					break;
				default:
					System.out.println("\nInvalid choice! Please enter a valid number...");
					this.fileMenu();
					break;
			}
		}
		catch (InputMismatchException e){
			System.out.println("\nInvalid choice! Please enter a valid number...");
			this.fileMenu();
		}
	}
	
	// create a new address book
	private void newAddressBook(){
		if (currentAddressBook != null){
			closeAddressBook(1);
		}
		currentAddressBook = new AddressBook();
		currentFileName = "";
		System.out.println("\nNew address book is now currently opened!");
		fileMenu();
	}
	
	// edit the currently opened address book
	private void editAddressBook(){
		if (currentAddressBook != null){
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("\n------------------------------------------------------------");
				System.out.println("		     Address Book Edit Menu");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 => Add an entry");
				System.out.println("2 => Delete an entry");
				System.out.println("3 => Edit an entry");
				System.out.println("4 => Sort entries by name");
				System.out.println("5 => Sort entries by zip code");
				System.out.println("6 => Print all entries");
				System.out.println("Please enter the corresponding number of your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // to eliminate the \n
				switch (choice){
					case 1:
						currentAddressBook.addEntry();
						break;
					case 2:
						currentAddressBook.deleteEntry();
						break;
					case 3:
						currentAddressBook.editEntries();
						break;
					case 4:
						currentAddressBook.sortEntries(1);
						break;
					case 5:
						currentAddressBook.sortEntries(2);
						break;
					case 6:
						currentAddressBook.printEntries();
						break;
					default:
						System.out.println("\nInvalid choice! Exiting Address Book Edit mode...");
						break;
				}
			}
			catch (InputMismatchException e){
				System.out.println("\nInvalid choice! Exiting Address Book Edit mode...");
			}
		}
		else {
			System.out.println("\nNo address book is currently opened!");
		}
		fileMenu();
	}
	
	// save currently opened address book
	private void saveAddressBook(int call_from_another){
		if (currentAddressBook != null){
			if (currentFileName.equals("")){
				saveAddressBookAs(1);
			}
			else {
				try{
					ObjectOutputStream oStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(currentFileName + ".zay")));
					oStream.writeObject(currentAddressBook);
				}
				catch (IOException e){
					e.printStackTrace();
				}
				System.out.println("\nUnsaved changes are saved!");
			}
		}
		else {
			System.out.println("\nNo address book is currently opened!");
		}
		// if Save is explicitly called from file menu, open file menu again
		// else allow the Save function to end and the other function which called it to resume
		if (call_from_another == 0){
			fileMenu();
		}
	}
	
	// saveAs
	private void saveAddressBookAs(int call_from_another){
		if (currentAddressBook != null){
			try{
				Scanner scanner = new Scanner(System.in);
				System.out.println("\nPlease input the file name to be saved as: ");
				String filename = scanner.nextLine();
				ObjectOutputStream oStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename + ".zay")));
				currentFileName = filename;
				oStream.writeObject(currentAddressBook);
				System.out.println("\nCurrent address book is saved as file (" + filename + ")");
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		else {
			System.out.println("\nNo address book is currently opened!");
		}
		// if Save As is explicitly called from file menu, open file menu again
		// else allow the Save As function to end and the other function which called it to resume
		if (call_from_another == 0){
			fileMenu();
		}
	}
	
	// open an address book
	private void openAddressBook(){
		if (currentAddressBook != null){
			closeAddressBook(1);
		}
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nPlease input the name of the address book file to be opened: ");
			String filename = scanner.nextLine();
			ObjectInputStream oStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename + ".zay")));
			currentFileName = filename;
			currentAddressBook = (AddressBook) oStream.readObject();
			System.out.println("\nAddress book (" + filename + ") is now currently opened!");
		}
		catch (IOException e){
			System.out.println("\nFile does not exist!");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		fileMenu();
	}
	
	// close currently opened address book
	private void closeAddressBook(int call_from_another){
		if (currentAddressBook != null){
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nDo you want to save any unsaved changes? (Y/N)");
			String choice = scanner.nextLine();
			switch (choice){
				case "Y":
				case "y":
					saveAddressBook(1);
					break;
				default:
					System.out.println("\nUnsaved changes not saved!");
					break;
			}
			// reinitializing to default as current address book is closed
			System.out.println("\nCurrent address book (" + currentFileName + ") closed!");
			currentAddressBook = null;
			currentFileName = "";
		}
		else {
			System.out.println("\nNo address book is currently opened!");
		}
		// if Close is explicitly called from file menu, open file menu again
		// else allow the Close function to end and the other function which called it to resume
		if (call_from_another == 0){
			fileMenu();
		}
	}
	
	// exit the program
	private void quitProgram(){
		if (currentAddressBook != null){
			closeAddressBook(1);
		}
		System.exit(0);
	}
}
