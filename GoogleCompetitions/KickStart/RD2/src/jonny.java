import java.util.Arrays;
import java.util.Scanner;

public class jonny {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			int answer = 0;
			int k = Integer.parseInt(in.nextLine());
			int[] v = new int[k];
			String[] inp = in.nextLine().split(" ");
			int[][] dp = new int[k][4];
			for(int i=0;i<k;i++) {
				v[i] = Integer.parseInt(inp[i]);
				Arrays.fill(dp[i], 2*k);
			}
			for(int j=0;j<4;j++) {
				dp[0][j] = 0;
			}
			for(int i=0;i<k-1;i++) {
				for(int j=0;j<4;j++) {
					for(int nj=0;nj<4;nj++) {
						if(v[i] == v[i+1]) {
							if(j == nj) {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]);
							} else {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]+1);
							}
						} else if(v[i] > v[i+1]) {
							if(j > nj) {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]);
							} else {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]+1);
							}
						} else {
							if(j < nj) {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]);
							} else {
								dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j]+1);
							}
						}
					}
				}
			}
			answer = Math.min(Math.min(dp[k-1][0], dp[k-1][1]), Math.min(dp[k-1][2], dp[k-1][3]));
			System.out.println("Case #"+(test+1)+": "+answer);
		}
		in.close();
	}

}
