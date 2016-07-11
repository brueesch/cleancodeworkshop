package com.zuehlke.cleancodeworkshop.smellyshapes;

public class ShapeGroup extends Shape {

    public static final int INITIAL_CAPACITY = 10;
    public static final int CAPACITY_GROW_SIZE = 10;
    protected boolean readOnly = false;
    Shape[] shapes = new Shape[INITIAL_CAPACITY];
    int size = 0;

    public ShapeGroup() {}

    public ShapeGroup(Shape[] shapes, boolean readOnly) {
        this.shapes = shapes;
        this.size = shapes.length;
        this.readOnly = readOnly;
    }

    public void add(Shape shape) {
        if (readOnly) {return;}
        if (contains(shape)) {return;}

        if (shouldArrayBeIncreased()) {
            increaseArray();
        }
        addToArray(shape);
    }

    private void addToArray(Shape shape) {
        shapes[size] = shape;
        size++;
    }

    private boolean shouldArrayBeIncreased() {
        return (size + 1) > shapes.length;
    }

    private void increaseArray() {
        Shape[] newShapes = new Shape[shapes.length + CAPACITY_GROW_SIZE];
        System.arraycopy(shapes, 0, newShapes, 0, size);
        shapes = newShapes;
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
        ShapeGroup group = (ShapeGroup) this;
            builder.append("<shapegroup>\n");
            for (int i = 0; i < group.size; i++) {
                builder.append(group.shapes[i].toXml());
            }
            builder.append("</shapegroup>\n");
        return builder.toString();
    }
}
