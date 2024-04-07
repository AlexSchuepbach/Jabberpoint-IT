package com.nhlstenden.jabberpoint;

import java.awt.Color;

import com.nhlstenden.jabberpoint.builder.BitmapItemBuilder;
import com.nhlstenden.jabberpoint.builder.TextBuilder;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;
import com.nhlstenden.jabberpoint.presentationComponents.SlideInstance;

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

	public void loadFile(PresentationInstance presentationInstance, String unusedFilename) {
		presentationInstance.setTitle("Demo Presentation");
		SlideInstance slideInstance;
		slideInstance = new SlideInstance();

		TextBuilder text = new TextBuilder(slideInstance);
		text.setText("beat 'em");
		text.setPosition(50, 200);
		text.apply();

		text.reset();
		text.setText("Submit");
		text.setPosition(400, 100);
		text.setColor(Color.MAGENTA);
		text.setFontSize(120);
		text.underline();
		text.addMoveAfterDraw(10);
		text.apply();

		BitmapItemBuilder imageCreator = new BitmapItemBuilder(slideInstance);
		imageCreator.setFilePath("C:\\Users\\joche\\Programs\\Projects\\Jabberpoint-IT\\1142956-313680023.png");
		imageCreator.apply();

		slideInstance.append("The Java Presentation Tool");
		slideInstance.append("Copyright (c) 1996-2000: Ian Darwin");
		slideInstance.append("Copyright (c) 2000-now:");
		slideInstance.append("Gert Florijn andn Sylvia Stuurman");
		slideInstance.append("Starting JabberPoint without a filename");
		slideInstance.append("shows this presentation");
		slideInstance.append("Navigate:");
		slideInstance.append("Next slide: PgDn or Enter");
		slideInstance.append("Previous slide: PgUp or up-arrow");
		slideInstance.append("Quit: q or Q");
		presentationInstance.append(slideInstance);

		slideInstance = new SlideInstance();
		slideInstance.append("Level 1");
		slideInstance.append("Level 2");
		slideInstance.append("Again level 1");
		slideInstance.append("Level 1 has style number 1");
		slideInstance.append("Level 2 has style number  2");
		slideInstance.append("This is how level 3 looks like");
		slideInstance.append("And this is level 4");
		presentationInstance.append(slideInstance);

		slideInstance = new SlideInstance();
		slideInstance.append("To open a new presentation,");
		slideInstance.append("use File->Open from the menu.");
		slideInstance.append(" ");
		slideInstance.append("This is the end of the presentation.");
		//slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		presentationInstance.append(slideInstance);
	}

	public void saveFile(PresentationInstance presentationInstance, String unusedFilename) {
		throw new IllegalStateException("Save As->Demo! called");
	}
}
