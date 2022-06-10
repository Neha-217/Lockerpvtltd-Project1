package com.lockerpvtltd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class LockedMeProject {
	
		public static void companylogo()
	{	
		System.out.println("**************************************************************************");
		System.out.println("\t\tCompany Lockers Pvt. Ltd.");
		System.out.println("\t\t\tLockedMe.com");
		System.out.println();
		System.out.println("Developed By: Neha");
		System.out.println("**************************************************************************");
	}

	public static void displayMenu()
	{
		System.out.println("Please select from the following Options: ");
		System.out.println();
		System.out.println("1. Get All File Names");
		System.out.println("2. Add/Create a new File");
		System.out.println("3. Delete a File");
		System.out.println("4. Search a File");
		System.out.println("5. Exit");
		System.out.println("-----------------------------------------");
	}
	
	static final String folderpath = "C:\\Files_SimpliLearn";

		public static void main(String[] args) throws IOException {
			
			companylogo();
			
			displayMenu();
			
			Scanner sc = new Scanner(System.in);
			int ch;
			String filename=null;
		
			System.out.println("Please Enter Your Choice: ");
			ch = sc.nextInt();
			
			switch (ch)
			{
			case 1:
				getAllfiles();
				break;
			case 2:
				AddFile();
				break;
			case 3:
				Deletefile();
				break;
			case 4:
				Searchfile();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!!");
				break;
			}
		}
		
		public static void getAllfiles() {
			List<String> filename = AllMethods.getfilename();
			for(String f : filename)
			{
				System.out.println(f);
			}
			
		}
		
		public static void Deletefile() {
			Scanner sc = new Scanner(System.in);
			String filename;
			System.out.println("Please Enter the file to be Deleted: ");
			filename = sc.nextLine();
		
			AllMethods.Deletefile(folderpath, filename);
		}
		
		public static void Searchfile() {
			String filename;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter the file name: ");
			filename = sc.nextLine();
			sc.close();
			
			try {
				File f1 = new File(folderpath, filename);
				FileInputStream reader = new FileInputStream(f1);
				int x = 0;
				while((x = reader.read())!= -1) 
				{
					System.out.print((char)x);
				}
				reader.close();
				}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			AllMethods.Searchfile(folderpath, filename);
			/*if(AllMethods.Searchfile(folderpath, filename)) {
				System.out.println("File is present in the folder!");
			}
			else
			{
				System.out.println("File not found!!");
			}*/
		}
		
			public static void AddFile() throws IOException {
				Scanner sc = new Scanner(System.in);
				String filename;
				
				List<String> content = new ArrayList<>();
				
				System.out.println("Enter the name of the File: ");
				filename = sc.nextLine();
				
				System.out.println("Please Enter the data: ");
				content.add(sc.nextLine());
				
				sc.close();
				
				if(AllMethods.CreateFile(folderpath, filename, content));
				{
						System.out.println("Data is Successfully written");
				}
				
			}

}
