package com.nhlstenden.jabberpoint.presentationComponents;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;

import static org.junit.jupiter.api.Assertions.*;

public class TextInstanceTest {

    Graphics graphics;
    ImageObserver imageObserver;

    String testString;
    TextInstance textInstance;

    @BeforeEach
    void setup() {

        graphics = Mockito.mock(Graphics2D.class);
        imageObserver = Mockito.mock(ImageObserver.class);

        testString = "Test123";
        textInstance = new TextInstance();

    }

    @Test
    void getText_emptyConstructor_shouldReturnNoTextGiven() {

        textInstance = new TextInstance();

        assertEquals("No Text Given", textInstance.getText());

    }

    @Test
    void getText_emptyStringInConstructor_shouldReturnEmptyString() {

        textInstance = new TextInstance("");

        assertEquals("", textInstance.getText());

    }

    @Test
    void getAttributedString_emptyConstructor_shouldReturnNoTextGiven()
    {
        textInstance = new TextInstance();
        AttributedString attributedString = textInstance.getAttributedString();

        AttributedCharacterIterator it = attributedString.getIterator();
        StringBuilder stringBuilder = new StringBuilder();

        char ch = it.current();
        while( ch != CharacterIterator.DONE)
        {
            stringBuilder.append(ch);
            ch = it.next();
        }

        String rawString = stringBuilder.toString();

        assertEquals("No Text Given", rawString);
    }

}
