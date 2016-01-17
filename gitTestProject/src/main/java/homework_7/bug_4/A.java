package homework_7.bug_4;

import java.awt.*;

class A {

    private int[] xArray;
    private int[] yArray;
    private int width;
    private int height;

    public A(int[] x, int[] y) {
        this.xArray = x;
        this.yArray = y;
    }

    public void createPolygon() {      // the wrap method for init variables
        Polygon polygon = new Polygon(xArray, yArray, yArray.length);
        width = polygon.getBounds().width;
        height = polygon.getBounds().height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}