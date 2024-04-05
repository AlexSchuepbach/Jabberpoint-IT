package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Presentation;
import com.nhlstenden.jabberpoint.Slide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClearPresentationTest {

    Frame frame;
    Presentation presentation;
    Command clearPresentation;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new Presentation();
        clearPresentation = new ClearPresentationCommand(frame, presentation);

    }

    @Test
    void clearPresentation_emptyPresentation_shouldNotChangeSlideNumber()
    {
        presentation.clear();

        int testNumber = presentation.getSlideNumber();
        clearPresentation.execute();

        assertEquals(testNumber, presentation.getSlideNumber());
    }

    @Test
    void clearPresentation_emptyPresentation_showListSizeIsZero()
    {
        presentation.clear();

        clearPresentation.execute();

        assertEquals(0, presentation.getSize());
    }

    @Test
    void clearPresentation_singleSlide_slideNumberNegative1()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        clearPresentation.execute();

        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void clearPresentation_singleSlide_showListSizeIsZero()
    {
        presentation.append(new Slide());

        clearPresentation.execute();

        assertEquals(0, presentation.getSize());
    }

}