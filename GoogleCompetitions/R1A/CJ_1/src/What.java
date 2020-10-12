import java.util.Scanner;

public class What {
        public static void main (String[] args) {
            Scanner in = new Scanner(System.in);

            int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                boolean possible = true;
                int patterns = Integer.parseInt(in.nextLine());
                String[] pattern = new String[patterns];
                int maxIndex = 0;
                for (int j = 0; j < patterns; j++) {
                    pattern[j] = in.nextLine();
                    if (pattern[j].length() > pattern[maxIndex].length()) {
                        maxIndex = j;
                    }
                }
                String reference = pattern[maxIndex].substring(1);
                for (int j = 0; j < patterns; j++) {
                    if (pattern[j].length() == 1) {
                        continue;
                    }
                    String comparing = pattern[j].substring(1);
                    for (int k = 0; k < comparing.length(); k++) {
                        if (reference.charAt(reference.length() - comparing.length() + k) == comparing.charAt(k)) {
                            continue;
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }
                int caseNum = i + 1;
                if (possible) {
                    System.out.println("Case #" + caseNum + ": " + reference);
                } else {
                    System.out.println("Case #" + caseNum + ": *");
                }

            }
        }

}
