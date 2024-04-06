package com.nhlstenden.jabberpoint.builder;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.presentationComponents.BitmapInstanceInstance;
import org.w3c.dom.Element;

public class BitmapItemBuilder extends Builder {

    protected BitmapInstanceInstance bitmap;
    public BitmapItemBuilder(Parent parent) {
        super(parent);
        bitmap = new BitmapInstanceInstance();
    }

    public void setFilePath(String filePath){
        if(filePath != null){
            this.bitmap.setImageLocation(filePath);
        }
    }

    public void bufferImage(){
        this.bitmap.bufferImage();
    }

    @Override
    public void apply() {
        this.parent.append(bitmap);
        bufferImage();
    }

    public void setPosition(int x, int y){
        bitmap.updateCoords(x, y);
    }

    @Override
    public PresentationItem loadFromElement(Element element) {
        String x = element.getElementsByTagName("x").item(0).getTextContent();
        String y = element.getElementsByTagName("y").item(0).getTextContent();
        setPosition(Integer.parseInt(x),Integer.parseInt(y));

        Element filePathE = (Element) element.getElementsByTagName("filePath").item(0);
        String filePath = filePathE.getTextContent();
        setFilePath(filePath);

        apply();
        return bitmap;
    }

    @Override
    public void reset() {
        bitmap = new BitmapInstanceInstance();
    }
}
