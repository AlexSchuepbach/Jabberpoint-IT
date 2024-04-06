package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OpenPresentationTest {

    Frame frame;
    PresentationInstance presentation;
    Command openPresentation;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new PresentationInstance();
        openPresentation = new OpenPresentationCommand(frame, presentation);

    }

    @Test
    void openPresentation_emptyPresentation_shouldNotChangeSlideNumber()
    {
        presentation.clear();

        openPresentation.execute();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void openPresentation_singleSlide_shouldNotChangeSlideNumber()
    {
        presentation.setSlideNumber(0);

        openPresentation.execute();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void openPresentation_twoSlides_shouldReduceBy1()
    {
        presentation.setSlideNumber(2);

        openPresentation.execute();

        assertEquals(0, presentation.getSlideNumber());

    }

}
