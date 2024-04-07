package com.nhlstenden.jabberpoint.builder;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;

public class PresentationBuilder extends Builder {

    private PresentationInstance presentationInstance;
    public PresentationBuilder(Parent parent) {
        super(parent);
        if(parent instanceof PresentationInstance){
            presentationInstance = (PresentationInstance) parent;
        }
        else
        {
            throw new IllegalArgumentException("presentation builder's parent must be presentation");
        }
    }

    @Override
    public PresentationInstance getItem() {
        return presentationInstance;
    }

    @Override
    public PresentationItem loadFromElement(Element element) {
        presentationInstance.setTitle(element.getAttribute("title"));
        
        if(element.getFirstChild() != null){
            Node node = element.getFirstChild();
            if (node.getNodeType() == Node.ELEMENT_NODE) { 
                Element subItem = (Element) node;
                XMLAccessor.execLoaderFromElement(subItem, presentationInstance);
            }
            while(node.getNextSibling() != null){
                node = node.getNextSibling();
                if (node.getNodeType() == Node.ELEMENT_NODE) { 
                    Element subItem = (Element) node;
                    XMLAccessor.execLoaderFromElement(subItem, presentationInstance);
                }
            }
        }

        return presentationInstance;
    }

    @Override
    public void apply() {
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("The presentation cannot be reset");
    }

    @Override
    public void resetClone() {
        throw new UnsupportedOperationException("The presentation cannot be reset");
    }
    
}
