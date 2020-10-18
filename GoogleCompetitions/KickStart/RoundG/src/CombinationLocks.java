import java.util.Arrays;
import java.util.Scanner;

public class CombinationLocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int w = in.nextInt(); int n = in.nextInt(); in.nextLine();
            String[] strings = in.nextLine().split(" ");
            long[] array = Arrays.stream(strings).mapToLong(Long::parseLong).toArray();

            long minNeeded = Long.MAX_VALUE;
            long currentNeeded = 0;
            for (int j = 0; j < w; j++) {
                long target = array[j];
                for (int k = 0; k < array.length; k++) {
                    currentNeeded += Math.min(Math.abs(array[k] - target), array[k] <
                            target? Math.abs(n - target + array[k]) : Math.abs(n + target - array[k]));
                }
                if (currentNeeded < minNeeded) minNeeded = currentNeeded;
                currentNeeded = 0;
            }

            System.out.println("Case #" + i + ": " + minNeeded);
        }
    }
}
