package com.manager.functions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Functions {

	
	public static void view(File file) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(file.length());
		char[] target = new char[(int) (file.length())];	//Size exceeds int limit
		FileReader fr = new FileReader(file);
		fr.read(target);									//Backtrack it
		
		if(file.length()==0)
			System.out.println("There is no contact to display");
		else
			System.out.println(new String(target));
		fr.close();
		
		}

	public static void write(String name, String email, long contact,File file) throws IOException {
		// TODO Auto-generated method stub
		String newContact = format(contact);
		String newLine = name+"-"+email+"-"+newContact+";" ;
		FileWriter fw = new FileWriter(file,true);
		fw.append(newLine + "\n");
		System.out.println("The contact has been added successfully");
		fw.close();
//		sort(file);
	}

	

	

	public static void search(String key, File file) throws IOException {
		// TODO Auto-generated method stub
		char[] target = new char[(int) (file.length())];
		FileReader fr = new FileReader(file);
		fr.read(target);
		String str = new String(target);
		String fileData[] = str.split(";");
		for(String s : fileData)
			if (s.toLowerCase().contains(key.toLowerCase())) 
				System.out.print(s);
		fr.close();
				

	}

	public static void export(File file) throws IOException {
		// TODO Auto-generated method stub
		if(file.length()==0) {
			System.out.println("Empty Phone book. No contacts to export");
		}
		else {
			String exportFilename = "Contacts";
			
			File exportFile = new File(exportFilename+".txt");
			for(int i = 1 ; i<100; i++)
				{
					if(exportFile.exists()) {
					
						exportFile = new File(exportFilename+i+".txt");				//
						
					}
					System.out.println(i);
				}
			
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(exportFile);
			char[] target = new char[(int) (file.length())];
			fr.read(target);
			String str = new String(target);
			fw.write(str);
			System.out.println("The Contacts has been exported to your local Directory  " + exportFile.getAbsolutePath());
			fw.close();
			fr.close();
		}

	}
	
	private static String format(Long contact) {
		String formattedContact = new String();
		String  unforamattedContact= contact.toString();
		if(unforamattedContact.charAt(0) == '1')
			formattedContact = String.valueOf(unforamattedContact).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{4})", "+$1 ($2) $3-$4");
		else if(unforamattedContact.charAt(0)== '9')
			formattedContact = String.valueOf(unforamattedContact).replaceFirst("(\\d{2})(\\d{5})(\\d{5})", "+$1 $2 $3");
		
		return formattedContact;
	}
	
	
	}