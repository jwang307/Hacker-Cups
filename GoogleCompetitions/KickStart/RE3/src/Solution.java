import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            int toyNum = Integer.parseInt(in.nextLine());
            LinkedList<Integer> E = new LinkedList<>();
            LinkedList<Integer> R = new LinkedList<>();
            for (int j = 0; j < toyNum; j++) {
                StringTokenizer st = new StringTokenizer(in.nextLine());

                E.add(Integer.parseInt(st.nextToken()));
                R.add(Integer.parseInt(st.nextToken()));
            }
            ArrayList<Integer> maxEnjoyment = new ArrayList<>();
            if (check(E, R)) {
                System.out.println("Case #" + (i+1) + ": INDEFINITELY");
            } else {

            }
        }
    }

    static int worstOne(LinkedList<Integer> arrE, LinkedList<Integer> arrR) {
        int worstIndex = 0;
        int worstDiff = arrE.get(0) - arrR.get(0);
        for (int i = 1; i < arrE.size(); i++) {
            int diff = arrE.get(i) - arrR.get(i);
            if (diff < worstDiff) {
                worstDiff = diff;
                worstIndex = i;
            }
        }
        //arrE.remove(worstIndex); arrR.remove(worstIndex);
        return worstIndex;
    }

    static boolean check(LinkedList<Integer> arrE, LinkedList<Integer> arrR) {
        for (int i = 0; i < arrE.size(); i++) {
            if (!(sum(arrE, i) >= arrR.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int sum(LinkedList<Integer> arrE, int index) {
        int sum = 0;
        for(int i = 0; i < arrE.size(); i++)
            if (i != index)
                sum += arrE.get(i);
        return sum;
    }

    /*static int findMaxEnjoyment(LinkedList<Integer> arrE, LinkedList<Integer> arrR) {
        int start = 0;
        for (int i = 0; i < arrE.size(); i++) {

        }
    }*/
}
