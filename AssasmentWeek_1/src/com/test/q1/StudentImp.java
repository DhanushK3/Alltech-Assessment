package com.test.q1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.student.q1.*;

public class StudentImp{

	public static void main(String[] args) {
		Student student = new Student();
		
		 student.readStudInfo();
	     student.calcTotal();    
	     ObjectOutputStream oos;
	     ObjectInputStream ois;
	     
	     
		try {
			//store an object of Student class in the file StudentInfo.txt	
			oos = new ObjectOutputStream(new FileOutputStream("L:\\Alltech Java\\StudentInfo.txt"));
			oos.writeObject(student);
			
			
			//read file and display
			ois= new ObjectInputStream(new FileInputStream("L:\\Alltech Java\\StudentInfo.txt"));
			 
			Student readStudFile = (Student) ois.readObject();
			
			readStudFile.printStudInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		            
	 
	        
			
		
   
		
	}
}
