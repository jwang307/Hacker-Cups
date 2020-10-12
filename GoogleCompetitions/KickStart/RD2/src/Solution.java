import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < cases; i++) {
            int keyNum = Integer.parseInt(in.nextLine());
            String[] keysStr = in.nextLine().split(" ");
            int[] keys = new int[keyNum];
            for (int  j = 0; j < keyNum; j++) {
                keys[j] = Integer.parseInt(keysStr[j]);
            }
            int records = countBreaks(keys, keyNum);

            System.out.println(" Case #" + (i+1) + ": " + records);
        }
    }

    static int countBreaks(int[] keys, int keyNum) {
        int breaks = 0;
        int disparity = 0;
        for (int i = 1; i < keyNum; i++) {
            if (keys[i] > keys[i-1]) {
                if (i > 1) {
                    if (keys[i - 1] < keys[i - 2]) {
                        disparity = 0;
                    }
                }
                disparity++;

            } else if (keys[i] < keys[i-1]) {
                if (i > 1) {
                    if (keys[i - 1] > keys[i - 2]) {
                        disparity = 0;
                    }
                }
                disparity--;

            }

            if (Math.abs(disparity) >= 4) {
                breaks++;
                disparity = 0;
            }

        }

        return breaks;
    }
}

