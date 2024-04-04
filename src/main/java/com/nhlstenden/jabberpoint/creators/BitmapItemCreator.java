package com.nhlstenden.jabberpoint.creators;

import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.presentationComponents.BitmapItem;
import org.w3c.dom.Element;

public class BitmapItemCreator extends Creator{

    protected BitmapItem bitmap;
    public BitmapItemCreator(CanBeParent parent) {
        super(parent);
        bitmap = new BitmapItem();
    }

    public void setFilePath(String filePath){
        if(filePath != null){
            this.bitmap.setImageName(filePath);
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
    public PresentationItemI loadFromElement(Element element) {
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
        bitmap = new BitmapItem();
    }
}
