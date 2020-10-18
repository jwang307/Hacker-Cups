import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int n = Integer.parseInt(in.nextLine());
            int[][] mtx = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] input = in.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    mtx[j][k] = Integer.parseInt(input[k]);
                }
            }

            long maxDiag = 0;
            long[] diagonals1 = new long[2*n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    diagonals1[j-k+n] += mtx[j][k];
                }
            }

            for (int j = 1; j < diagonals1.length; j++) {
                if (diagonals1[j] > maxDiag) {
                    maxDiag = diagonals1[j];
                }
            }

            System.out.println("Case #" + i + ": " + maxDiag);
        }
    }

}
