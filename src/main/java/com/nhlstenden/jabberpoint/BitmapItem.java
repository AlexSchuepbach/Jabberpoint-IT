package com.nhlstenden.jabberpoint;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/** <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items have the responsibility to draw themselves.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class BitmapItem extends SlideItem {
  private BufferedImage bufferedImage;
  private String imageName;
  
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";

// level is equal to item-level; name is the name of the file with the Image
	public BitmapItem(int level, String name) {
		super();
		imageName = name;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND) ;
		}
	}

// An empty bitmap-item
	public BitmapItem() {
		this(0, null);
	}

// give the filename of the image
	public String getName() {
		return imageName;
	}

// give the  bounding box of the image
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
		return new Rectangle((int) (myStyle.indent * scale), 0,
				(int) (bufferedImage.getWidth(observer) * scale),
				((int) (myStyle.leading * scale)) + 
				(int) (bufferedImage.getHeight(observer) * scale));
	}

// draw the image
	@Override
	public void draw(Graphics g, ImageObserver observer) {
		if(bufferedImage != null){
			int width = x + (int) (1);
			int height = y + (int) (1);
			g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*1),
				(int) (bufferedImage.getHeight(observer)*1), observer);
		}
	}

	public String toString() {
		return "BitmapItem[" + imageName + "]";
	}

	public BitmapItem(BitmapItem original){
        super(original);
        this.imageName = original.imageName;
    }

    @Override
    public SlideItem clone() {
        return new BitmapItem(this);
    }

	@Override
	public Element getSaveInfo(Document doc) {
		// TODO:: add bitmap saving
		Element bitmap = doc.createElement("bitmap");
		Element name = doc.createElement("name");
		name.setTextContent(this.imageName);
		bitmap.appendChild(name);
		return bitmap;
	}

}
