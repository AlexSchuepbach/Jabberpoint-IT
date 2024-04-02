package com.nhlstenden.jabberpoint;

import java.awt.Color;

/** A built in demo-presentation
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends Accessor {

	public void loadFile(Presentation presentation, String unusedFilename) {
		presentation.setTitle("Demo Presentation");
		Slide slide;
		slide = new Slide();

		SlideItemTextCreator text = new SlideItemTextCreator(slide);
		text.setText("beat 'em");
		text.setPosition(50, 200);
		text.apply();

		text.reset();
		text.setText("Submit");
		text.setPosition(400, 100);
		text.setColor(Color.MAGENTA);
		text.setSize(120);
		text.underline();
		text.addMoveAfterDraw(10);
		text.apply();

		slide.append("The Java Presentation Tool");
		slide.append("Copyright (c) 1996-2000: Ian Darwin");
		slide.append("Copyright (c) 2000-now:");
		slide.append("Gert Florijn andn Sylvia Stuurman");
		slide.append("Starting JabberPoint without a filename");
		slide.append("shows this presentation");
		slide.append("Navigate:");
		slide.append("Next slide: PgDn or Enter");
		slide.append("Previous slide: PgUp or up-arrow");
		slide.append("Quit: q or Q");
		presentation.append(slide);

		slide = new Slide();
		slide.append("Level 1");
		slide.append("Level 2");
		slide.append("Again level 1");
		slide.append("Level 1 has style number 1");
		slide.append("Level 2 has style number  2");
		slide.append("This is how level 3 looks like");
		slide.append("And this is level 4");
		presentation.append(slide);

		slide = new Slide();
		slide.append("To open a new presentation,");
		slide.append("use File->Open from the menu.");
		slide.append(" ");
		slide.append("This is the end of the presentation.");
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		presentation.append(slide);
	}

	public void saveFile(Presentation presentation, String unusedFilename) {
		throw new IllegalStateException("Save As->Demo! called");
	}
}
