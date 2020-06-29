package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawShapes extends JPanel {


    ArrayList<Shape> shape = new ArrayList<>();

    int x, y, t, z;
    boolean isRectangle = true;

    public DrawShapes(int x, int y, int t, int z) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.z = z;
    }

    public void addRectangle(int x, int y, int t, int z) {
        shape.add(new Rectangle(x, y, t, z));
        repaint();
    }

    public void addEllipse(int x, int y, int t, int z) {
        shape.add(new Ellipse2D.Double(x, y, t, z));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D mainGraphic = (Graphics2D) g;
        if (isRectangle) {
            // draw the rectangle here
            mainGraphic.drawRect(x, y, t, z);
        } else if (isRectangle == false) {
            mainGraphic.drawOval(x-(t/2), y-(t/2), t, t);
        }
        for (Shape shape : shape) {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            mainGraphic.setColor(new Color(red, green, blue));
            mainGraphic.fill(shape);
        }
    }

    public void setIsRectangle(boolean rectangle) {
        isRectangle = rectangle;
    }
}

