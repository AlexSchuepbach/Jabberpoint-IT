package com.nhlstenden.jabberpoint.Interfaces;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import com.nhlstenden.jabberpoint.builder.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface PresentationItem extends Prototype{

    public void draw(Graphics g, ImageObserver observer);

    public Builder getBuilder(Parent parent);

    public Element getXMLSaveElement(Document doc);
}
