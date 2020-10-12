import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            String[] info = in.nextLine().split(" ");
            int n = Integer.parseInt(info[0]);
            int k = Integer.parseInt(info[1]);
            if (k%n==0) {
                int trace = k/n;
                int[][] matrix = new int[n][n];
                int caseNum = i+1;
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                /*if (n%2==0) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][j] = trace;
                    }
                    for (int j = 1; j < n; j++) {
                        int fill = j < trace ? j : j + 1;
                        matrix[j][0] = fill;
                        matrix[0][j] = fill;
                        if (j % 2 == 0) {
                            for (int m = j; m < n; m++) {
                                matrix[m - j][m] = fill;
                                matrix[m][m - j] = fill;
                            }
                        } else {
                            for (int m = j; m >= 0; m--) {
                                matrix[j - m][m] = fill;
                                matrix[n-1-m][n-1-(j-m)] = fill;
                            }
                        }
                    }
                } else {*/
                    int[] ordering = new int[n];
                    for (int j = 0; j < n; j++) {
                        if (j == 0) {
                            ordering[j] = trace;
                        } else {
                            ordering[j] = j < trace? j : j+1;
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        for (int m = j; m < (n + j); m++) {
                            matrix[j][m%n] = ordering[m-j];
                        }
                    }
                //}
                for (int j = 0; j < n; j++) {
                    for (int m = 0; m < n; m++) {
                        if (m == n-1) {
                            System.out.print(matrix[j][m] + "\n");
                        } else {
                            System.out.print(matrix[j][m] + " ");

                        }
                    }
                }

            } else {
                int caseNum = i+1;
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}
