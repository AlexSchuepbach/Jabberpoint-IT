package com.nhlstenden.jabberpoint;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DemoPresentationTest {

    Accessor demo;
    PresentationInstance presentation;
    String fileName;

    @BeforeEach
    void setup()
    {

        demo = new DemoPresentation();

        presentation = new PresentationInstance();
        fileName = "Unused Filename";

    }

    @Test
    void saveFile_callMethod_shouldThrowIllegalStateException()
    {

        assertThrows(IllegalStateException.class, () -> {
            demo.saveFile(presentation, fileName);
        });

    }

    @Test
    void loadFile_callMethod_shouldHaveTitleDemo() throws IOException {

        demo.loadFile(presentation, fileName);

        String title = presentation.getTitle();

        assertEquals("Demo Presentation", title);

    }

}
