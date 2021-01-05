package com.manager.main;
import com.manager.functions.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("Contact.txt");
		Scanner scan = new Scanner(System.in);
		String name,email;
		long contact;
		int choice;
		try 
		{
			if(!file.exists())
				file.createNewFile();
			System.out.println("Choose a task to perform:");
			
			while(true)
			{

				System.out.println("\n1.Create new contact\t2.View\t3.Search\t4.Export\t5.Exit");
				choice = scan.nextInt();
				switch(choice) {
				
				case 1:
					System.out.println("Enter the contact First Name:");
					name = scan.next();
					System.out.println("Enter the contact Second Name:");
					name += " " +scan.next();
					System.out.println("Enter the contact Email:");
					email = scan.next();
					System.out.println("Enter the contact Number with country code(91/1) and no spaces:");
					contact = scan.nextLong();
					Functions.write(name,email,contact,file);
					break;
					
					
				case 2:
					Functions.view(file);
					break; 
					
				case 3 : 
					String key = "test";
					System.out.println("Enter the contact name/email/number to search");
					key = scan.next();
					Functions.search(key,file);
					break;
					
				case  4:
					Functions.export(file);
					break;
					
				case 5 : 
					scan.close();
					System.out.println("The program has been terminated");
					System.exit(0);break;
//				case 6:
//					Functions.sort(file);
//					break;
				default: System.out.println("Invalid Option. Please Try again.");
				}
			}
		}
		
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Please provide a valid number\n\n\n");  
			main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unreachable File");
		}
		
		
	}

}
