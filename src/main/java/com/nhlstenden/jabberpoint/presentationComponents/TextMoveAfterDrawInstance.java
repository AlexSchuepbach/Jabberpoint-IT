package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.TextItem;
import com.nhlstenden.jabberpoint.baseDecorators.TextDecorator;
import com.nhlstenden.jabberpoint.builder.Builder;
import com.nhlstenden.jabberpoint.builder.TextMoveAfterDrawBuilder;

public class TextMoveAfterDrawInstance extends TextDecorator {

    private int movementRate;

    private TextMoveAfterDrawInstance(TextItem item, int movementRate) {
        this.item = item;
        this.movementRate = movementRate;
    }

    private TextMoveAfterDrawInstance(TextMoveAfterDrawInstance decorator){
        this.item = decorator.item;
        this.movementRate = decorator.movementRate;
    }
    
    public TextMoveAfterDrawInstance() {
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
        Element decorator = super.getXMLSaveElement(doc);
        decorator.setAttribute("movementRate", String.valueOf(movementRate));
        return decorator;
    }

    public static TextMoveAfterDrawInstance ApplyToText(TextItem item, int movementRate) {
        return new TextMoveAfterDrawInstance(item,movementRate);
    }

    @Override
    public Builder getBuilder(Parent parent) {
        return new TextMoveAfterDrawBuilder(parent);
    }

    @Override
    public TextMoveAfterDrawInstance clone() {
        return new TextMoveAfterDrawInstance(this);
    }

    public static TextMoveAfterDrawInstance getInstanceWithChildAndMovementRate(TextItem item, int movementRate){
        return new TextMoveAfterDrawInstance(item, movementRate);
    }

    @Override
    public void addAttribute(TextAttribute attribute, int value) {
        item.addAttribute(attribute, value);

    }
}
