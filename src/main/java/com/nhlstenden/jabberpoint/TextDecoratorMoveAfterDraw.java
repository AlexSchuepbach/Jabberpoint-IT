import java.awt.Graphics;
import java.awt.image.ImageObserver;

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
    
}
