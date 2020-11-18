import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Rugby {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int pointsNum = Integer.parseInt(in.nextLine());
            int[] yPoints = new int[pointsNum];
            int[] xPoints = new int[pointsNum];
            for (int j = 0; j < pointsNum; j++) {
                String[] pointsStr = in.nextLine().split(" ");
                xPoints[j] = Integer.parseInt(pointsStr[0]);
                yPoints[j] = Integer.parseInt(pointsStr[1]);
            }

            Arrays.sort(yPoints);
            int medianY = yPoints[pointsNum/2];

            int[] modifiedX = new int[pointsNum];
            Arrays.sort(xPoints);
            for (int j = 0; j < pointsNum; j++) {
                modifiedX[j] = xPoints[j] - j;
            }
            Arrays.sort(modifiedX);
            int medianX = modifiedX[pointsNum/2];

            long distanceY = 0, distanceX = 0, totalDistance = 0;
            for (int j = 0; j < pointsNum; j++) {
                distanceY += Math.abs(yPoints[j] - medianY);
                distanceX += Math.abs(xPoints[j] - (medianX + j));
            }

            totalDistance = distanceX + distanceY;
            System.out.println("Case #" + i + ": " + totalDistance);
        }
    }
}
