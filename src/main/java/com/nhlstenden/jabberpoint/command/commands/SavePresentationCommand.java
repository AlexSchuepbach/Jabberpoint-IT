package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Accessor;
import com.nhlstenden.jabberpoint.XMLAccessor;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import java.awt.*;
import java.io.IOException;

public class SavePresentationCommand extends Command{

    public SavePresentationCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            String SAVEFILE = "dump.xml";
            xmlAccessor.saveFile(presentationInstance, SAVEFILE);
        } catch (IOException | ParserConfigurationException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }

}
