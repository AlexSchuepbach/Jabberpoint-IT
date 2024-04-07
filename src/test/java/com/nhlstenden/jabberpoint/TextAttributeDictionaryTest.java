package com.nhlstenden.jabberpoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.font.TextAttribute;

import static org.junit.jupiter.api.Assertions.*;

public class TextAttributeDictionaryTest {

    TextAttributeDictionary textAttDict;

    @BeforeEach
    void setup()
    {
        textAttDict = new TextAttributeDictionary();
    }

    @Test
    void getAttributeFromString_emptyString_shouldThrowIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            textAttDict.getAttributeFromString("");
        });
    }

    @Test
    void getAttributeFromString_family_shouldReturnFamilyAttribute()
    {
        assertEquals(TextAttribute.FAMILY, textAttDict.getAttributeFromString("family"));
    }

    @Test
    void getAttributeFromString_weight_shouldReturnWeightAttribute()
    {
        assertEquals(TextAttribute.WEIGHT, textAttDict.getAttributeFromString("weight"));
    }

    @Test
    void getAttributeFromString_width_shouldReturnWidthAttribute()
    {
        assertEquals(TextAttribute.WIDTH, textAttDict.getAttributeFromString("width"));
    }

    @Test
    void getAttributeFromString_posture_shouldReturnPostureAttribute()
    {
        assertEquals(TextAttribute.POSTURE, textAttDict.getAttributeFromString("posture"));
    }

    @Test
    void getAttributeFromString_size_shouldReturnSizeAttribute()
    {
        assertEquals(TextAttribute.SIZE, textAttDict.getAttributeFromString("size"));
    }

    @Test
    void getAttributeFromString_transform_shouldReturnTransformAttribute()
    {
        assertEquals(TextAttribute.TRANSFORM, textAttDict.getAttributeFromString("transform"));
    }

    @Test
    void getAttributeFromString_font_shouldReturnFontAttribute()
    {
        assertEquals(TextAttribute.FONT, textAttDict.getAttributeFromString("font"));
    }

    @Test
    void getAttributeFromString_superscript_shouldReturnSuperscriptAttribute()
    {
        assertEquals(TextAttribute.SUPERSCRIPT, textAttDict.getAttributeFromString("superscript"));
    }

    @Test
    void getAttributeFromString_charReplacement_shouldReturnCharReplacementAttribute()
    {
        assertEquals(TextAttribute.CHAR_REPLACEMENT, textAttDict.getAttributeFromString("char_replacement"));
    }

    @Test
    void getAttributeFromString_foreground_shouldReturnForegroundAttribute()
    {
        assertEquals(TextAttribute.FOREGROUND, textAttDict.getAttributeFromString("foreground"));
    }

    @Test
    void getAttributeFromString_background_shouldReturnBackgroundAttribute()
    {
        assertEquals(TextAttribute.BACKGROUND, textAttDict.getAttributeFromString("background"));
    }

    @Test
    void getAttributeFromString_strikethrough_shouldReturnStrikethroughAttribute()
    {
        assertEquals(TextAttribute.STRIKETHROUGH, textAttDict.getAttributeFromString("strikethrough"));
    }

}
