import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i < cases + 1; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int N = Integer.parseInt(st.nextToken()); int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken()); int C = Integer.parseInt(st.nextToken());
            int finalN = N;
            if (((A + B - C) > N) || (A == B && B == C && N != A && A == 1)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else if ((A == B && B == C && N != A)) {
                ArrayList<Integer> finalArr = new ArrayList<>();
                for (int j = 0; j < C - 1; j++) {
                    finalArr.add(finalN);
                }
                for (int j = 0; j < N - C; j++) {
                    finalArr.add(1);
                }
                finalArr.add(finalN);
                System.out.print("Case #" + i + ": ");
                for (int j = 0; j < finalN; j++) {
                    if (j == finalArr.size() - 1) {
                        System.out.print(finalArr.get(j) + "\n");
                    } else {
                        System.out.print(finalArr.get(j) + " ");
                    }
                }
            } else {
                A -= C; B -=C; N -= C;
                ArrayList<Integer> front = new ArrayList<>();
                ArrayList<Integer> back = new ArrayList<>();
                ArrayList<Integer> finalArr = new ArrayList<>();
                if (A <= B) {
                    int initial = 0;
                    while (A > 0) {
                        front.add(initial);
                        initial++;
                        N--;
                        A--;
                    }
                    initial = 0;
                    while (N > 0) {
                        if (B > 0) {
                            B--;
                            back.add(initial);
                            initial++;
                            if (B == 0) initial = 0;
                        } else {
                            initial--;
                            back.add(initial);
                        }
                        N--;
                    }
                    int max = finalN;

                    finalArr.addAll(front);
                    for (int j = 0; j < C; j++) {
                        finalArr.add(max);
                    }
                    for (int j = back.size() - 1; j >= 0; j--) {
                        finalArr.add(back.get(j));
                    }
                } else {
                    int initial = 0;
                    while (B > 0) {
                        front.add(initial);
                        initial++;
                        N--;
                        B--;
                    }
                    initial = 0;
                    while (N > 0) {
                        if (A > 0) {
                            A--;
                            back.add(initial);
                            initial++;
                            if (A == 0) initial = 0;
                        } else {
                            initial--;
                            back.add(initial);
                        }
                        N--;
                    }
                    int max = finalN;

                    finalArr.addAll(back);
                    for (int j = 0; j < C; j++) {
                        finalArr.add(max);
                    }
                    for (int j = front.size() - 1; j >= 0; j--) {
                        finalArr.add(front.get(j));
                    }
                }

                System.out.print("Case #" + i + ": ");
                int min = Collections.min(finalArr);
                if (min < 1) {
                    for (int j = 0; j < finalArr.size(); j++) {
                        if (j == finalArr.size() - 1) {
                            System.out.print(Math.min((finalArr.get(j) + Math.abs(min) + 1), finalN) + "\n");
                        } else {
                            System.out.print(Math.min((finalArr.get(j) + Math.abs(min) + 1), finalN) + " ");
                        }
                    }
                } else {
                    for (int j = 0; j < finalArr.size(); j++) {
                        if (j == finalArr.size() - 1) {
                            System.out.print(Math.min((finalArr.get(j)), finalN) + "\n");
                        } else {
                            System.out.print(Math.min((finalArr.get(j)), finalN) + " ");
                        }
                    }
                }
            }
        }
    }
}
