package pkg_prob2;

import java.util.ArrayList;

public class MyThread2 extends Thread {
	private ArrayList<Iteam> iteamList;

    public MyThread2(ArrayList<Iteam> iteamList) {
        this.iteamList = iteamList;
    }


	@Override
	public synchronized  void run() {
       
            for (Iteam item : iteamList) {
                item.displayItemDetails();
            }
        
    }
}



