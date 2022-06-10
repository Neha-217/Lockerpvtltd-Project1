package com.lockerpvtltd;


	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	public class AllMethods {
		static final String folderpath = "C:\\Files_SimpliLearn";
		
		/*This Method will return file names from the folder @param folderpath
		 @param List <String>*/
		
		public static List<String> getfilename() {
			
			File path = new File(folderpath);	//Creating a File object
			
			File[] filelist = path.listFiles();	//Getting all the files into File Array
			
			List<String> filename = new ArrayList<>();	//Declaring a List to store file names
				
			System.out.println("List of Files in specified Directory: ");
			
			for(File file : filelist) {
			
				System.out.println(file.getName());
			}
			
			return filename;	//return the list
		}
		
		/*This Method Deletes the file from the folder @param folderpath @param filename @return boolean*/
		
		public static boolean Deletefile(String folderpath, String filename) {
			
			File f1 = new File(folderpath, filename);
			try
			{
			
				if(f1.delete()) 
			{
				System.out.println("File Deleted!!");
			}
			else {
				System.out.println("Some Error Occured..File not found or access issue!!");
			}
			return true;
			}
			
			catch(Exception e ){
				
				return false;
			}
		}
		
	/*This Method will Search file into the folder @param folderpath @param filename @return boolean */
		
		public static boolean Searchfile(String folderpath, String filename) {
			
			File f1 = new File(folderpath, filename);
			
			if(f1.exists()) 
			{
				System.out.println("\nFile found: " +f1.getAbsolutePath());
			}
			else 
			{
				System.out.println("File not Found!!");
			}
			return (f1.exists());
		}
		
		
		/*This Method will Add/Create a new file or Append data to the existing file @param folderpath 
		 @param filename @param content @return boolean  */
		
		public static boolean CreateFile(String folderpath, String filename, List<String> content) throws IOException  {
			
			File f1 = new File(folderpath, filename);
			if(f1.createNewFile())
			{
				System.out.println("File created Successfully!!");
			}
			else {
				System.out.println("File already exist!!");
			}
		
			FileWriter fw = new FileWriter(f1, true);
			
			for(String data : content)
			{
				fw.write(data+"\n");
			}
				
			fw.close();
			return true;
			}

}
