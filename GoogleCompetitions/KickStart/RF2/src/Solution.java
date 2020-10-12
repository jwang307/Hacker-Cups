import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int intervalsNum = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
            for (int j = 0; j < intervalsNum; j++) {
                st = new StringTokenizer(in.nextLine());
                ArrayList<Integer> se = new ArrayList<>();
                se.add(Integer.parseInt(st.nextToken()));
                se.add(Integer.parseInt(st.nextToken()));
                intervals.add(se);
            }

            Collections.sort(intervals, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return Integer.compare(o1.get(0), o2.get(0));
                }
            });
            int count = 0;
            int robotsUsed = 0;
            int nextstart = intervals.get(0).get(0);
            while (nextstart < intervals.get(intervals.size() - 1).get(1)) {
                int start = intervals.get(count).get(0);
                int end = intervals.get(count).get(1);
                if (nextstart < start) nextstart = start;
                int needed = (int)Math.ceil((double)(end - nextstart)/(double)time);
                robotsUsed += needed;
                nextstart += needed * time;
                count++;
                while ((count <= (intervals.size() - 1)) && intervals.get(count).get(1) <= nextstart) {
                    count++;
                }
            }
            System.out.println("Case #" + i + ": " + robotsUsed);
        }
     }
}