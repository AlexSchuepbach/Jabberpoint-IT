import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/** <p>A tekst item.</p>
 * <p>A TextItem has drawingfunctionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem implements TextItemI{
	private String text;
	protected int fontSize = 16;
	protected Color color = Color.black;
	protected String fontName = "Arial";
	private ArrayList<TextAttribute> textAttribute = new ArrayList<>();
	private ArrayList<Integer> textAttributeValue = new ArrayList<>();
	
	private static final String EMPTYTEXT = "No Text Given";

	
// a textitem of level level, with the text string
	public TextItem(String string) {
		super();
		text = string;
	}

// an empty textitem
	public TextItem() {
		this(EMPTYTEXT);
	}

// give the text
	public String getText() {
		return text == null ? "" : text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Font getFontObject(){
		return new Font(fontName, Font.BOLD, fontSize);
	}

	public void addAttribute(TextAttribute attribute, int value){
		if(attribute != null && value >= 0){
			if(!this.textAttribute.contains(attribute)){
				this.textAttribute.add(attribute);
				this.textAttributeValue.add(value);
			}
			else{
				int index = this.textAttribute.indexOf(attribute);
				this.textAttribute.add(index, attribute);
				this.textAttributeValue.add(index, value);
			}
		}
	}

	public void removeAttribute(TextAttribute attribute){
		if(this.textAttribute.contains(attribute)){
			int index = this.textAttribute.indexOf(attribute);
			this.textAttribute.remove(index);
			this.textAttributeValue.remove(index);
		}
	}

// geef de AttributedString voor het item
	public AttributedString getAttributedString() {
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, getFontObject(), 0, text.length());
		return attrStr;
	}

	private AttributedString applyAttributeModifications(AttributedString attrStr) {
		for(int i=0; i<textAttribute.size();i++){
			System.out.println(textAttribute.size());
			attrStr.addAttribute(textAttribute.get(i), textAttributeValue.get(i));
		}
		return attrStr;
	}

// give the bounding box of the item
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer) {
		List<TextLayout> layouts = getLayouts(g);
		int xsize = 0, ysize = (int) (10);
		Iterator<TextLayout> iterator = layouts.iterator();
		while (iterator.hasNext()) {
			TextLayout layout = iterator.next();
			Rectangle2D bounds = layout.getBounds();
			if (bounds.getWidth() > xsize) {
				xsize = (int) bounds.getWidth();
			}
			if (bounds.getHeight() > 0) {
				ysize += bounds.getHeight();
			}
			ysize += layout.getLeading() + layout.getDescent();
		}
		return new Rectangle(0, 0, xsize, ysize );
	}

	// draw the item
	public void draw(Graphics g, ImageObserver o) {
		if (text == null || text.length() == 0) {
			return;
		}
		List<TextLayout> layouts = getLayouts(g);
		Point pen = new Point(x, y);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		Iterator<TextLayout> it = layouts.iterator();
		while (it.hasNext()) {
			TextLayout layout = it.next();
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
	}

	private List<TextLayout> getLayouts(Graphics g) {

		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString();
		attrStr = applyAttributeModifications(attrStr);
		Graphics2D g2d = (Graphics2D) g;
		FontRenderContext frc = g2d.getFontRenderContext();
		LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
		float wrappingWidth = (Slide.WIDTH);
		while (measurer.getPosition() < getText().length()) {
			TextLayout layout = measurer.nextLayout(wrappingWidth);
			layouts.add(layout);
		}
		return layouts;
	}

	TextItem(TextItem original){
		super(original);
		this.text = original.text;
	}

	public TextItem clone() {
		return new TextItem(this);
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		if(color != null){
			this.color = color;
		}
		
	}
}
