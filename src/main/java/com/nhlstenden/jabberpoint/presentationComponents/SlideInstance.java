package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import com.nhlstenden.jabberpoint.builder.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.builder.SlideBuilder;

/** <p>A slide. This class has a drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideInstance implements PresentationItem, Parent {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	protected ArrayList<PresentationItem> items;

	public SlideInstance() {
		items = new ArrayList<PresentationItem>();
	}

	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}

	// Add a slide item
	public void append(PresentationItem item) {
		items.add(item);
	}

	// Create TextItem of String, and add the TextItem 
	public void append(String message) {
		append(new TextInstance(message));
	}

	// give the  SlideItem
	public SlideItemInstance getSlideItem(int number) {
		return (SlideItemInstance)items.get(number);
	}

	// give all SlideItems in a Vector
	public ArrayList<PresentationItem> getSlideItems() {
		return items;
	}

	// give the size of the Slide
	public int getItemsLength() {
		return items.size();
	}

	// draw the slide
	public void draw(Graphics g, ImageObserver view) {
		for (PresentationItem slideItem : items) {
			slideItem.draw(g, view);
		}
	}

	public Element getXMLSaveElement(Document doc){
		Element slide = doc.createElement(this.getClass().getSimpleName());
		slide.setAttribute("width", String.valueOf(this.WIDTH));
		slide.setAttribute("height", String.valueOf(this.HEIGHT));
		for (PresentationItem item : items) {
			Element itemE = item.getXMLSaveElement(doc);
			slide.appendChild(itemE);
		}
		return slide;
	}

	@Override
	public Builder getBuilder(Parent parent) {
		return new SlideBuilder(parent);
	}

}
