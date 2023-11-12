package com.pkg2;

import com.pkg1.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
    	
        Vector<String> paperQueue = new Vector<>();
        
        int maxQueueDepth = 5; 

        Thread feederThread = new Thread(new Feeder(paperQueue, maxQueueDepth));
        Thread copierThread = new Thread(new Copier(paperQueue));

        feederThread.start();
        copierThread.start();

        
            try {
            	
				feederThread.join();
				copierThread.join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        

        System.out.println("Printing process completed.");
    }
}