package com.nhlstenden.jabberpoint.Interfaces;

import org.w3c.dom.Element;

public interface CreatorI {

    public void apply();

    public abstract PresentationItemI loadFromElement(Element element);
}
