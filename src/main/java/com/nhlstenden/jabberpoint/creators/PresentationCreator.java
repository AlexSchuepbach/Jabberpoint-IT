package com.nhlstenden.jabberpoint.creators;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

public class PresentationCreator extends Creator{

    private Presentation presentation;
    public PresentationCreator(CanBeParent parent) {
        super(parent);
        if(parent instanceof Presentation){
            presentation = (Presentation) parent;
        }
        else
        {
            throw new IllegalArgumentException("presentation builder's parent must be presentation");
        }
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    @Override
    public PresentationItemI loadFromElement(Element element) {
        presentation.setTitle(element.getAttribute("title"));
        
        if(element.getFirstChild() != null){
            Node node = element.getFirstChild();
            if (node.getNodeType() == Node.ELEMENT_NODE) { 
                Element subItem = (Element) node;
                XMLAccessor.execLoaderFromElement(subItem, presentation);
            }
            while(node.getNextSibling() != null){
                node = node.getNextSibling();
                if (node.getNodeType() == Node.ELEMENT_NODE) { 
                    Element subItem = (Element) node;
                    XMLAccessor.execLoaderFromElement(subItem, presentation);
                }
            }
        }

        return presentation;
    }

    @Override
    public void apply() {
    }
    
}
