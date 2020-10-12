import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int cases = in.nextInt(); in.nextLine();
        for (int i = 0; i < cases; i++) {
            int length = in.nextInt(); in.nextLine();
            int[] numbers = new int[length];
            String[] nums = in.nextLine().split(" ");
            for (int j = 0; j < length; j++) {
                numbers[j] = Integer.parseInt(nums[j]);
            }
            int counter = 0;
            for (int j = 0; j < length; j++) {
                int sum = 0;
                int count = 0;
                while (count <= j) {
                    sum+=numbers[j-count];
                    if (isPerfectSquare(sum)) {
                        counter++;
                    }
                    count++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + counter);
        }
    }
    static boolean isPerfectSquare(double x)
    {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }
}
