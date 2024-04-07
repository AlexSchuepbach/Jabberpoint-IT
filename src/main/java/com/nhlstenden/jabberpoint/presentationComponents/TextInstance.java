package com.nhlstenden.jabberpoint.presentationComponents;

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
import java.util.Map;

import com.nhlstenden.jabberpoint.builder.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.TextItem;
import com.nhlstenden.jabberpoint.builder.SlideItemTextBuilder;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;

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

public class TextInstance extends SlideItemInstance implements TextItem {
	private String text;
	protected int fontSize = 16;
	protected Color color = Color.black;
	protected String fontName = "Arial";
	private HashMap<TextAttribute, Integer> attributes = new HashMap<>();
	
	private static final String EMPTYTEXT = "No Text Given";

	
// a textitem of level level, with the text string
	public TextInstance(String string) {
		super();
		text = string;
	}

// an empty textitem
	public TextInstance() {
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

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public Font getFontObject(){
		return new Font(fontName, Font.BOLD, fontSize);
	}

	public void addAttribute(TextAttribute attribute, int value){
		if(attributes != null && value >= 0){
			this.attributes.put(attribute, value);
		}
	}

	public void removeAttribute(TextAttribute attribute){
		if(attributes != null){
			this.attributes.remove(attribute);
		}
	}

// geef de AttributedString voor het item
	public AttributedString getAttributedString() {
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, getFontObject(), 0, text.length());
		return attrStr;
	}

	private AttributedString applyAttributeModifications(AttributedString attrStr) {
		for (Map.Entry<TextAttribute, Integer> entry : attributes.entrySet()) {
			attrStr.addAttribute(entry.getKey(), entry.getValue());
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
		float wrappingWidth = (SlideInstance.WIDTH);
		while (measurer.getPosition() < getText().length()) {
			TextLayout layout = measurer.nextLayout(wrappingWidth);
			layouts.add(layout);
		}
		return layouts;
	}

	TextInstance(TextInstance original){
		super(original);
		this.text = original.text;
	}

	public TextInstance clone() {
		return new TextInstance(this);
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

	@Override
	public Element getXMLSaveElement(Document doc) {
		Element textItem = super.getXMLSaveElement(doc);
		Element text = createTextElement(doc);
		Element color = createColorElement(doc);
		Element fontSize = createFontNameElement(doc);
		Element fontName = createFontSizeElement(doc);
		Element attributes = createAttributesElement(doc);

		textItem.appendChild(text);
		textItem.appendChild(color);
		textItem.appendChild(fontSize);
		textItem.appendChild(fontName);
		textItem.appendChild(attributes);

		return textItem;
	}

	private Element createTextElement(Document doc){
		Element text = doc.createElement("text");
		text.setTextContent(this.text);
		return text;
	}

	private Element createColorElement(Document doc){
		Element color = doc.createElement("color");
		color.setTextContent(String.valueOf(this.color.getRGB()));
		return color;
	}

	private Element createFontSizeElement(Document doc){
		Element fontSize = doc.createElement("fontSize");
		fontSize.setTextContent(String.valueOf(this.fontSize));
		return fontSize;
	}

	private Element createFontNameElement(Document doc){
		Element fontName = doc.createElement("fontName");
		fontName.setTextContent(this.fontName);
		return fontName;
	}

	private Element createAttributesElement(Document doc){
		Element attributes = doc.createElement("attributes");

		for (Map.Entry<TextAttribute, Integer> entry : this.attributes.entrySet()) {
			Element attributeItem = doc.createElement("attribute");
			Element attributeName = doc.createElement("name");
			attributeName.setTextContent(entry.getKey().toString());
			
			Element attributeValue = doc.createElement("value");
			attributeValue.setTextContent(entry.getValue().toString());
			
			attributeItem.appendChild(attributeName);
			attributeItem.appendChild(attributeValue);
			attributes.appendChild(attributeItem);
		}

		return attributes;
	}


	public Builder getBuilder(Parent parent) {
		return new SlideItemTextBuilder(parent);
	}
}
