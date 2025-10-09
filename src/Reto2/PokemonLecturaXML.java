package Pokemones;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class PokemonLecturaXML {
    public static List<Pokemon> leerDesdeXML(String archivoXML) {
        List<Pokemon> lista = new ArrayList<>();
        try {
            File file = new File(archivoXML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList pokemonNodes = doc.getElementsByTagName("Pokemon");

            for (int i = 0; i < pokemonNodes.getLength(); i++) {
                Node nodo = pokemonNodes.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nodo;
                    String nombre = elem.getElementsByTagName("Nombre").item(0).getTextContent();
                    String apodo = elem.getElementsByTagName("Apodo").item(0).getTextContent();
                    int nivel = Integer.parseInt(elem.getElementsByTagName("Nivel").item(0).getTextContent());
                    String movimientos = elem.getElementsByTagName("Movimientos").item(0).getTextContent();
                    int numPokedex = Integer.parseInt(elem.getElementsByTagName("NumeroPokedex").item(0).getTextContent());

                    Pokemon p = new Pokemon(nombre, apodo, nivel, movimientos, numPokedex);
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
