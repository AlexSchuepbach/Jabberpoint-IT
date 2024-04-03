package com.nhlstenden.jabberpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItemI;
import com.nhlstenden.jabberpoint.creators.PresentationCreator;
import com.nhlstenden.jabberpoint.presentationComponents.BitmapItem;
import com.nhlstenden.jabberpoint.presentationComponents.Presentation;
import com.nhlstenden.jabberpoint.presentationComponents.Slide;
import com.nhlstenden.jabberpoint.presentationComponents.TextItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/** XMLAccessor, reads and writes XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor extends Accessor {
	
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    
	public void loadFile(Presentation presentation, String filename) throws IOException {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
			Document document = builder.parse(new File("C:\\Users\\Hp\\Programs\\projects\\quality\\Jabberpoint-IT\\result.xml")); // Create a JDOM document
			Element doc = document.getDocumentElement();
			CreatorI presCreator = presentation.getCreator(presentation);
			presCreator.loadFromElement(doc);
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		 } catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	protected void loadSlideItem(Slide slide, Element item) {
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();

		String type = attributes.getNamedItem(KIND).getTextContent();
		if (TEXT.equals(type)) {
			slide.append(new TextItem(item.getTextContent()));
		}
		else {
			if (IMAGE.equals(type)) {
				slide.append(new BitmapItem(level, item.getTextContent()));
			}
			else {
				System.err.println(UNKNOWNTYPE);
			}
		}
	}

	public void saveFile(Presentation presentation, String filename) throws IOException, ParserConfigurationException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		doc.appendChild(presentation.getSaveInfo(doc));

		try{
			FileOutputStream output = new FileOutputStream("result.xml");{
				writeXml(doc, output);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeXml(Document doc, OutputStream output) throws TransformerException 
	{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

    }

	public static PresentationItemI execLoaderFromElement(Element element, CanBeParent parent){
		PresentationItemI obj;
		try {
			obj = (PresentationItemI) Class.forName("com.nhlstenden.jabberpoint.presentationComponents." + element.getTagName()).getDeclaredConstructor().newInstance();
			CreatorI creator = obj.getCreator(parent);
			PresentationItemI newElement = creator.loadFromElement(element);
		
			return newElement;
		
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
		return null;

	}

}
