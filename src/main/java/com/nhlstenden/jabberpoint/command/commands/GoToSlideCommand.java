package com.nhlstenden.jabberpoint.command.commands;

import javax.swing.*;

import com.nhlstenden.jabberpoint.presentationComponents.Presentation;

import java.awt.*;

public class GoToSlideCommand extends Command{

    private final String PAGENR = "Page number?";

    public GoToSlideCommand(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
        int pageNumber = Integer.parseInt(pageNumberStr);
        presentation.setSlideNumber(pageNumber - 1);
    }

}
