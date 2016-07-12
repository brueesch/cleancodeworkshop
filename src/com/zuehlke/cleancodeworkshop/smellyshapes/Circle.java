package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Circle extends Shape {

    private Point center;
    private int radius;
    private Color color = new Color("Green");

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean contains(Point point) {
        int deltaX = point.getX() - this.center.getX();
        int deltaY = point.getY() - this.center.getY();
        return square(deltaX) + square(deltaY) <= square(radius);
    }

    public int countContainingPoints(Point[] points) {
        int numberOfContainingPoints = 0;
        for (int i = 0; i < points.length; ++i) {
            if (contains(points[i])) {
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
        return center.getX();
    }

    public int getY() {
        return center.getY();
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: " + center.getCenter() + " radius= " + radius
                + color.getRGB();
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
