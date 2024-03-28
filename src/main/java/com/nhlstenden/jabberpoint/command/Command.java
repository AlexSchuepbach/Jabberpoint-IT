package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.Presentation;

import java.awt.*;

public abstract class Command {

    protected Frame parent;
    protected Presentation presentation;


    public Command(Frame parent, Presentation presentation)
    {
        this.parent = parent;
        this.presentation = presentation;
    }

    public abstract void execute();

}
