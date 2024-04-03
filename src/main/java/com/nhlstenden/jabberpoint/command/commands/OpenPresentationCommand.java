package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Accessor;
import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenPresentationCommand extends Command{

    public OpenPresentationCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            String TESTFILE = "test.xml";
            xmlAccessor.loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }

}
