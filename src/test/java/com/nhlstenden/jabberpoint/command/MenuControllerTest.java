package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuControllerTest {

    Frame frame;
    PresentationInstance presentation;
    MenuController menu;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new PresentationInstance();

        menu = new MenuController(frame, presentation);

    }

    @Test
    void mkMenuItem_inputOPEN_shouldReturnMenuItemCorrectName()
    {

        String open = "Open";

        assertEquals(open, menu.mkMenuItem(open).getLabel());

    }

}
