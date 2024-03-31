import java.awt.Color;
import java.awt.font.TextAttribute;

public class SlideItemTextCreator extends SlideItemCreator{

    private TextItemI textItem;

    public void reset(){
        this.textItem = new TextItem();
    }

    public void apply(){
        slide.append(textItem);
    }

    public SlideItemTextCreator(Slide slide){
        super(slide);
        this.textItem = new TextItem();
        slide.append(textItem);
    }

    public void setText(String text){
        if(text != null){
            textItem.setText(text);
        }
    }

    public void setSize(int size){
        textItem.setFontSize(size);
    }

    public void setPosition(int x, int y){
        textItem.updateCoords(x, y);
    }

    public void setColor(Color color){
        if(color != null){
            textItem.setColor(color);
        }
    }

    public void underline(){
        this.textItem.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    }

    public void addMoveAfterDraw(int movementRate){
        this.textItem = new TextDecoratorMoveAfterDraw(textItem, movementRate);
    }

    public void addUpdateTimer(long delayBetweenUpdates){
        this.textItem = new TextDecoratorUpdateTimer(textItem, delayBetweenUpdates);
    }

}
