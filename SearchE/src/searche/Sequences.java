package searche;

import java.util.Random;

public class Sequences {

	public static int editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
	}
	
	public static void main(String[] args) {
		// two arbitrary strings
		String s1 = "transposition";
		String s2 = "transponder";
		int d = editDistance(s1, s2);
		System.out.println("Dist between '" + s1 + "' and '" + s2 + "' = " + d);
		long val=0;
		// random strings
		 for(int k =0;k<100;k++)
	        {
	       
        Random r = new Random( );
		String s1r = "";
		String s2r = "";
        int len = 1000;
        	//System.out.println(""+k);
        for( int j = 0; j < len; j++ ){
            s1r += (char) ( 'a' + r.nextInt(26));
            s2r += (char) ( 'a' + r.nextInt(26));
        }
        long startTime = System.currentTimeMillis();
		int dr = editDistance(s1r, s2r);
	    long endTime = System.currentTimeMillis();
		//System.out.println("Dist between '" + s1r + "' and '" + s2r + "' = " + dr);
		//System.out.println(dr);
	    val+=(endTime-startTime);
	}
		double avg=val/100;
		
		
		System.out.println("Avg of numbers: "+ avg);
	}
}
