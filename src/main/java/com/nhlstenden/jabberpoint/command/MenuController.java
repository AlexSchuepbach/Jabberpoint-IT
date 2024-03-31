package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.AboutBox;
import com.nhlstenden.jabberpoint.Presentation;
import com.nhlstenden.jabberpoint.command.commands.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		MenuItem menuItem;
		Menu fileMenu = new Menu(FILE);

		final Command openPresentationCommand = new OpenPresentationCommand(parent, presentation);
		final Command clearPresentationCommand = new ClearCommand(parent, presentation);
		final Command savePresentationCommand = new SavePresentationCommand(parent, presentation);
		final Command exitPresentationCommand = new ExitPresentationCommand(parent, presentation);
		final Command nextSlideCommand = new NextSlideCommand(parent, presentation);
		final Command previousSlideCommand = new PreviousSlideCommand(parent, presentation);
		final Command goToSlideCommand = new GoToSlideCommand(parent, presentation);
		final Command displayAboutBoxCommand = new DisplayAboutBoxCommand(parent, presentation);

		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				openPresentationCommand.execute();
			}
		} );

		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				clearPresentationCommand.execute();
			}
		});

		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePresentationCommand.execute();
			}
		});

		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				exitPresentationCommand.execute();
			}
		});
		add(fileMenu);

		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				nextSlideCommand.execute();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				previousSlideCommand.execute();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				goToSlideCommand.execute();
			}
		});
		add(viewMenu);

		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				displayAboutBoxCommand.execute();
			}
		});
		setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).

	}

// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
