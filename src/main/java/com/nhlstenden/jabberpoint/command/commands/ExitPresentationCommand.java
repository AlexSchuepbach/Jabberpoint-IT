package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

public class ExitPresentationCommand extends Command{

    public ExitPresentationCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.exit(0);
    }

}
