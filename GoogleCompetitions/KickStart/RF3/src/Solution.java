import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= cases; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int s = Integer.parseInt(st.nextToken());
            Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int c = Integer.parseInt(st.nextToken());
            ArrayList<Point> constructions = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                st = new StringTokenizer(in.nextLine());
                constructions.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            int score = 0;
            if (c == 0) {
                if (b.equals(new Point(2, 2))) {
                    score = -1;
                } else if (a.equals(new Point(2, 2))){
                    score = 1;
                } else {
                    score = 2;
                }
            } else if (c == 1) {
                if (!constructions.get(0).equals(new Point(2, 2))) {
                    if (a.equals(new Point(2, 2))) {
                        score = 1;
                    } else if (b.equals(new Point(2, 2))) {
                        score = -1;
                    } else {
                        score = 1;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + score);
        }
    }
}
