import java.io.*;
import java.util.Stack;

public class Alchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("alchemy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("alchemy.out")));

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            int stones = Integer.parseInt(br.readLine());
            String stoneColors = br.readLine();
            int[] counts = count(stoneColors);
            if (Math.abs(counts[0] - counts[1]) < 2) {
                pw.println("Case #" + (i+1) + ": Y");
            } else {
                pw.println("Case #" + (i+1) + ": N");
            }

            /*String[] targets;
            while(stoneColors.length() > 1) {
                if (count(stoneColors).equals("A")) {
                    targets = new String[]{"AAB", "ABA", "BAA"};
                } else {
                    targets = new String[]{"BBA", "ABB", "BAB"};
                }
                boolean found = false;
                for (int j = 0; j < stoneColors.length() - 2; j++) {
                    String substring = stoneColors.substring(j, j+3);
                    if (contains(targets, substring)) {
                        stoneColors = stoneColors.substring(0, j) + count(stoneColors) + stoneColors.substring(j+3);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            }

            if (stoneColors.length() == 1) {
                pw.println("Case #" + (i+1) + ": Y");
            } else {
                pw.println("Case #" + (i+1) + ": N");
            }*/
        }

        pw.close();
    }

    static int[] count(String colors) {
        int countA = 0, countB = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.substring(i, i+1).equals("A")) {
                countA++;
            } else {
                countB++;
            }
        }
        //return countA > countB? "A" : "B";
        return new int[]{countA, countB};
    }

    static boolean contains(String[] targets, String str) {
        for (String s : targets) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /*static String combinedResult(String[] colors) {
        int countA = 0, countB = 0;
        for (String str : colors) {
            if (str.equals("A")) {
                countA++;
            } else if (str.equals("B")) {
                countB++;
            }
        }

       if (countA > 0 && countB > 0) {
           return countA > countB? "A" : "B";
       } else {
           return "N";
       }
    }*/
}
