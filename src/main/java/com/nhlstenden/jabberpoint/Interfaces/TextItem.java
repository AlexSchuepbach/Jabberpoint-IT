package com.nhlstenden.jabberpoint.Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedString;

public interface TextItem extends SlideItem {

    public String getText();

    public void setText(String text);

    public Color getColor();
    public void setColor(Color color);

    public int getFontSize();
    public void setFontSize(int fontSize);
    public String getFontName();
    public void setFontName(String fontName);
    public Font getFontObject();
    public void addAttribute(TextAttribute attribute, int value);
    public void removeAttribute(TextAttribute attribute);
    public AttributedString getAttributedString();
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer);
}
