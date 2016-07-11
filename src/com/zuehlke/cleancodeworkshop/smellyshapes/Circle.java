package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Circle extends SimpleShape {

    private int x;
    private int y;
    private int radius;
    private int numberOfContainingPoints;
    private Color color = new Color("Green");

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean contains(int x, int y) {
        int deltaX = x - this.x;
        int deltaY = y - this.y;
        boolean result = (square(deltaX) + (square(deltaY))) <= (square(radius));
        if (result == true) {
            numberOfContainingPoints++;
        }
        return result;
    }

    private static int square(int value) {
        return value * value;
    }

    public int countContainingPoints(int[] xCords, int[] yCords) {
        numberOfContainingPoints = 0;
        for (int i = 0; i < xCords.length; ++i) {
            contains(xCords[i], yCords[i]);
        }
        return numberOfContainingPoints;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: (" + this.x + "," + this.y + ") radius= " + radius
                + " RGB=" + this.color.getRed() + ","
                + this.color.getGreen() + ","
                + this.color.getBlue();
    }
}