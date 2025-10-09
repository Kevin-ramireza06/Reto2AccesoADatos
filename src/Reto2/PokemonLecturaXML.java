package Reto2;
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
            // 1. Crear objeto File apuntando al archivo XML
            File file = new File(archivoXML);
            // 2. Configurar el parser DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 3. Parsear el archivo XML para obtener un objeto Document en memoria
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // 4. Obtener todos los nodos <Pokemon> del documento
            NodeList pokemonNodes = doc.getElementsByTagName("Pokemon");

            // 5. Recorrer cada nodo encontrado
            for (int i = 0; i < pokemonNodes.getLength(); i++) {
                Node nodo = pokemonNodes.item(i);
                // Verificar si el nodo es un Element (evita procesar texto en blanco)
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nodo;

                    // 6. Extraer el contenido de cada etiqueta hija dentro de <Pokemon>
                    String nombre = elem.getElementsByTagName("Nombre").item(0).getTextContent();
                    String apodo = elem.getElementsByTagName("Apodo").item(0).getTextContent();
                    int nivel = Integer.parseInt(elem.getElementsByTagName("Nivel").item(0).getTextContent());
                    String movimientos = elem.getElementsByTagName("Movimientos").item(0).getTextContent();
                    int numPokedex = Integer.parseInt(elem.getElementsByTagName("NumeroPokedex").item(0).getTextContent());

                    // 7. Crear objeto Pokemon con los datos obtenidos y añadirlo a la lista
                    Pokemon p = new Pokemon(nombre, apodo, nivel, movimientos, numPokedex);
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            // Manejo de errores: imprime la excepción si ocurre
            e.printStackTrace();
        }
        //8. Devolver la lista completa de Pokémon
        return lista;
    }
}

