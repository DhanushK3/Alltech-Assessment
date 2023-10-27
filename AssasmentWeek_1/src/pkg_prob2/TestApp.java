package pkg_prob2;

import java.util.ArrayList;

public class TestApp {
	
	 public static void main(String[] args) {
	        ArrayList<Iteam> iteamList = new ArrayList<>();

	        MyThread1 myThread1 = new MyThread1(iteamList);
	        MyThread2 myThread2 = new MyThread2(iteamList);
	        
	       
			Iteam iteam = new Iteam(01, "Dhanush");
			iteam.displayItemDetails();
	        myThread1.start();
	        myThread2.start();
	        
	    }
}
