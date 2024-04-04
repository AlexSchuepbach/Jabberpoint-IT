package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Presentation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PreviousSlideTest {

    Frame frame;
    Presentation presentation;
    Command previousSlide;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new Presentation();
        previousSlide = new PreviousSlideCommand(frame, presentation);

    }

    @Test
    void something()
    {

    }

}
