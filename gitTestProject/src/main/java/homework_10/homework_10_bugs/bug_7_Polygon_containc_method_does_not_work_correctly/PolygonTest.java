package homework_10.homework_10_bugs.bug_7_Polygon_containc_method_does_not_work_correctly;

import java.awt.*;

public class PolygonTest {
    public static void main(String[] args) {
        int[] xPoints = {-2, 2, 2, -2};   // was fixed
        int[] yPoints = {2, 2, -2, -2};   // was fixed

        Polygon polygon = new Polygon(xPoints, yPoints, xPoints.length);
        boolean checkPoint = polygon.contains(1, 1);
        System.out.print(checkPoint);//why false?) -> should be true))
    }
}
