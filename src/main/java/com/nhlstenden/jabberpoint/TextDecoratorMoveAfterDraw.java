import java.awt.Graphics;
import java.awt.image.ImageObserver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TextDecoratorMoveAfterDraw extends TextDecorator {

    private int movementRate;

    TextDecoratorMoveAfterDraw(TextItemI item, int movementRate) {
        super(item);
        this.movementRate = movementRate;
    }

    @Override
    public void draw(Graphics g, ImageObserver o) {
        super.draw(g, o);
        setX(getX()+movementRate);
    }
 
    @Override
    public Element getSaveInfo(Document doc) {
        Element wrapper = super.getSaveInfo(doc);
        wrapper.setAttribute("movementRate", String.valueOf(movementRate));
        return wrapper;
    }
}
