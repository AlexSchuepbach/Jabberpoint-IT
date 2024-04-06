package com.nhlstenden.jabberpoint.builder;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import org.w3c.dom.Element;

public abstract class Builder{
    protected Parent parent;

    public abstract void apply();
    public abstract void reset();

    protected Builder(Parent parent){
        this.parent = parent;
    }

    public abstract PresentationItem loadFromElement(Element element);
}
