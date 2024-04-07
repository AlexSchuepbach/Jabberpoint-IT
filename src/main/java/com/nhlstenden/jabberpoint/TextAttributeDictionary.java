package com.nhlstenden.jabberpoint;

import java.awt.font.TextAttribute;

public class TextAttributeDictionary {
    public static TextAttribute getAttributeFromString(String string){
        switch (string) {
            case "family":
                return TextAttribute.FAMILY;
            case "weight":
                return TextAttribute.WEIGHT;
            case "width":
                return TextAttribute.WIDTH;
            case "posture":
                return TextAttribute.POSTURE;
            case "size":
                return TextAttribute.SIZE;
            case "transform":
                return TextAttribute.TRANSFORM;
            case "superscript":
                return TextAttribute.SUPERSCRIPT;
            case "font":
                return TextAttribute.FONT;
            case "char_replacement":
                return TextAttribute.CHAR_REPLACEMENT;
            case "foreground":
                return TextAttribute.FOREGROUND;
            case "background":
                return TextAttribute.BACKGROUND;
            case "underline":
                return TextAttribute.UNDERLINE;
            case "strikethrough":
                    return TextAttribute.STRIKETHROUGH;
    
        default:
            throw new IllegalArgumentException("string is not an attribute");
        }
    }
}
