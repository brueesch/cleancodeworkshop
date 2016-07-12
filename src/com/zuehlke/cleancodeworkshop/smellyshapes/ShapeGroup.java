package com.zuehlke.cleancodeworkshop.smellyshapes;

public class ShapeGroup extends Shape {

    public static final int INITIAL_CAPACITY = 10;
    public static final int CAPACITY_INCREASE_AMOUNT = 10;
    protected boolean readOnly = false;
    Shape[] shapes = new Shape[INITIAL_CAPACITY];
    int size = 0;

    public ShapeGroup() {
    }

    public ShapeGroup(Shape[] shapes, boolean readOnly) {
        this.shapes = shapes;
        this.size = shapes.length;
        this.readOnly = readOnly;
    }

    public void add(Shape shape) {
        if (readOnly) {
            return;
        }
        if (shouldGrow()) {
            grow();
        }

        if (contains(shape)) {
            return;
        }
        addInternally(shape);
    }

    private boolean shouldGrow() {
        return size + 1 > shapes.length;
    }

    private void grow() {
        Shape[] newShapes = new Shape[shapes.length + CAPACITY_INCREASE_AMOUNT];
        for (int i = 0; i < size; i++) {
            newShapes[i] = shapes[i];
        }
        shapes = newShapes;
    }

    private void addInternally(Shape shape) {
        shapes[size++] = shape;
    }

    public boolean contains(Shape shape) {
        for (int i = 0; i < size; i++) {
            if (shapes[i].equals(shape)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int x, int y) {
        for (Shape shape : shapes) {
            if (shape != null) {
                if (shape.contains(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String toXml() {
        StringBuilder builder = new StringBuilder();

        builder.append("<shapegroup>\n");
        for (int i = 0; i < this.size; i++) {
            builder.append(this.shapes[i].toXml());
        }
        builder.append("</shapegroup>\n");

        return builder.toString();
    }
}
