package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.Accessor;
import com.nhlstenden.jabberpoint.Presentation;
import com.nhlstenden.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NewPresentationCommand extends Command{

    protected static final String TESTFILE = "test.xml";

    public NewPresentationCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }

}
