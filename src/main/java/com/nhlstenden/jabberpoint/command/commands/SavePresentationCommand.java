package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Accessor;
import com.nhlstenden.jabberpoint.Presentation;
import com.nhlstenden.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SavePresentationCommand extends Command{

    public SavePresentationCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            String SAVEFILE = "dump.xml";
            xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }

}
