package com.nhlstenden.jabberpoint.builder;

import java.awt.Color;
import java.awt.IllegalComponentStateException;
import java.awt.font.TextAttribute;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nhlstenden.jabberpoint.Interfaces.TextItem;
import com.nhlstenden.jabberpoint.TextAttributeDictionary;
import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.presentationComponents.*;

public class TextBuilder extends Builder {

    private TextItem textItem;

    private final static String attributeRegexReplacementString = "(?:.*\\(|\\))";
    
    public void reset(){
        this.textItem = new TextInstance();
    }

    public void apply(){
        parent.append(textItem);
    }

    public TextBuilder(Parent parent){
        super(parent);
        this.textItem = new TextInstance();
    }

    public void setText(String text){
        if(text != null){
            textItem.setText(text);
        }
    }

    public void setFontSize(int size){
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
        this.textItem.addAttribute(attribute, value);
    }

    public void addMoveAfterDraw(int movementRate){
        this.textItem = new TextMoveAfterDrawInstance(textItem, movementRate);
    }

    @Override
    public PresentationItem loadFromElement(Element element) {
        
        int x = getXPositionFromElement(element);
        int y = getYPositionFromElement(element);
        setPosition(x, y);
        
        setText(getTextContentFromElement(element)); 

        setFontSize(getFontSizeFromElement(element));

        setColor(getColorFromElement(element));

        loadAttributesFromElement(element);
        
        apply();
        return textItem;

    }
    
    private int getXPositionFromElement(Element element){
        String x = element.getElementsByTagName("x").item(0).getTextContent();
        if(isStringNumeric(x)){
            return Integer.parseInt(x);
        }
        else
        {
            throw new IllegalComponentStateException("x value of text item is non numeric");
        }
    }

    private int getYPositionFromElement(Element element){
        String y = element.getElementsByTagName("y").item(0).getTextContent();
        if(isStringNumeric(y)){
            return Integer.parseInt(y);
        }
        else
        {
            throw new IllegalComponentStateException("y value of text item is non numeric");
        }
    }

    private String getTextContentFromElement(Element element){
        return element.getElementsByTagName("text").item(0).getTextContent();
    }

    private int getFontSizeFromElement(Element element){
        String size = element.getElementsByTagName("fontSize").item(0).getTextContent();
        if(isStringNumeric(size)){
            return Integer.parseInt(size);
        }
        else
        {
            throw new IllegalComponentStateException("fontsize value of text item is non numeric");
        }
    }

    private Color getColorFromElement(Element element){
        String color = element.getElementsByTagName("color").item(0).getTextContent();
        return new Color(Integer.parseInt(color));
    }

    private boolean isStringNumeric(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

    private void loadAttributesFromElement(Element element){
        Element attributes = (Element) element.getElementsByTagName("attributes").item(0);
        NodeList attributeList = attributes.getElementsByTagName("attribute");
        for (int i = 0; i < attributeList.getLength(); i++) {
            if (attributeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element attribute = (Element) attributeList.item(i);

                String rawClassString = attribute.getElementsByTagName("name").item(0).getTextContent();
                String valueString = attribute.getElementsByTagName("value").item(0).getTextContent();

                String classString = rawClassString.replaceAll(attributeRegexReplacementString, "");

                TextAttribute attrClass = TextAttributeDictionary.getAttributeFromString(classString);
                int value = Integer.parseInt(valueString);

                addAttribute(attrClass, value);
            }
        }
    }

}
