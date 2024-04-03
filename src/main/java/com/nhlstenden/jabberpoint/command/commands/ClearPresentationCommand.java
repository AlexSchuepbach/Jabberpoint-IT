package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

public class ClearPresentationCommand extends Command{

    public ClearPresentationCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.clear();
        parent.repaint();
    }

}
