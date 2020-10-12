import java.io.*;
import java.util.Scanner;

public class Airlines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("airlines.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("airlines.out")));

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            int airlines = Integer.parseInt(br.readLine());

            String[] incoming = br.readLine().split("");
            String[] outgoing = br.readLine().split("");

            String[][] paths = new String[airlines][airlines];

            String[] answer = new String[airlines];

            for (int j = 0; j < airlines; j++) {
                boolean possible = true;
                int count = j;
                paths[j][j] = "Y";
                while (possible && count < airlines - 1) {
                    if (outgoing[count].equals("Y") && incoming[(count+1)%airlines].equals("Y")) {
                        paths[j][(count+1)%airlines] = "Y";
                    } else {
                        possible = false;
                    }
                    count++;
                }

                possible = true;
                count = j;
                while (possible && count > 0) {
                    if (outgoing[count].equals("Y") && incoming[(count-1)%airlines].equals("Y")) {
                        paths[j][(count-1)%airlines] = "Y";
                    } else {
                        possible = false;
                    }
                    count--;
                }

                fill(paths[j]);

                StringBuilder pofI = new StringBuilder();

                for (String str : paths[j]) {
                    pofI.append(str);
                }

                answer[j] = pofI.toString();
            }

            pw.println("Case #" + (i+1) + ": ");
            for (String str : answer) {
                pw.println(str);
            }
        }

        pw.close();
    }

    static void fill(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = "N";
            }
        }
    }
}
