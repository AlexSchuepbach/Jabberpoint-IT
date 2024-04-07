package com.nhlstenden.jabberpoint;

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

import com.nhlstenden.jabberpoint.builder.Builder;
import com.nhlstenden.jabberpoint.presentationComponents.SlideInstance;
import org.xml.sax.SAXException;

import com.nhlstenden.jabberpoint.Interfaces.Parent;
import com.nhlstenden.jabberpoint.Interfaces.PresentationItem;
import com.nhlstenden.jabberpoint.presentationComponents.BitmapInstanceInstance;
import com.nhlstenden.jabberpoint.presentationComponents.PresentationInstance;
import com.nhlstenden.jabberpoint.presentationComponents.TextInstance;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;


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

	protected static final String rootComponentClass = "com.nhlstenden.jabberpoint.presentationComponents";
    
	public void loadFile(PresentationInstance presentationInstance, String filename) throws IOException {
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(new File("result.xml")); // Create a JDOM document
			Element doc = document.getDocumentElement();
			Builder presBuilder = presentationInstance.getBuilder(presentationInstance);
			presBuilder.loadFromElement(doc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void loadSlideItem(SlideInstance slideInstance, Element item) {
		NamedNodeMap attributes = item.getAttributes();

		String type = attributes.getNamedItem(KIND).getTextContent();
		if (TEXT.equals(type)) {
			slideInstance.append(new TextInstance(item.getTextContent()));
		}
		else {
			if (IMAGE.equals(type)) {
				slideInstance.append(new BitmapInstanceInstance(item.getTextContent()));
			}
			else {
				System.err.println(UNKNOWNTYPE);
			}
		}
	}

	public void saveFile(PresentationInstance presentationInstance, String filename) throws IOException, ParserConfigurationException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		doc.appendChild(presentationInstance.getXMLSaveElement(doc));

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

	public static PresentationItem execLoaderFromElement(Element element, Parent parent){
		PresentationItem basePresentationItem;
		
		basePresentationItem = (PresentationItem) getObjectFromElement(element);
		Builder builder = basePresentationItem.getBuilder(parent);
		PresentationItem returnedPresentationItem = builder.loadFromElement(element);
	
		return returnedPresentationItem;
	}

	private static Object getObjectFromElement(Element element){
		try {
			return Class.forName(rootComponentClass + "." + element.getTagName()).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
