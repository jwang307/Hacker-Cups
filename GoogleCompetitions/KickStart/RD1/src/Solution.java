import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < cases; i++) {
            int days = Integer.parseInt(in.nextLine());
            String[] people = in.nextLine().split(" ");
            int[] attendance = new int[days];
            for (int  j = 0; j < people.length; j++) {
                attendance[j] = Integer.parseInt(people[j]);
            }
            int records = countRecords(attendance, days);

            System.out.println(" Case #" + (i+1) + ": " + records);
        }
    }

    static int countRecords(int[] attendance, int days) {
        if (days == 1) {
            return 1;
        }
        int records = 0;
        if (attendance[0] > attendance[1]) {
            records++;
        }

        int prevMax = attendance[0];
        for (int i = 1; i < attendance.length - 1; i++) {
            if (attendance[i] > prevMax) {
                if (attendance[i] > attendance[i+1]) {
                    records++;
                }
                prevMax = attendance[i];
            }
        }

        if (attendance[attendance.length - 1] > prevMax) {
            records++;
        }

        return records;
    }
}
