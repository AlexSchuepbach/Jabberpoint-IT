import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;


public abstract class SlideItem implements SlideItemI {
	protected int x;
	protected int y;
	
	public SlideItem() {
		this.x = 0;
        this.y = 0;
	}

	public SlideItem(SlideItem original){
        this.x = original.x;
        this.y = original.y;
    }

	public abstract void draw(Graphics g, ImageObserver observer);

	public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void updateCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract Prototype clone();
}
