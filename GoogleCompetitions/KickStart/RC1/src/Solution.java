import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt(); in.nextLine();

        for (int i = 0; i < cases; i++) {
            int length = in.nextInt(); int k = in.nextInt(); in.nextLine();

            String[] input = in.nextLine().split(" ");
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j]=Integer.parseInt(input[j]);
            }
            ArrayList<Integer> kIndices = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (nums[j] == k) kIndices.add(j);
            }
            int counter = 0;
            for (int j = 0; j < kIndices.size(); j++) {
                int index = kIndices.get(j);
                if (length-index < k) {
                    continue;
                } else {
                    if(check(k, index, nums)) {
                        counter++;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + counter);
        }
    }
    static boolean check(int k, int index, int[] nums) {
        int count = 0;
        while (count < k) {
            if (nums[index+count] == k - count) {
            } else {
                return false;
            }
            count++;
        }
        return true;
    }
}
