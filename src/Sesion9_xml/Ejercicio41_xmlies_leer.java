package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejercicio41_xmlies_leer {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File("ejercicio41.xml"));

        NodeList listaNodos = doc.getElementsByTagName("nombre");

        String nombre = listaNodos.item(0).getTextContent();
        System.out.println("Nombre: "+nombre);

        String idioma = listaNodos.item(0).getAttributes().getNamedItem("idioma").getNodeValue();
        System.out.println("Atributo idioma: "+idioma);

        listaNodos = doc.getElementsByTagName("ciudad");

        String ciudad = listaNodos.item(0).getTextContent();
        System.out.println("Ciudad: "+ciudad);
    }
}
