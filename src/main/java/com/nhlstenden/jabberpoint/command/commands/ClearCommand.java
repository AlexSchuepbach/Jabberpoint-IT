package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Presentation;

import java.awt.*;

public class ClearCommand extends Command{

    public ClearCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.clear();
        parent.repaint();
    }

}
