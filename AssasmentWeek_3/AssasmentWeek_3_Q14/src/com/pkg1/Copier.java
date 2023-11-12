package com.pkg1;

import java.util.Vector;

public class Copier implements Runnable {
	
    private final Vector<String> paperQueue;

    public Copier(Vector<String> paperQueue) {
    	
        this.paperQueue = paperQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (paperQueue) {
                while (paperQueue.isEmpty()) {
                  
                 try {
					paperQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   
                String paper = paperQueue.remove(0);
                
                System.out.println("Copier: I have printed " + paper);
                
                paperQueue.notify(); 

                try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                }
            }	
        }
    }
}