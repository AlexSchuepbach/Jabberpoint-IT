package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
