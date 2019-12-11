package com.queueManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    String parentDirectoryPath="/home/kundan.k/Downloads/fileTransferMonitorSample/";
   public  List<FileMapper> getFileListAtThisTime(){
	    File parentDirectory=new File(parentDirectoryPath+"input/");
    	List<FileMapper> fileMapList=new ArrayList<>();
    	for(File f:parentDirectory.listFiles()) {
    		FileMapper fm=new FileMapper();
    		fm.setFile(f);
    		fm.setLastFile(false);
    		fileMapList.add(fm);
    	}
    	if(fileMapList.size()>0) {
    		fileMapList.get(fileMapList.size()-1).setLastFile(true);
    	}
    	
    	return fileMapList;
    }

   
  
   
   
   public void moveFile(File inputfile) {	
	   String outputFilePath=parentDirectoryPath+"output/" + inputfile.getName();
   	InputStream inStream = null;
	OutputStream outStream = null;
		
   	try{
   		
   	    File bfile =new File(outputFilePath);
   		
   	    inStream = new FileInputStream(inputfile);
   	    outStream = new FileOutputStream(bfile);
       	
   	    byte[] buffer = new byte[1024];
   		
   	    int length;
   	    //copy the file content in bytes 
   	    while ((length = inStream.read(buffer)) > 0){
   	  
   	    	outStream.write(buffer, 0, length);
   	 
   	    }
   	 
   	    inStream.close();
   	    outStream.close();
   	    
   	    //delete the original file
   	    inputfile.delete();
   	    
   	    System.out.println("File is copied successful!");
   	    
   	}catch(IOException e){
   	    e.printStackTrace();
   	}
   }
}