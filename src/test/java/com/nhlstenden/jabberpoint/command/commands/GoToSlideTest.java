package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GoToSlideTest {

    Frame frame;
    PresentationInstance presentation;
    Command goToSlide;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new PresentationInstance();
        goToSlide = new GoToSlideCommand(frame, presentation);

    }

    @Test
    void nextSlide_emptyPresentation_shouldNotChangeSlideNumber()
    {
        presentation.clear();


        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_singleSlide_shouldNotChangeSlideNumber()
    {
        presentation.append(new SlideInstance());


        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_twoSlides_shouldIncreaseBy1()
    {
        presentation.clear();
        presentation.append(new SlideInstance());
        presentation.append(new SlideInstance());


        assertEquals(-1, presentation.getSlideNumber());


        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_endOfPresentation_shouldNotIncrease()
    {
        presentation.clear();
        presentation.append(new SlideInstance());
        presentation.append(new SlideInstance());
        presentation.setSlideNumber(1);

        assertEquals(1, presentation.getSlideNumber());

    }

}
