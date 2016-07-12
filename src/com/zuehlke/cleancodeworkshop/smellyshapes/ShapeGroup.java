package com.zuehlke.cleancodeworkshop.smellyshapes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShapeGroup extends Shape {

    protected boolean readOnly = false;
    Set<Shape> shapeSet = new HashSet<>();



    public static ShapeGroup initializeWithReadOnly(Shape[] shapes) {
        return new ShapeGroup(shapes, true);
    }

    public static ShapeGroup initializeWithoutReadOnly(Shape[] shapes) {
        return new ShapeGroup(shapes, false);
    }

    public ShapeGroup() {
    }

    public int getSize() {
        return shapeSet.size();
    }


    private ShapeGroup(Shape[] shapes, boolean readOnly) {
        Collections.addAll(this.shapeSet, shapes);
        this.readOnly = readOnly;
    }

    public void add(Shape shape) {
        if (readOnly) {
            return;
        }

        if (contains(shape)) {
            return;
        }
        addInternally(shape);
    }


    private void addInternally(Shape shape) {
        shapeSet.add(shape);
    }

    public boolean contains(Shape shape) {
        return shapeSet.contains(shape);
    }

    public boolean contains(int x, int y) {
        for (Shape shape : shapeSet) {
            if (shape.contains(x, y)) {
                return true;
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
        for(Shape shape : shapeSet) {
            builder.append(shape.toXml());
        }
        builder.append("</shapegroup>\n");

        return builder.toString();
    }
}
