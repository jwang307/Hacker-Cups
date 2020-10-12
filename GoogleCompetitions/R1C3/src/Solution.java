import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cases; i++) {
            String[] info = in.nextLine().split(" ");
            String[] sizes = in.nextLine().split(" ");
            long[] s = new long[Integer.parseInt(info[0])];
            for (int j = 0; j < Long.parseLong(info[0]); j++) {
                s[j] = Long.parseLong(sizes[j]);
            }
            if (Integer.parseInt(info[1]) == 2) {
                long maxCount = mostFrequent(s, s.length);
                if (maxCount >= 2) {
                    System.out.println("Case #" + (i+1) + ": " + 0);
                } else {
                    System.out.println("Case #" + (i+1) + ": " + 1);
                }
            } else {
                long maxCount = mostFrequent(s, s.length);
                if (maxCount >= 3) {
                    System.out.println("Case #" + (i+1) + ": " + 0);
                } else if (maxCount == 2) {
                    System.out.println("Case #" + (i+1) + ": " + 1);
                } else {
                    ArrayList<Long> checked = new ArrayList<>();
                    checked.add(s[0]);
                    boolean found = false;
                    while (checked.size() < s.length) {
                        long checking = s[checked.size()];
                        for (int j = 0; j < checked.size(); j++) {
                            if (checking%checked.get(j)==0 && checking > checked.get(j)) {
                                System.out.println("Case #" + (i+1) + ": " + 1);
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                        checked.add(checking);
                    }
                    if (!found) {
                        System.out.println("Case #" + (i+1) + ": " + 2);
                    }
                }
            }
        }
    }
    static long mostFrequent(long arr[], int n)
    {

        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear
        // traversal
        long max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr[i - 1];
                }
                curr_count = 1;
            }
        }

        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr[n - 1];
        }

        return max_count;
    }
}
