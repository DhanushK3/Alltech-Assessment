package com.student.q1;

import java.util.Scanner;
import java.io.Serializable; 

public class Student implements StudentInt, Serializable {
	
	private int rollNo;
	private String name;
	private	int subject1;
	private	int subject2;
	private	int subject3;
	private	int totalMarks;


	Scanner sc = new Scanner(System.in);
	
	@Override
	public void readStudInfo() {
		System.out.println("Enter the Student details: ");
		
		System.out.println("================================");
		
		System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();

        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.print("Enter Subject 1 marks: ");
        subject1 = sc.nextInt();

        System.out.print("Enter Subject 2 marks: ");
        subject2 = sc.nextInt();

        System.out.print("Enter Subject 3 marks: ");
        subject3 = sc.nextInt();
		
	}

	@Override
	public void calcTotal() {
		
		totalMarks = subject1 + subject2 + subject3;
		
	}

	@Override
	public void printStudInfo() {
		System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Subject 1 Marks: " + subject1);
        System.out.println("Subject 2 Marks: " + subject2);
        System.out.println("Subject 3 Marks: " + subject3);
        System.out.println("Total Marks: " + totalMarks);
		
	}

}
