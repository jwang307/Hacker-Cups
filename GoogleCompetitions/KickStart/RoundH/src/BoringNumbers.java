import java.util.Scanner;
import java.util.StringTokenizer;

public class BoringNumbers {

    public static void main(String[] args) {

        long[] boringNums = makeBoringNumsArr();


        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            String line = in.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            long lower = Long.parseLong(st.nextToken()), upper = Long.parseLong(st.nextToken());
            long intermediate = 0;
            int lowerLength = Long.toString(lower).length();
            int upperLength = Long.toString(upper).length();
            for (int j = lowerLength + 1; j < upperLength; j++) {
                intermediate += boringNums[j];
            }

            long lowerPart = 0; long upperPart = 0;

            if (Long.toString(lower).length() == Long.toString(upper).length()) {
                lowerPart = bnCount(lower, boringNums) - bnCount(upper, boringNums);
            } else {
                lowerPart = bnCount(lower, boringNums);
                if (upperLength != 19)upperPart = boringNums[upperLength] - bnCount(upper, boringNums);
            }

            if (isBoring(Long.toString(upper))) upperPart++;

            long total = lowerPart + intermediate + upperPart;
            System.out.println("Case #" + i + ": " + total);
        }

    }

    static long[] makeBoringNumsArr() {
        long[] boringNums = new long[19];
        boringNums[0] = 1;
        boringNums[1] = 5;
        for (int i = 2; i < 19; i++) {
            boringNums[i] = boringNums[i-1]*5;
        }

        return boringNums;
    }

    static long bnCount(long lower, long[] boringNums) {
        long total = 0;
        String current = Long.toString(lower);
        int length = current.length();
        for(int i = 0; i < length; i++) {
            int leftDigit = Integer.parseInt(current.substring(0, 1));

            double a = (double) (9 - leftDigit) / (double) (2);
            if (i % 2 == 0) {
                total += Math.ceil(a) * boringNums[current.length() - 1];
            } else {
                total += Math.floor(a) * boringNums[current.length() - 1];
            }

            if ((leftDigit % 2 == 0 && i % 2 == 0)  || (leftDigit % 2 != 0 && i % 2 != 0)) break;

            if (current.length() == 1) break;
            current = current.substring(1);
        }

        if (isBoring(Long.toString(lower))) total++;
        return total;
    }

    static boolean isBoring(String num) {
        boolean isBoring = true;
        for (int i = 0; i < num.length(); i++) {
            String digit = num.substring(i, i+1);
            if (i % 2 == 0) {
                if (Integer.parseInt(digit) % 2 == 0) {
                    isBoring = false;
                    break;
                }
            } else {
                if (Integer.parseInt(digit) % 2 != 0) {
                    isBoring = false;
                    break;
                }
            }
        }

        return isBoring;
    }
}
