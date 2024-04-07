package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

public class ExitPresentationCommand extends Command{

    public ExitPresentationCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        presentationInstance.exit(0);
    }

}
