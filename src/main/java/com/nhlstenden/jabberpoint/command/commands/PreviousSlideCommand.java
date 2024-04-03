package com.nhlstenden.jabberpoint.command.commands;

import java.awt.*;

import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

public class PreviousSlideCommand extends Command{

    public PreviousSlideCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.prevSlide();
    }

}
