package com.nhlstenden.jabberpoint.builder;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.presentationComponents.SlideInstance;


public class SlideBuilder extends Builder {

    private SlideInstance slideInstance;

    public SlideBuilder(Parent parent){
        super(parent);
        reset();
    }

    public PresentationItem loadFromElement(Element element){

        if(element.getFirstChild() != null){
            Node node = element.getFirstChild();
            if (node.getNodeType() == Node.ELEMENT_NODE) { 
                Element subItem = (Element) node;
                XMLAccessor.execLoaderFromElement(subItem, slideInstance);
            }
            while(node.getNextSibling() != null){
                node = node.getNextSibling();
                if (node.getNodeType() == Node.ELEMENT_NODE) { 
                    Element subItem = (Element) node;
                    XMLAccessor.execLoaderFromElement(subItem, slideInstance);
                }
            }
        }

        apply();
        return slideInstance;
    }

    @Override
    public void apply() {
        parent.append(slideInstance);
    }

    @Override
    public void reset() {
        this.slideInstance = new SlideInstance();
    }
}