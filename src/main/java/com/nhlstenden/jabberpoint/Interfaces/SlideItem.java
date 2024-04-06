package com.nhlstenden.jabberpoint.Interfaces;


public interface SlideItem extends Prototype, PresentationItem {
    
    public void updateCoords(int x, int y);

    public int getX();
    public void setX(int x);
    public int getY();
    public void setY(int y);

}
