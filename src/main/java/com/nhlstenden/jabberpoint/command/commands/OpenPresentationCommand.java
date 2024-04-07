package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Accessor;
import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenPresentationCommand extends Command{

    public OpenPresentationCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        presentationInstance.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            String TESTFILE = "test.xml";
            xmlAccessor.loadFile(presentationInstance, TESTFILE);
            presentationInstance.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }

}
