package com.nhlstenden.jabberpoint;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface SlideItemI extends Prototype {


    public void draw(Graphics g, ImageObserver observer);
    
    public void updateCoords(int x, int y);

    public int getX();
    public void setX(int x);
    public int getY();
    public void setY(int y);

    public Element getSaveInfo(Document doc);

}
