package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.TextItemI;
import com.nhlstenden.jabberpoint.baseDecorators.TextDecorator;

public class TextDecoratorUpdateTimer extends TextDecorator{

    private Timer timer;
    private DrawMain task;
    private long delay;

    public TextDecoratorUpdateTimer(TextItemI item, long delay) {
        super(item);
        timer = new Timer();
        task = new DrawMain(item);
        this.delay = delay;
    }

    @Override
    public void draw(Graphics g, ImageObserver o) {
        super.draw(g, o);
        if(!task.started){
            task.assignVars(g, o);
            timer.schedule(task, delay, delay);
        }
    }

    @Override
    public Element getSaveInfo(Document doc) {
        Element wrapper = super.getSaveInfo(doc);
        wrapper.setAttribute("delay", String.valueOf(delay));
        return wrapper;
    }
}

class DrawMain extends TimerTask{

    Boolean started;
    TextItemI item;
    Graphics g;
    ImageObserver o;
    public DrawMain(TextItemI item){
        this.item = item;
        this.started = Boolean.FALSE;
    }

    public void assignVars(Graphics g, ImageObserver o){
        this.g = g;
        this.o = o;
    }

    @Override
    public void run() {
        this.started = true;
        item.draw(g, o);
    }

} 
