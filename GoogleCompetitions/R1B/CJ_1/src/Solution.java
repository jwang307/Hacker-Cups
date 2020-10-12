import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] tries = new int[][] {{500000000, 0}, {-500000000, 0}, {0, 500000000}, {0, -500000000}};
        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            int quadrant = 0;
            boolean found = false;
            for (int j = 0; j < 4; j++) {
                System.out.println((tries[j][0]) + " " + (tries[j][1]));
                String output = in.nextLine();
                check(output);
                if (output.equals("HIT")) {
                    quadrant = j;
                    break;
                } else if (output.equals("CENTER")) {
                    found = true;
                    break;
                }
            }
            if (found) continue;

            int[] coordinates = new int[4];
            for (int j = 0; j < 4; j++) {
                int l, u, dir, axis;
                if (j == 0) {
                    l = tries[quadrant][1];
                    u = (int) (Math.pow(10, 9));
                    axis = tries[quadrant][0];
                    dir = 0;
                } else if (j == 1) {
                    l = tries[quadrant][0];
                    u = (int) (Math.pow(10, 9));
                    axis = tries[quadrant][1];
                    dir = 1;
                } else if (j == 2) {
                    l = (int) (-Math.pow(10, 9));
                    u = tries[quadrant][1];
                    axis = tries[quadrant][0];
                    dir = 2;
                } else {
                    l = (int) (-Math.pow(10, 9));
                    u = tries[quadrant][0];
                    axis = tries[quadrant][1];
                    dir = 3;
                }
                coordinates[j] = binarySearch(l, u, dir, axis);
                if (coordinates[j] == -2) {
                    found = true;
                    break;
                }
            }
            if (found) continue;

            int x = (coordinates[1] + coordinates[3]) / 2;
            int y = (coordinates[0] + coordinates[2]) / 2;

            System.out.println(x + " " + y);
            if (in.nextLine().equals("CENTER")) {
                continue;
            } else {
                for (int j = 1; j < 4; j++) {
                    System.out.println(x + " " + y);
                    if (!in.nextLine().equals("CENTER")) y++;
                    int square = 2*j;
                    for (int k = 0; k < 4; k++) {
                        for (int m = 0; m < square; m++) {
                            System.out.println(x + " " + y);
                            if (in.nextLine().equals("CENTER")) {
                                found = true;
                                break;
                            } else {
                                if (k == 0 && m < square - 1) {
                                    x++;
                                } else if (k == 1) {
                                    y--;
                                } else if (k == 2) {
                                    x--;
                                } else if (k == 3) {
                                    y++;
                                }
                            }
                        }
                        if (found) break;
                    }
                    if (found) break;
                }
            }
        }

    }

    static int binarySearch(int l, int u, int dir, int axis)
    {
        Scanner in = new Scanner(System.in);
        int lastHit;
        if (dir < 2) {
            lastHit = l;
        } else {
            lastHit = u;
        }

        int mid = (l+u)/2;
        if (dir%2==0) {
            System.out.println(axis + " " + mid);
        } else {
            System.out.println(mid + " " + axis);
        }
        String response = in.nextLine();
        check(response);
        if (dir < 2) {
            if (response.equals("HIT")) {
                l = mid;
                lastHit = mid;
            } else if (response.equals("CENTER")) {
                return -2;
            } else {
                u = mid;
            }
        } else {
            if (response.equals("HIT")) {
                u = mid;
                lastHit = mid;
            } else if (response.equals("CENTER")) {
                return -2;
            } else {
                l = mid;
            }
        }
        if (u - l <= 1) {
            return lastHit;
        }
        return binarySearch(l, u, dir, axis);
    }

    static void check(String output) {
        if (output.equals("WRONG")) System.exit(-1);
    }
}
