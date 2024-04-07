package com.nhlstenden.jabberpoint.builder;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.Interfaces.TextItem;
import com.nhlstenden.jabberpoint.presentationComponents.TextMoveAfterDrawInstance;

public class TextMoveAfterDrawBuilder extends TextDecoratorBuilder {

    TextMoveAfterDrawInstance decorator;

    public TextMoveAfterDrawBuilder(Parent parent) {
        super(parent);
        reset();
    }

    @Override
    public TextMoveAfterDrawInstance getItem() {
        return decorator;
    }

    public void setMovementRate(int movementRate){
        decorator.setMovementRate(movementRate);
    }

    public void appendTextItem(TextItem child){
        decorator.append(child);
    }

    @Override
    public PresentationItem loadFromElement(Element element) {
        this.decorator = new TextMoveAfterDrawInstance();
        int movementRate = Integer.valueOf(element.getAttribute("movementRate"));
        decorator.setMovementRate(movementRate);

        Element child = getFirstLegitimateChild(element);
        if(child != null){
            XMLAccessor.execLoaderFromElement(child, decorator);
        }
        else{
            System.err.println("TextMoveAfterDrawInstance does not have child item");
        }

        apply();
        return decorator;
        
    }

    private Element getFirstLegitimateChild(Element element){
        Node subNode = element.getFirstChild();
        while(subNode.getNextSibling() != null){
            if(subNode.getNodeType() == Node.ELEMENT_NODE){
                return (Element) subNode;
            }
            subNode = subNode.getNextSibling();
        }
        return null;
    }

    @Override
    public void apply() {
        parent.append(decorator);
    }

    @Override
    public void reset() {
        this.decorator = new TextMoveAfterDrawInstance();
    }

    @Override
    public void resetClone() {
        decorator = decorator.clone();
    }
    
}
