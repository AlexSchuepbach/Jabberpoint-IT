package com.nhlstenden.jabberpoint.baseDecorators;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;
import com.nhlstenden.jabberpoint.Interfaces.DecoratorI;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.Interfaces.SlideItemI;
import com.nhlstenden.jabberpoint.Interfaces.TextItemI;
import com.nhlstenden.jabberpoint.creators.SlideItemTextCreator;

public class TextDecorator implements TextItemI, DecoratorI, CanBeParent{

    protected TextItemI item;

    @Override
    public SlideItemI getChild() {
        return item;
    }
    
    
    public TextDecorator() {
    }

    @Override
    public void append(PresentationItemI item) {
        if(item instanceof TextItemI){
            this.item = (TextItemI) item;
        }

        else{
            throw new IllegalArgumentException("item is not an instance of TextItem thus cannot be appended");
        }
        
    }

    public TextDecorator(TextItemI item) {
        this.item = item;
    }

    @Override
    public String getText(){
        return this.item.getText();
    }

    @Override
    public void setText(String text){
        this.item.setText(text);
    }
    
    @Override
    public int getFontSize(){
        return this.item.getFontSize();
    }

    @Override
    public void setFontSize(int fontSize){
        this.item.setFontSize(fontSize);
    }

    @Override
    public String getFontName() {
        return this.item.getFontName();
    }

    @Override
    public void setFontName(String fontName) {
        this.item.setFontName(fontName);
    }

    @Override
    public Font getFontObject(){
        return this.item.getFontObject();
    }

    @Override
    public void addAttribute(TextAttribute attribute, int value){
        this.item.addAttribute(attribute, value);
    }

    @Override
    public void removeAttribute(TextAttribute attribute){
        this.item.removeAttribute(attribute);
    }

    @Override
    public AttributedString getAttributedString(){
        return this.item.getAttributedString();
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer){
        return this.item.getBoundingBox(g, observer);
    }

    @Override
    public void draw(Graphics g, ImageObserver o){
        this.item.draw(g, o);
    }

    @Override
    public int getX(){
        return item.getX();
    }

    @Override
    public void setX(int x){
        this.item.setX(x);        
    }

    @Override
    public int getY(){
        return item.getY();
    }

    @Override
    public void setY(int y){
        this.item.setY(y);        
    }

    @Override
    public void updateCoords(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public TextDecorator clone(){
        TextItemI newItem = (TextItemI) item.clone();
        return new TextDecorator(newItem);
    }

    @Override
    public Color getColor() {
        return item.getColor();
    }

    @Override
    public void setColor(Color color) {
        item.setColor(color);
    }

    @Override
    public Element getSaveInfo(Document doc) {
        Element decorator = doc.createElement(this.getClass().getSimpleName());
        Element textItemE = this.item.getSaveInfo(doc);
        decorator.appendChild(textItemE);
        return decorator;
    }

    @Override
    public CreatorI getCreator(CanBeParent parent) {
        return new SlideItemTextCreator(parent);
    }

}