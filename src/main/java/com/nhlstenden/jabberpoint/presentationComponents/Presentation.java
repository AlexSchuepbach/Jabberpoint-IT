package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.SlideViewerComponent;
import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.Interfaces.SlideItemI;
import com.nhlstenden.jabberpoint.creators.PresentationCreator;


/**
 * <p>Presentation maintains the slides in the presentation.</p>
 * <p>There is only instance of this class.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation implements CanBeParent, PresentationItemI{
	private String showTitle; // title of the presentation
	private ArrayList<PresentationItemI> slides = null; // an ArrayList with Slides
	private int currentSlideNumber = 0; // the slidenummer of the current Slide
	private SlideViewerComponent slideViewComponent = null; // the viewcomponent of the Slides

	public Presentation() {
		slideViewComponent = null;
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		clear();
	}

	public ArrayList<PresentationItemI> getSlides() {
		return slides;
	}

	public int getSize() {
		return slides.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	// give the number of the current slide
	public int getSlideNumber() {
		return currentSlideNumber;
	}

	// change the current slide number and signal it to the window
	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// go to the previous slide unless your at the beginning of the presentation
	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
	    }
	}

	// go to the next slide unless your at the end of the presentation.
	public void nextSlide() {
		if (currentSlideNumber < (slides.size()-1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	// Delete the presentation to be ready for the next one.
	public void clear() {
		slides = new ArrayList<PresentationItemI>();
		setSlideNumber(-1);
	}

	// Get a slide with a certain slidenumber
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
	    }
			return (Slide)slides.get(number);
	}

	// Give the current slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}

	public Element getSaveInfo(Document doc){
		Element presentation = doc.createElement(this.getClass().getSimpleName());
		presentation.setAttribute("title", this.showTitle);
		for (PresentationItemI slide : slides) {
			Element slideE = slide.getSaveInfo(doc);
			presentation.appendChild(slideE);
		}
		return presentation;
	}

	@Override
	public void append(PresentationItemI item) {
		slides.add(item);
	}

	@Override
	public void draw(Graphics g, ImageObserver observer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'draw'");
	}

	@Override
	public CreatorI getCreator(CanBeParent parent) {
		return new PresentationCreator(parent);
	}
}
