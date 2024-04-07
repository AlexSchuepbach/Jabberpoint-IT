package com.nhlstenden.jabberpoint;

import com.nhlstenden.jabberpoint.presentationComponents.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SlideViewerComponentTest {

    JFrame frame;
    PresentationInstance presentation;
    SlideViewerComponent svc;

    @BeforeEach
    void setup()
    {

        frame = new JFrame();
        presentation = new PresentationInstance();

        svc = new SlideViewerComponent(presentation, frame);

    }

    @Test
    void getPreferredSize_default_shouldReturnDimension()
    {

        Dimension dim = svc.getPreferredSize();

        assertEquals(800, dim.height);
        assertEquals(1200, dim.width);

    }

    @Test
    void paintComponent_default_shouldDraw()
    {

        Graphics g = Mockito.mock(Graphics.class);
        svc.paintComponent(g);

    }

    @Test
    void update_emptyPresentationSlide_shouldWork()
    {

        SlideInstance slide = new SlideInstance();
        svc.update(presentation, slide);

    }

    @Test
    void update_nullSlide_shouldWork()
    {

        SlideInstance slide = new SlideInstance();
        svc.update(presentation, null);

    }

}
