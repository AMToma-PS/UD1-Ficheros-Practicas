package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejercicio41_xmlmuseo_leer {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File("museo.xml"));

        Element nombre = (Element) doc.getElementsByTagName("nombre").item(0);
        System.out.println("Nombre: " + nombre.getTextContent());
        System.out.println("Atributo idioma: " + nombre.getAttribute("idioma"));

        String ciudad = doc.getElementsByTagName("ciudad").item(0).getTextContent();
        System.out.println("Ciudad: " + ciudad);
    }
}
