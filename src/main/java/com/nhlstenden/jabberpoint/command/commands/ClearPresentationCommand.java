package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

public class ClearPresentationCommand extends Command{

    public ClearPresentationCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        presentationInstance.clear();
        parent.repaint();
    }

}
