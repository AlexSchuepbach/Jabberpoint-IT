package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.Presentation;
import com.nhlstenden.jabberpoint.command.commands.Command;
import com.nhlstenden.jabberpoint.command.commands.ExitPresentationCommand;
import com.nhlstenden.jabberpoint.command.commands.NextSlideCommand;
import com.nhlstenden.jabberpoint.command.commands.PreviousSlideCommand;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {

	private final Command nextSlideCommand;
	private final Command previousSlideCommand;
	private final Command exitPresentationCommand;

	public KeyController(Presentation p) {
		nextSlideCommand = new NextSlideCommand(new Frame(), p);
		previousSlideCommand = new PreviousSlideCommand(new Frame(), p);
		exitPresentationCommand = new ExitPresentationCommand(new Frame(), p);
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_ENTER:
			case '+':
				nextSlideCommand.execute();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_LEFT:
			case '-':
				previousSlideCommand.execute();
				break;
			case 'q':
			case 'Q':
				exitPresentationCommand.execute();
				break; // Probably never reached!!
			default:
				break;
		}
	}
}
