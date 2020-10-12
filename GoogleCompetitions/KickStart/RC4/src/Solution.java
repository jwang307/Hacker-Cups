import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt(); in.nextLine();
        for (int i = 0; i < cases; i++) {
            int length = in.nextInt(); int q = in.nextInt(); in.nextLine();
            int[] numbers = new int[length];
            String[] nums = in.nextLine().split(" ");
            for (int j = 0; j < length; j++) {
                numbers[j] = Integer.parseInt(nums[j]);
            }
            int totalSum = 0;
            for (int j = 0; j < q; j++) {
                String operation = in.next(); int s = in.nextInt(); int e = in.nextInt(); in.nextLine();
                if (operation.equals("Q")) {
                    totalSum+=calculateSweetness(s, e, numbers);
                } else {
                    Array.set(numbers, s-1, e);

                }
            }
            System.out.println("Case #" + (i+1) + ": " + totalSum);
        }
    }

    static int calculateSweetness(int start, int end, int[] num) {
        int sum = 0;
        for (int i = 1; i <= end-start+1; i++) {
            if(i%2==1) {
                sum += num[start+i-2]*i;
            } else {
                sum -= num[start+i-2]*i;
            }
        }
        return sum;
    }

}
