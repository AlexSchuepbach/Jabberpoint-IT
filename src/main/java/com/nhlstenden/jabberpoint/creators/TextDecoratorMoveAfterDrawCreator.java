package com.nhlstenden.jabberpoint.creators;

import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.presentationComponents.TextDecoratorMoveAfterDraw;

public class TextDecoratorMoveAfterDrawCreator extends TextDecoratorCreator{

    TextDecoratorMoveAfterDraw decorator;

    protected TextDecoratorMoveAfterDrawCreator(CanBeParent parent) {
        super(parent);
        //TODO Auto-generated constructor stub
    }

    @Override
    public PresentationItemI loadFromElement(Element element) {
        this.decorator = new TextDecoratorMoveAfterDraw();
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
