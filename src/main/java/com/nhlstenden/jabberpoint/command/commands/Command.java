package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

public abstract class Command {

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    protected Frame parent;
    protected Presentation presentation;

    public Command(Frame parent, Presentation presentation)
    {
        this.parent = parent;
        this.presentation = presentation;
    }

    public abstract void execute();

}
