package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Circle extends Shape {

    private Point point;
    private int radius;
    private Color color = new Color("Green");

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public boolean contains(Point point) {
        int deltaX = point.getX() - this.point.getX();
        int deltaY = point.getY() - this.point.getY();
        return square(deltaX) + square(deltaY) <= square(radius);
    }

    public int countContainingPoints(int[] xCords, int[] yCords) {
        int numberOfContainingPoints = 0;
        for (int i = 0; i < xCords.length; ++i) {
            if (contains(new Point(xCords[i], yCords[i]))) {
                numberOfContainingPoints++;
            }
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
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: (" + getX() + "," + getY() + ") radius= " + radius
                + " RGB=" + this.color.getRed() + ","
                + this.color.getGreen() + ","
                + this.color.getBlue();
    }

    private static int square(int value) {
        return value * value;
    }

    public String toXml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<circle");
        builder.append(" x=\"" + this.getX() + "\"");
        builder.append(" y=\"" + this.getY() + "\"");
        builder.append(" radius=\"" + this.getRadius() + "\"");
        builder.append(" />\n");
        return builder.toString();
    }
}
