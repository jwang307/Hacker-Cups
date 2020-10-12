import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i < cases + 1; i++) {

            int length = Integer.parseInt(in.nextLine());
            String[] numString = in.nextLine().split(" ");
            int[] nums = new int[numString.length];
            for (int j = 0; j < numString.length; j++) {
                nums[j] = Integer.parseInt(numString[j]);
            }
            int commonDiff = nums[1] - nums[0];
            int counter = 1;
            ArrayList<Integer> maxCounts = new ArrayList<>();
            for (int j = 1; j < nums.length - 1; j++) {
                int diff = nums[j+1] - nums[j];
                if (commonDiff == diff) {
                    counter++;
                } else {
                    maxCounts.add(counter + 1);
                    counter = 1;
                    commonDiff = diff;
                }
            }

            maxCounts.add(counter + 1);

            System.out.println("Case #" + i + ": " + Collections.max(maxCounts));
        }
    }
}
