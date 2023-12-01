package com.week6;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Number of test cases : ");
		int n = scanner.nextInt();
		scanner.nextLine(); //Consume line
		
		int[][] queries = new int[n][2];//Store the queries
		
		
		
		// Input the queries
        for (int i = 0; i < n; i++) {
        	System.out.print("Enter query " + (i + 1) + " (rows, colums)" +": ");
            for (int j = 0; j < 2; j++) {
                queries[i][j] = scanner.nextInt();
            }
        }
        
        CableBoxDivider cableBoxDivider = new CableBoxDivider();
        //  results
        long[] results = cableBoxDivider.numberOfWays(queries);
        for (long result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
		
		
				
//			for(int i = 0; i < n; i++) {
//				System.out.print("Enter Number of rows : ");
//				int rows = scanner.nextInt();
//				System.out.print("Enter Number of columns : ");
//				int columns = scanner.nextInt();
//				scanner.nextLine(); //consume line
//					
//				CableBoxDivider cableBox = new CableBoxDivider(rows, columns);
//				
//				// storing results of test cases
//				results[i] = cableBox.noOfWays();
//				
//			}
//			scanner.close();
			
			
}
