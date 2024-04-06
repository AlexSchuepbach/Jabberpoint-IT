package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

public class PreviousSlideCommand extends Command{

    public PreviousSlideCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        presentationInstance.prevSlide();
    }

}
