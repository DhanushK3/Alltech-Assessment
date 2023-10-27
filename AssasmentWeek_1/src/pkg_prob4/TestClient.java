package pkg_prob4;

import java.util.Scanner;

public class TestClient extends Thread{
	String choice;
	
	
	
	
		
	
	public static void main(String[] args) {
		
		CLang cLang = new CLang();
        Javalang javaLang = new Javalang();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your fav language (C/Java): ");
        String choice = scanner.nextLine().toLowerCase();
        
        // creat threads
        Thread javaThread = new Thread();
        if (choice.equals("c")) {
            cLang.showMessage();
        }
        
        Thread cThread = new Thread();
        if (choice.equals("java")) {
            javaLang.showMessage();
        }
        
        
        //set priorities
        if (choice.equals("c")) {
            cThread.setPriority(Thread.MAX_PRIORITY);
        }else if (choice.equals("java")) {
            javaThread.setPriority(Thread.MAX_PRIORITY);
        }
        
        //strat two threads
        cThread.start();
        javaThread.start();
	}

	
}
