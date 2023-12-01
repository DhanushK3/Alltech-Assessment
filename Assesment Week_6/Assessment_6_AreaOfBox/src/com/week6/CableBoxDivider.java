package com.week6;

public class CableBoxDivider {
//	private int rows;
//	private int colomns;
//	
//	
//	public CableBoxDivider(int rows, int colomns) {
//		super();
//		this.rows = rows;
//		this.colomns = colomns;
//	}
	
	long[] numberOfWays(int[][] queries) {
		
        int n = queries.length;
        long[] results = new long[n];

        for (int i = 0; i < n; i++) {
            int rows = queries[i][0];
            int columns = queries[i][1];

            int ways = 0;
            
            // numb of ways divided
            for (int a = 1; a <= Math.min(rows, columns); a++) {
                ways += (rows - a + 1) * (columns - a + 1);
            }

            results[i] = ways;
        }

        return results;
    }
	

}



