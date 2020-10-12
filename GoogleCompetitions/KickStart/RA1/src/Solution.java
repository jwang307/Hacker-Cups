import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            int houses = in.nextInt(); int budget = in.nextInt();
            in.nextLine();
            String[] prices = in.nextLine().split(" ");
            int[] sortedprices = new int[prices.length];
            for (int j = 0; j < prices.length; j++) {
                sortedprices[j] = Integer.parseInt(prices[j]);
            }
            Arrays.sort(sortedprices);
            int count = 0;
            while (budget > 0 && count < sortedprices.length) {
                if (budget >= sortedprices[count]) {
                    budget-=sortedprices[count];
                    count++;
                } else {
                    break;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + count);
        }
    }

}
