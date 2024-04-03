package com.nhlstenden.jabberpoint.creators;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.presentationComponents.Slide;


public class SlideCreator extends Creator{

    private Slide slide;

    public SlideCreator(CanBeParent parent){
        super(parent);
        reset();
    }

    public PresentationItemI loadFromElement(Element element){

        if(element.getFirstChild() != null){
            Node node = element.getFirstChild();
            if (node.getNodeType() == Node.ELEMENT_NODE) { 
                Element subItem = (Element) node;
                XMLAccessor.execLoaderFromElement(subItem, slide);
            }
            while(node.getNextSibling() != null){
                node = node.getNextSibling();
                if (node.getNodeType() == Node.ELEMENT_NODE) { 
                    Element subItem = (Element) node;
                    XMLAccessor.execLoaderFromElement(subItem, slide);
                }
            }
        }

        apply();
        return slide;
    }

    @Override
    public void apply() {
        parent.append(slide);
    }

    @Override
    public void reset() {
        this.slide = new Slide();
    }
}