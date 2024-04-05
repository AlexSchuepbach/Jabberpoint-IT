package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.Presentation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuControllerTest {

    Frame frame;
    Presentation presentation;
    MenuController menu;

    @BeforeEach
    void setup()
    {

        frame = new Frame();
        presentation = new Presentation();

        menu = new MenuController(frame, presentation);

    }



}
