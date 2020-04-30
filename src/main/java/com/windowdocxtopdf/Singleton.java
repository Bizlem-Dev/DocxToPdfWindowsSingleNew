package com.windowdocxtopdf;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

public class Singleton {

    private static Singleton single_instance = null;
    
    public IConverter converter=null;
    static File base;
    
    private Singleton() 
    { 
    	 base = new File("D:\\apache-tomcat-9.0.12\\webapps\\ROOT\\DocumentGeneration\\tempPdfDir");
		 
        if (!base.exists()) {
            if (base.mkdir()) {
               // System.out.println("Directory is created!");
            } else {
               // System.out.println("Failed to create directory!");
            }
        }
    	
    	 /*base = new File("D:\\doctiger\\aspose_lib\\docx_files\\downloadedFiles\\tempPdfDir");  // for local testing purpose.
		 
        if (!base.exists()) {
            if (base.mkdir()) {
               // System.out.println("Directory is created!");
            } else {
               // System.out.println("Failed to create directory!");
            }
        }*/
//    	base=this.base;
    	
    	  converter = LocalConverter.builder().baseFolder(base).workerPool(20, 25, 1, TimeUnit.SECONDS).processTimeout(5, TimeUnit.SECONDS).build();
    }
    
    public static Singleton getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 

}
