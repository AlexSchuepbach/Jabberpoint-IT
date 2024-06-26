package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.Interfaces.SlideItem;


public abstract class SlideItemInstance implements PresentationItem, SlideItem {
	protected int x;
	protected int y;
	
	public SlideItemInstance() {
		this.x = 0;
        this.y = 0;
	}

	public SlideItemInstance(SlideItemInstance original){
        this.x = original.x;
        this.y = original.y;
    }

	public abstract void draw(Graphics g, ImageObserver observer);

	public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void updateCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract SlideItemInstance clone();

    @Override
    public Element getXMLSaveElement(Document doc) {
        Element slideItemE = doc.createElement(this.getClass().getSimpleName());
        Element xE = doc.createElement("x");
        xE.setTextContent(String.valueOf(this.x));
        Element yE = doc.createElement("y");
        yE.setTextContent(String.valueOf(this.y));
        slideItemE.appendChild(xE);
        slideItemE.appendChild(yE);
        return slideItemE;
    }

}
