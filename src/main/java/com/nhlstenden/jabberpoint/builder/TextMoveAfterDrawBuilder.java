package com.nhlstenden.jabberpoint.builder;

import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.presentationComponents.TextMoveAfterDrawInstance;

public class TextMoveAfterDrawBuilder extends TextDecoratorBuilder {

    TextMoveAfterDrawInstance decorator;

    protected TextMoveAfterDrawBuilder(Parent parent) {
        super(parent);
        //TODO Auto-generated constructor stub
    }

    @Override
    public PresentationItem loadFromElement(Element element) {
        this.decorator = new TextMoveAfterDrawInstance();
        int movementRate = Integer.valueOf(element.getAttribute("movementRate"));
        decorator.setMovementRate(movementRate);
        Element subItem = (Element) element.getFirstChild();
        XMLAccessor.execLoaderFromElement(subItem, decorator);
        apply();
        return decorator;
    }

    @Override
    public void apply() {
        parent.append(decorator);
    }
    
}
