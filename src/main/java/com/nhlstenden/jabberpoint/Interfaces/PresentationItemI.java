package com.nhlstenden.jabberpoint.Interfaces;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface PresentationItemI {

    public void draw(Graphics g, ImageObserver observer);

    public CreatorI getCreator(CanBeParent parent);

    public Element getSaveInfo(Document doc);
}
