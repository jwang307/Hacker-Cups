import java.util.Map;
import java.util.Scanner;

//pylons
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            String[] dim = in.nextLine().split(" ");
            int R = Integer.parseInt(dim[0]); int C = Integer.parseInt(dim[1]);
            if (R <=5 && C <= 5) {
                int[][] path = baseCase(R, C);
                if (path[0][0] == 0) {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    continue;
                }
                if (R == 3 && C == 4) {
                    path = new int[][] {{2,3}, {1,1}, {3,2}, {1,3}, {3,4}, {2,2}, {1,4}, {2,1}, {3,3}, {1,2}, {2,4}, {3,1}};
                } else if (R == 3 && C == 5) {
                    path = new int[][] {{2,3}, {1,1}, {3,2}, {1,3}, {3,4}, {1,5}, {2,1}, {3,3}, {1,4}, {2,2}, {3,5}, {1,2}, {2, 4}, {3, 1}, {2, 5}};

                } else if (R == 2 && C == 5) {
                        for (int j = 0; j < R * C; j++) {
                            int temp = path[j][0];
                            path[j][0] = path[j][1];
                            path[j][1] = temp;
                        }
                }
                System.out.println("Case #" + (i+1) + ": POSSIBLE");
                for (int j = 0; j < R*C; j++) {
                    System.out.println(path[j][0] + " " + path[j][1]);
                }
            } else {
                int[][] path = pathFinder(R, C);
                System.out.println("Case #" + (i+1) + ": POSSIBLE");
                for (int j = 0; j < R*C; j++) {
                    System.out.println(path[j][0] + " " + path[j][1]);
                }
            }
        }
    }

    static int[][] baseCase(int one, int two) {
        int[][] path = new int[one*two][2];
        if ((one == 5 && two == 2) || (one == 2 && two == 5)) {
            path = new int[][]{{3, 2}, {1, 1}, {4, 2}, {2, 1}, {5, 2}, {3, 1}, {1, 2}, {5, 1}, {2, 2}, {4, 1}};
        } else if (one + two > 6) {
            int count = 0;
            for (int i = 0; i < one; i++) {
                for (int j = 0; j < two; j++) {
                   if (one == two && i == one-1 && one % 2 == 0) {
                            if (j % 2 != 0) {
                                path[count][0] = i + 1;
                                path[count][1] = j + 2;
                                if (j == two - 1) path[count][1] -= two;
                            } else {
                                path[count][0] = (i + 3);
                                if (path[count][0] > one) path[count][0] -= one;
                                path[count][1] = j + 2;
                            }
                    } else {
                        if (j % 2 == 0) {
                            path[count][0] = i + 1;
                            path[count][1] = j + 1;
                        } else {
                            path[count][0] = (i + 3);
                            if (path[count][0] > one) path[count][0] -= one;
                            path[count][1] = j + 1;
                        }
                    }
                    count++;
                }
            }
        }

        return path;
    }

    static int[][] pathFinder(int r, int c) {
        int path[][] = new int[r*c][2];
        if (r == 2 || c == 2) {
            for (int i = 1; i <= r*c; i++) {
                if (i % 2 == 0) {
                    path[i-1][0] = 1; path[i-1][1] = i/2;
                } else {
                    path[i-1][0] = 2; path[i-1][1] = (Math.max(r, c)/2 + i/2);
                    if (path[i-1][1] > Math.max(r, c)) path[i-1][1] -= Math.max(r, c);
                }
            }
            if (c == 2) {
                for (int j = 0; j < r*c; j++) {
                    int temp = path[j][0];
                    path[j][0] = path[j][1];
                    path[j][1] = temp;
                }
            }
        } else if (r != 3) {
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (r == c && i == r-1 && r % 2 == 0) {
                        if (j % 2 != 0) {
                            path[count][0] = i + 1;
                            path[count][1] = j + 2;
                            if (j == c - 1) path[count][1]--;
                        } else {
                            path[count][0] = (i + 3);
                            if (path[count][0] > r) path[count][0] -= r;
                            path[count][1] = j + 2;
                        }
                    } else {
                        if (j % 2 == 0) {
                            path[count][0] = i + 1;
                            path[count][1] = j + 1;
                        } else {
                            path[count][0] = (i + 3);
                            if (path[count][0] > r) path[count][0] -= r;
                            path[count][1] = j + 1;
                        }
                    }
                    count++;
                }
            }
        }
        return path;
    }

}
