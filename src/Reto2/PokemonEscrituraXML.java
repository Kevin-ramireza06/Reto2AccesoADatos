package Reto2;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.util.List;

public class PokemonEscrituraXML {
    public static void escribirA_XML(List<Pokemon> lista, String archivoXML) {
        try {
            // 1. Preparar documento DOM vacío
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // 2. Crear elemento raíz <Pokemones>
            Element raiz = doc.createElement("Pokemones");
            doc.appendChild(raiz);

            // 3. Recorrer la lista de Pokémon y añadirlos al documento
            for (Pokemon p : lista) {
                Element pokemonElem = doc.createElement("Pokemon");

                // Sub-elemento Nombre
                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(p.getNombre()));
                pokemonElem.appendChild(nombre);
                // Sub-elemento Apodo
                Element apodo = doc.createElement("Apodo");
                apodo.appendChild(doc.createTextNode(p.getApodo()));
                pokemonElem.appendChild(apodo);
                // Sub-elemento Nivel
                Element nivel = doc.createElement("Nivel");
                nivel.appendChild(doc.createTextNode(String.valueOf(p.getNivel())));
                pokemonElem.appendChild(nivel);
                // Sub-elemento Movimiento
                Element movimientos = doc.createElement("Movimientos");
                movimientos.appendChild(doc.createTextNode(p.getMovimientos()));
                pokemonElem.appendChild(movimientos);
                // Sub-elemento NumeroPokedex
                Element numPokedex = doc.createElement("NumeroPokedex");
                numPokedex.appendChild(doc.createTextNode(String.valueOf(p.getNumPokedex())));
                pokemonElem.appendChild(numPokedex);
                
                // Añadir nodo <Pokemon> al nodo raíz
                raiz.appendChild(pokemonElem);
            }

            // 4. Preparar el transformador para escribir el documento en un archivo físico
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

             // 5. Definir fuente y destino
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File(archivoXML));

            // 6. Ejecutar la transformación (guardar archivo)
            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

