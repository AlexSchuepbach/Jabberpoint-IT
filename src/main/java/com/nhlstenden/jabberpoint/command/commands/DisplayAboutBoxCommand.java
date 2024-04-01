package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.AboutBox;
import com.nhlstenden.jabberpoint.Presentation;

import java.awt.*;

public class DisplayAboutBoxCommand extends Command{

    public DisplayAboutBoxCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        AboutBox.show(parent);
    }

}
