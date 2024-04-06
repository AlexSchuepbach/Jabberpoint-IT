package com.nhlstenden.jabberpoint.command.commands;

import javax.swing.*;

import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

import java.awt.*;

public class GoToSlideCommand extends Command{

    private final String PAGENR = "Page number?";

    public GoToSlideCommand(Frame parent, PresentationInstance presentationInstance)
    {
        super(parent, presentationInstance);
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
        int pageNumber = Integer.parseInt(pageNumberStr);
        presentationInstance.setSlideNumber(pageNumber - 1);
    }

}
