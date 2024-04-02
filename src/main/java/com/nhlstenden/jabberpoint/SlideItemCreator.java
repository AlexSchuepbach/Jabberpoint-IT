package com.nhlstenden.jabberpoint;

public abstract class SlideItemCreator {
    protected Slide slide;

    public abstract void reset();

    protected SlideItemCreator(Slide slide){
        this.slide = slide;
    }
}
