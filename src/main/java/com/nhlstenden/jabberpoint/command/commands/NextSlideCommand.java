package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

public class NextSlideCommand extends Command{

    public NextSlideCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        presentationInstance.nextSlide();
    }

}
