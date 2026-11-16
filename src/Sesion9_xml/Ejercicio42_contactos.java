package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio42_contactos {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(1, "Julian"));
        contactos.add(new Contacto(2, "Maria"));
        contactos.add(new Contacto(3, "John"));
        contactos.add(new Contacto(4, "Amanda"));
        contactos.add(new Contacto(5, "Jose"));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element raiz = doc.createElement("contactos");
        doc.appendChild(raiz);

        for (Contacto c: contactos) {
            Element contacto = doc.createElement("contacto");
            contacto.setAttribute("id", String.valueOf(c.getId()));

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(c.getNombre());
            contacto.appendChild(nombre);
            raiz.appendChild(contacto);
        }

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File("ejercicio42.xml")));

        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = db.parse(new File("ejercicio42.xml"));

        NodeList contactosLeidos = doc.getElementsByTagName("contacto");

        for(int i=0; i < contactosLeidos.getLength(); i++){
            Element e = (Element) contactosLeidos.item(i);

            int id = Integer.parseInt(e.getAttribute("id"));

            String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();

            System.out.println("Contacto leido: "+id+" - "+nombre);
        }
    }
}
