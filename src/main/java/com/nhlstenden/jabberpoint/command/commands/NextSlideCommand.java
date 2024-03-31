package com.nhlstenden.jabberpoint.command.commands;

import com.nhlstenden.jabberpoint.Presentation;

import java.awt.*;

public class NextSlideCommand extends Command{

    public NextSlideCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        presentation.nextSlide();
    }

}
