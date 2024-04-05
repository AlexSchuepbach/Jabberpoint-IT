package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

public abstract class Command {

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    protected Frame parent;
    protected PresentationInstance presentationInstance;

    public Command(Frame parent, PresentationInstance presentationInstance)
    {
        this.parent = parent;
        this.presentationInstance = presentationInstance;
    }

    public abstract void execute();

}
