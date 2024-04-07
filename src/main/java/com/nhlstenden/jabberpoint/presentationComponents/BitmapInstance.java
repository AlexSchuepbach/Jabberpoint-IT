package com.nhlstenden.jabberpoint.presentationComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import com.nhlstenden.jabberpoint.builder.BitmapItemBuilder;
import com.nhlstenden.jabberpoint.builder.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.Parent;

import java.io.IOException;


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

public class BitmapInstance extends SlideItemInstance {
  private BufferedImage bufferedImage;
  private String imageLocation;
  
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";

// level is equal to item-level; name is the name of the file with the Image
	public BitmapInstance(String imageLocation) {
		super();
		this.imageLocation = imageLocation;
		bufferImage();

	}
	public void bufferImage(){
		try {
			bufferedImage = ImageIO.read(new File(imageLocation));
		} catch (IOException e) {
			System.err.println(FILE + imageLocation + NOTFOUND);
		}
	}

// An empty bitmap-item
	public BitmapInstance() {
		imageLocation = "";
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	// give the fileLocation of the image
	public String getImageLocation() {
		return imageLocation;
	}

	// draw the image
	@Override
	public void draw(Graphics g, ImageObserver observer) {
		if(bufferedImage != null){
			int width = x;
			int height = y;
			g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)),
				(int) (bufferedImage.getHeight(observer)), observer);
		}
	}

	public String toString() {
		return "BitmapItem[" + imageLocation + "]";
	}

	public BitmapInstance(BitmapInstance original){
        super(original);
        this.imageLocation = original.imageLocation;
    }

    @Override
    public BitmapInstance clone() {
        return new BitmapInstance(this);
    }

	@Override
	public Element getXMLSaveElement(Document doc) {
		Element element = super.getXMLSaveElement(doc);
		Element filePath = doc.createElement("filePath");
		filePath.setTextContent(this.imageLocation);
		element.appendChild(filePath);
		return element;
	}

	@Override
	public Builder getBuilder(Parent parent) {
		return new BitmapItemBuilder(parent);
	}

}
