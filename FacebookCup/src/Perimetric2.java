import java.io.*;
import java.math.BigInteger;
import java.nio.charset.IllegalCharsetNameException;
import java.util.StringTokenizer;

public class Perimetric2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimetric.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimetric.out")));

        int plans = Integer.parseInt(br.readLine());
        for (int s = 0; s < plans; s++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            String[] lK = br.readLine().split(" ");

            st = new StringTokenizer(br.readLine());
            int aL = Integer.parseInt(st.nextToken());
            int bL = Integer.parseInt(st.nextToken());
            int cL = Integer.parseInt(st.nextToken());
            int dL = Integer.parseInt(st.nextToken());

            String[] hK = br.readLine().split(" ");

            int[] lengths = new int[n];
            int[] heights = new int[n];
            for (int i = 0; i < lK.length; i++) {
                lengths[i] = Integer.parseInt(lK[i]);
                heights[i] = Integer.parseInt(hK[i]);
            }

            st = new StringTokenizer(br.readLine());
            int aH = Integer.parseInt(st.nextToken());
            int bH = Integer.parseInt(st.nextToken());
            int cH = Integer.parseInt(st.nextToken());
            int dH = Integer.parseInt(st.nextToken());

            for (int i = k; i < n; i++) {
                int l = (aL * lengths[i - 2] + bL * lengths[i - 1] + cL) % dL + 1;
                int h = (aH * heights[i - 2] + bH * heights[i - 1] + cH) % dH + 1;
                lengths[i] = l;
                heights[i] = h;
            }

            long result = 1;
            final int mod = 1000000007;
            int prevL = lengths[0] - w;
            int prevH = 0;
            long[][] perimeters = new long[2][500000000 + 20];

            for (int i = 0; i < n; i++) {
                int currL = lengths[i];
                int currH = heights[i];

                result = findCurrentResult(result, mod, prevL, currL, prevH, currH, w, perimeters);

                prevL = currL;
                prevH = currH;
            }

            pw.println("Case #" + (s+1) + ": " + result);
        }

        pw.close();
    }

    static long findCurrentResult(long result, int mod, int prevL, int currL, int prevH, int currH, int w, long[][] perimeters) {
        for (int i = currL - 1; i <= currL + w; i++) {
            if (i == currL - 1) {
                if (perimeters[1][i] != 0) {
                    perimeters[0][i] -= perimeters[1][i];
                    perimeters[0][i] += Math.abs(perimeters[1][i] - currH);
                    perimeters[1][i] = currH;
                } else if (i == currL + w){
                    perimeters[0][i] = perimeters[0][i-1] + 2 + currH;
                    perimeters[1][i] = currH;
                } else {
                    perimeters[0][i] = perimeters[0][i-1] + 2;
                }
            }
        }

        long p = perimeters[0][currL + w];
        result = (result % mod) * (p % mod);
        System.out.println(p);
        return result;
    }
}
