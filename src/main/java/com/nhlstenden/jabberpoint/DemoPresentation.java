package com.nhlstenden.jabberpoint;

import java.awt.Color;
import java.awt.font.TextAttribute;

import com.nhlstenden.jabberpoint.Interfaces.Slide;
import com.nhlstenden.jabberpoint.builder.BitmapItemBuilder;
import com.nhlstenden.jabberpoint.builder.SlideBuilder;
import com.nhlstenden.jabberpoint.builder.TextBuilder;
import com.nhlstenden.jabberpoint.builder.TextMoveAfterDrawBuilder;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;

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
		SlideBuilder slideBuilder = new SlideBuilder(presentationInstance);
		
		Slide slide = slideBuilder.getItem();

		TextBuilder text = new TextBuilder(slide);

		text.setText("The Java Presentation tool");
		text.setPosition(100, 0);
		text.setFontSize(120);
		text.apply();

		text.reset();
		text.setText("Copyright (c) 1996-2000: Ian Darwin");
		text.setFontSize(15);
		text.setPosition(Slide.WIDTH-400, Slide.HEIGHT-200);
		text.apply();

		text.resetClone();
		text.setText("Copyright (c) 2000-now:");
		text.movePosition(0, 30);
		text.apply();

		text.resetClone();
		text.setText("Gert Florijn andn Sylvia Stuurman");
		text.movePosition(0, 30);
		text.apply();

		text.reset();
		text.setText("Navigate:");
		text.setPosition(30, Slide.HEIGHT-200);
		text.setFontSize(20);
		text.apply();

		text.resetClone();
		text.setText("Next slide: PgDn or Enter");
		text.movePosition(150, 0);
		text.apply();

		text.resetClone();
		text.setText("Previous slide: PgUp or up-arrow");
		text.movePosition(0, 30);
		text.apply();

		text.resetClone();
		text.setText("Quit: q or Q");
		text.movePosition(0, 30);
		text.apply();
		
		slideBuilder.apply();

		slideBuilder.reset();
		slide = slideBuilder.getItem();

		text.changeParent(slide);
		text.reset();
		
		text.setText("Plenty of whacky styles to explore!!");
		text.setFont("Comic Sans MS");
		text.setFontSize(160);
		text.setPosition(50, 0);
		text.setColor(new Color(255, 150, 150));
		text.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		text.apply();

		slideBuilder.apply();
		slideBuilder.reset();

		slide = slideBuilder.getItem();
		text.changeParent(slide);

		text.reset();
		text.setText("features");
		text.setFontSize(60);
		text.setPosition(500, 100);
		text.apply();

		text.reset();
		text.setText("Ability to incorporate java.awt.font.TextAttribute");
		text.setPosition(10, 300);
		text.setFontSize(25);
		text.apply();

		text.resetClone();
		text.setText("implements the builder, (arguably) factory, Prototype, Command, Decorator and Composite patterns");
		text.setFontSize(22);;
		text.movePosition(0, 50);
		text.apply();

		text.resetClone();
		text.setText("(or \"methods\" if you're weird)");
		text.movePosition(0, 23);
		text.setFontSize(10);
		text.apply();

		text.resetClone();
		text.setText("Everything already has an example implementation!");
		text.setFontSize(25);
		text.movePosition(0, 25);
		text.apply();
	
		slideBuilder.apply();
		slideBuilder.resetClone();

		slide = slideBuilder.getItem();
		text.changeParent(slide);

		text.resetClone();
		text.setText("Prototype!!!!");
		text.setFontSize(90);
		text.movePosition(200, 100);
		text.apply();
		
		slideBuilder.apply();
		slideBuilder.reset();

		slide = slideBuilder.getItem();
		text.changeParent(slide);

		text.reset();
		text.setText("Decorator example");
		text.setFontSize(60);
		text.setPosition(500, 100);
		text.apply();

		text.reset();
		text.setText("This is using the TextMoveAfterDraw Decorator");
		text.setPosition(10, 300);
		text.setFontSize(25);
		text.apply();

		text.resetClone();
		text.setText("bob is here, please wave to him by dragging the side of the program");
		text.setFontSize(25);
		text.movePosition(0, 55);
		text.apply();


		text.resetClone();
		text.setText("BOB");
		text.setFontSize(60);
		text.movePosition(0, 200);

		TextMoveAfterDrawBuilder movementBuilder = new TextMoveAfterDrawBuilder(slide);
		movementBuilder.appendTextItem(text.getItem());
		movementBuilder.setMovementRate(10);
		movementBuilder.apply();
		
		slideBuilder.apply();
		slideBuilder.reset();

		slide = slideBuilder.getItem();

		BitmapItemBuilder bitmapItemBuilder = new BitmapItemBuilder(slide);
		bitmapItemBuilder.setFilePath("end.png");
		bitmapItemBuilder.setPosition(200, 500);
		bitmapItemBuilder.apply();

		text.changeParent(slide);
		
		text.reset();
		text.setText("bob was a little shy ._.");
		text.setPosition(500, 300);
		text.apply();

		slideBuilder.apply();

	}

	public void saveFile(PresentationInstance presentationInstance, String unusedFilename) {
		throw new IllegalStateException("Save As->Demo! called");
	}
}
