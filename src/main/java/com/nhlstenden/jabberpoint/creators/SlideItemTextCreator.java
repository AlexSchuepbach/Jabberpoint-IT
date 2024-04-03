package com.nhlstenden.jabberpoint.creators;

import java.awt.Color;
import java.awt.font.TextAttribute;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nhlstenden.jabberpoint.Interfaces.TextItemI;
import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.Interfaces.SlideItemI;
import com.nhlstenden.jabberpoint.presentationComponents.*;

public class SlideItemTextCreator extends Creator{

    private TextItemI textItem;

    public void reset(){
        this.textItem = new TextItem();
    }

    public void apply(){
        parent.append(textItem);
    }

    public SlideItemTextCreator(CanBeParent parent){
        super(parent);
        this.textItem = new TextItem();
        parent.append(textItem);
    }

    public void setText(String text){
        if(text != null){
            textItem.setText(text);
        }
    }

    public void setSize(int size){
        textItem.setFontSize(size);
    }

    public void setPosition(int x, int y){
        textItem.updateCoords(x, y);
    }

    public void setColor(Color color){
        if(color != null){
            textItem.setColor(color);
        }
    }
    
    public void setFont(String font){
        if(font != null){
            textItem.setFontName(font);
        }
    }

    public void underline(){
        this.textItem.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    }

    public void addAttribute(TextAttribute attribute, Integer value){

    }

    public void addMoveAfterDraw(int movementRate){
        this.textItem = new TextDecoratorMoveAfterDraw(textItem, movementRate);
    }

    public void addUpdateTimer(long delayBetweenUpdates){
        this.textItem = new TextDecoratorUpdateTimer(textItem, delayBetweenUpdates);
    }

    @Override
    public PresentationItemI loadFromElement(Element element) {
        
        String x = element.getElementsByTagName("x").item(0).getTextContent(); 
        String y = element.getElementsByTagName("y").item(0).getTextContent();
        setPosition(Integer.parseInt(x),Integer.parseInt(y));
        
        setText(element.getElementsByTagName("text").item(0).getTextContent()); 

        String sizeString = element.getElementsByTagName("fontSize").item(0).getTextContent();
        setSize(Integer.parseInt(sizeString)); 

        String colorString = element.getElementsByTagName("color").item(0).getTextContent();
        setColor(Color.getColor(colorString));

        Element attributes = (Element) element.getElementsByTagName("attributes").item(0);
        
        /*
        NodeList attributeList = attributes.getElementsByTagName("attribute");
        for (int i = 0; i < attributeList.getLength(); i++) {
            if (attributeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element attribute = (Element) attributeList.item(i);

                String classString = attribute.getElementsByTagName("name").item(0).getTextContent();
                String valueString = attribute.getElementsByTagName("value").item(0).getTextContent();

                try {
                    TextAttribute attrClass = Class.forName(classString);

                    int value = Integer.parseInt(valueString);

                    addAttribute(attrClass, value);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
         */
        apply();
        return textItem;

    }

}
