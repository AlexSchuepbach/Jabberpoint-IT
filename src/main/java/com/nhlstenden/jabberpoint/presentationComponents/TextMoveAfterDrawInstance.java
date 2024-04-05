package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.TextItem;
import com.nhlstenden.jabberpoint.baseDecorators.TextDecorator;

public class TextMoveAfterDrawInstance extends TextDecorator {

    private int movementRate;

    public TextMoveAfterDrawInstance(TextItem item, int movementRate) {
        super(item);
        this.movementRate = movementRate;
    }
    
    public TextMoveAfterDrawInstance() {
        super();
    }

    public int getMovementRate() {
        return movementRate;
    }
    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }
    
    @Override
    public void draw(Graphics g, ImageObserver o) {
        super.draw(g, o);
        setX(getX()+movementRate);
    }
 
    @Override
    public Element getXMLSaveElement(Document doc) {
        Element wrapper = super.getXMLSaveElement(doc);
        wrapper.setAttribute("movementRate", String.valueOf(movementRate));
        return wrapper;
    }

    public static TextMoveAfterDrawInstance ApplyToText(TextItem item, int movementRate) {
        return new TextMoveAfterDrawInstance(item,movementRate);
    }
}
