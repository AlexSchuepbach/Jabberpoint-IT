package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class NextSlideTest {

    Frame frame;
    PresentationInstance presentation;
    Command nextSlide;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new PresentationInstance();
        nextSlide = new NextSlideCommand(frame, presentation);

    }

    @Test
    void nextSlide_emptyPresentation_shouldNotChangeSlideNumber()
    {
        presentation.clear();

        nextSlide.execute();

        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_singleSlide_shouldNotChangeSlideNumber()
    {
        presentation.append(new SlideInstance());

        nextSlide.execute();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_twoSlides_shouldIncreaseBy1()
    {
        presentation.clear();
        presentation.append(new SlideInstance());
        presentation.append(new SlideInstance());

        nextSlide.execute();

        assertEquals(0, presentation.getSlideNumber());

        nextSlide.execute();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_endOfPresentation_shouldNotIncrease()
    {
        presentation.clear();
        presentation.append(new SlideInstance());
        presentation.append(new SlideInstance());
        presentation.setSlideNumber(1);

        nextSlide.execute();

        assertEquals(1, presentation.getSlideNumber());

    }

}
