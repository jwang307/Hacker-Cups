import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int numStops = Integer.parseInt(in.nextLine());
            String[] stops = in.nextLine().split(" ");
            int[] stop = new int[stops.length];
            for (int j = 0; j < stops.length; j++) {
                stop[j] = Integer.parseInt(stops[j]);
            }
            int peaks = numPeaks(stop);

            System.out.println("Case #" + i + ": " + peaks);
        }
    }

    static int numPeaks(int[] peaks) {
        int numPeaks = 0;
        for (int i = 0; i < peaks.length; i++) {
            if (i != 0 && i != peaks.length - 1) {
                if (peaks[i] > peaks[i - 1] && peaks[i] > peaks[i + 1]) {
                    numPeaks++;
                }
            }
        }

        return numPeaks;
    }
}
