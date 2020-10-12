import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            int rooms = in.nextInt(); int queries = in.nextInt();
            in.nextLine();
            String[] difficulties = in.nextLine().split(" ");
            int[] diffs = new int[rooms - 1];
            for (int j = 0; j < difficulties.length; j++) {
                diffs[j] = Integer.parseInt(difficulties[j]);
            }
            int[] answers = new int[queries];
            for (int j = 0; j < queries; j++) {
                int s = in.nextInt(); int k = in.nextInt();
                in.nextLine();
                answers[j] = answer(k, s, diffs);
            }

            System.out.print("Case #" + (i+1) + ":");
            for (int j : answers) {
                System.out.print(" " + j);
            }
            System.out.print("\n");
        }


    }

    static int answer(int k, int s, int[] diff) {
        int currentRoom = s;

        LinkedList<Integer> roomNum = new LinkedList<>();
        LinkedList<Integer> difficulties = new LinkedList<>();

        for (int i = 0; i < diff.length + 1; i++) {
            roomNum.add(i+1);
            if (i < diff.length) {
                difficulties.add(diff[i]);
            }
        }
        int index = s;

        for (int i = 1; i < k; i++) {
            if (roomNum.size() == 1) {
                currentRoom = roomNum.get(0);
                break;
            } else {
                int chooseRoom = 0;
                if (index != 1 && index != roomNum.size()) {
                    chooseRoom = Math.min(difficulties.get(index - 2), difficulties.get(index - 1));
                    if (chooseRoom == difficulties.get(index - 2)) {
                        difficulties.remove(index - 2);
                        currentRoom = roomNum.get(index - 2);
                        roomNum.remove(index - 1);
                        index--;
                    } else {
                        difficulties.remove(index - 1);
                        currentRoom = roomNum.get(index);
                        roomNum.remove(index - 1);
                    }
                } else {
                    if (index == 1) {
                        difficulties.remove(0);
                        currentRoom = roomNum.get(index);
                        roomNum.remove(index - 1);
                    } else {
                        difficulties.remove(difficulties.size() - 1);
                        currentRoom = roomNum.get(index - 2);
                        roomNum.remove(index - 1);
                    }
                }
            }
        }



        return currentRoom;
    }
}
