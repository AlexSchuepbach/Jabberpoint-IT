package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.AboutBox;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

import java.awt.*;

public class DisplayAboutBoxCommand extends Command{

    public DisplayAboutBoxCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        AboutBox.show(parent);
    }

}
