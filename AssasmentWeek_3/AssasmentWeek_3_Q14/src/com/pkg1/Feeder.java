package com.pkg1;

import java.util.Vector;

public class Feeder implements Runnable {
	
    private final Vector<String> paperQueue;
    
    private final int maxQueueDepth;

    public Feeder(Vector<String> paperQueue, int maxQueueDepth) {
    	
        this.paperQueue = paperQueue;
        this.maxQueueDepth = maxQueueDepth;
    }

    @Override
    
    public void run() {
        for (int i = 1; i <= maxQueueDepth; i++) {
            String paper = "Paper #" + i;
            
            synchronized (paperQueue) {
            	
                System.out.println("Feeder: I have placed " + paper);
                
                paperQueue.add(paper);
                paperQueue.notify(); 
            }

                try {
                	
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
    }
}