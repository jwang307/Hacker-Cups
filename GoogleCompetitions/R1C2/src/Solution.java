import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            int count = 0;
            boolean[] checked = new boolean[10];
            String[] digitString = new String[10];
            boolean found = false;
            for (int k = 0; k < 10000; k++) {
                String[] number = in.nextLine().split(" ");
                String num = number[0];
                String code = number[1];
                for (int j = 0; j < num.length(); j++) {
                    int digit = Integer.parseInt(num.substring(j, j + 1));
                    if (checked[digit]) {
                        continue;
                    } else {
                        count++;
                        checked[digit] = true;
                        digitString[digit] = code.substring(j, j + 1);
                    }
                    if (count >= 10) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (found) {
                StringBuilder digitStr = new StringBuilder();
                for (int j = 0; j < 10; j++) {
                    digitStr.append(digitString[j]);
                }
                System.out.println("Case #" + (i+1) + ": " + digitStr.toString());
            } else {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
        }
    }

}
