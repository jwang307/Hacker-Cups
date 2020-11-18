import java.util.Scanner;

public class Retype {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());


        for (int i = 1; i <= cases; i++) {

            long N = in.nextLong(), K = in.nextLong(), S = in.nextLong();

            long methodA = N + K;
            long methodB = K + (K - S) + (N - S);
            long ans = Math.min(methodA, methodB);
            System.out.println("Case #" + i + ": " + ans);
            in.nextLine();
        }
    }
}
