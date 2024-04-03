package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.Interfaces.SlideItemI;
import com.nhlstenden.jabberpoint.creators.SlideCreator;

/** <p>A slide. This class has a drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide implements PresentationItemI, CanBeParent{
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	protected ArrayList<PresentationItemI> items; 

	public Slide() {
		items = new ArrayList<PresentationItemI>();
	}

	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}

	// Add a slide item
	public void append(PresentationItemI item) {
		items.add(item);
	}

	// Create TextItem of String, and add the TextItem 
	public void append(String message) {
		append(new TextItem(message));
	}

	// give the  SlideItem
	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.get(number);
	}

	// give all SlideItems in a Vector
	public ArrayList<PresentationItemI> getSlideItems() {
		return items;
	}

	// give the size of the Slide
	public int getItemsLength() {
		return items.size();
	}

	// draw the slide
	public void draw(Graphics g, ImageObserver view) {
		for (PresentationItemI slideItem : items) {
			slideItem.draw(g, view);
		}
	}

	public Element getSaveInfo(Document doc){
		Element slide = doc.createElement(this.getClass().getSimpleName());
		slide.setAttribute("width", String.valueOf(this.WIDTH));
		slide.setAttribute("height", String.valueOf(this.HEIGHT));
		for (PresentationItemI item : items) {
			Element itemE = item.getSaveInfo(doc);
			slide.appendChild(itemE);
		}
		return slide;
	}

	@Override
	public CreatorI getCreator(CanBeParent parent) {
		return new SlideCreator(parent);
	}

}
