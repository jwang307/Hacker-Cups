import java.util.ArrayList;
import java.util.Scanner;

public class Kick_Start {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            String text = in.nextLine();
            ArrayList<Integer> kick = new ArrayList<>();
            ArrayList<Integer> start = new ArrayList<>();

            for (int j = 0; j <= text.length() - 5; j++) {
                if (text.substring(j, j + 4).equals("KICK")) {
                    kick.add(j);
                }
                if (text.substring(j, j + 5).equals("START")) {
                    start.add(j);
                }
            }
          
            int count = 0;

            if (kick.size() == 0 || start.size() == 0) {
                count = 0;
            } else {
                for (int j = 0; j < kick.size(); j++) {
                    int target = kick.get(j);
                    int k = start.size() - 1;
                    while (k > -1 && start.get(k) > target) {
                        count++;
                        k--;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + count);
        }
    }
}
