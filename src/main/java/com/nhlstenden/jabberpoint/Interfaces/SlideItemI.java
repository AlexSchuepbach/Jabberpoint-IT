package com.nhlstenden.jabberpoint.Interfaces;

import java.awt.Graphics;
import java.awt.image.ImageObserver;


public interface SlideItemI extends Prototype, PresentationItemI {
    
    public void updateCoords(int x, int y);

    public int getX();
    public void setX(int x);
    public int getY();
    public void setY(int y);

}
