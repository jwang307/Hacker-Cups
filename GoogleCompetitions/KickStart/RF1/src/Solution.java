import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int n = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            num[] ppl = new num[n];
            st = new StringTokenizer(in.nextLine());
            for (int j = 0; j < n; j++) {
                ppl[j] = new num(Integer.parseInt(st.nextToken()), max, j);
            }
            Arrays.sort(ppl, Comparator.comparingInt(o -> o.first));
            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < ppl.length; j++) {
                if (j == ppl.length - 1) {
                    System.out.print(ppl[j].index + 1 + "\n");
                } else {
                    System.out.print((ppl[j].index + 1) + " ");
                }
            }
        }
    }


}
class num {
    public int first;
    public int second;
    public int index;
    public num(int n, int max, int i) {
        this.first = n / max;
        this.second = n % max;
        if (second == 0) first--;
        this.index = i;
    }
}