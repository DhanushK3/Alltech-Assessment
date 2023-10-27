package pkg_prob2;

import java.util.ArrayList;

public class MyThread1 extends Thread {
	
	private ArrayList<Iteam> iteamList;

    public MyThread1(ArrayList<Iteam> iteamList) {
        this.iteamList = iteamList;
    }

   

	@Override
    public synchronized void run() {
        for (int i = 1000; i <= 1005; i++) {
            Iteam item = new Iteam(i, "Item " + i);
                iteamList.add(item);
                
                System.out.println("Added Item List " + i );
            }
            try {
                Thread.sleep(1000); 
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
}

