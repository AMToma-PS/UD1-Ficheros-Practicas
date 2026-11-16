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

public class Ejercicio42_peliculas {

    static final String FICHERO = "peliculas.xml";

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(1, "El laberinto del fauno", 2006));
        peliculas.add(new Pelicula(2, "Mar adentro", 2004));
        peliculas.add(new Pelicula(3, "Los otros", 2001));
        peliculas.add(new Pelicula(4, "Volver", 2006));
        peliculas.add(new Pelicula(5, "Campeones", 2018));

        escribir(peliculas);
        leer();
    }

    static void escribir(ArrayList<Pelicula> peliculas) throws ParserConfigurationException, TransformerException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.newDocument();

        Element raiz = doc.createElement("filmoteca");
        doc.appendChild(raiz);

        for (Pelicula p : peliculas) {
            Element pelicula = doc.createElement("pelicula");
            pelicula.setAttribute("id", String.valueOf(p.getId()));

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent(p.getTitulo());
            pelicula.appendChild(titulo);

            Element anio = doc.createElement("anio");
            anio.setTextContent(String.valueOf(p.getAnio()));
            pelicula.appendChild(anio);

            raiz.appendChild(pelicula);
        }

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        tr.transform(new DOMSource(doc), new StreamResult(new File(FICHERO)));

        System.out.println("Generado " + FICHERO + " con " + peliculas.size() + " peliculas");
    }

    static void leer() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new File(FICHERO));

        NodeList nodos = doc.getElementsByTagName("pelicula");
        ArrayList<Pelicula> leidas = new ArrayList<>();

        for (int i = 0; i < nodos.getLength(); i++) {
            Element e = (Element) nodos.item(i);

            int id = Integer.parseInt(e.getAttribute("id"));
            String titulo = e.getElementsByTagName("titulo").item(0).getTextContent();
            int anio = Integer.parseInt(e.getElementsByTagName("anio").item(0).getTextContent());

            leidas.add(new Pelicula(id, titulo, anio));
        }

        leidas.forEach(p -> System.out.println("Pelicula leida: " + p));
    }
}
