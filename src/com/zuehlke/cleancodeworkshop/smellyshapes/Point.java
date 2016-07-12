package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCenter() {
        return "(" + getX() + "," + getY() + ")";
    }
}
