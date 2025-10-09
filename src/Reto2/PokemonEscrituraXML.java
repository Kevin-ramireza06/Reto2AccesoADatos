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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element raiz = doc.createElement("Pokemones");
            doc.appendChild(raiz);

            for (Pokemon p : lista) {
                Element pokemonElem = doc.createElement("Pokemon");

                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(p.getNombre()));
                pokemonElem.appendChild(nombre);

                Element apodo = doc.createElement("Apodo");
                apodo.appendChild(doc.createTextNode(p.getApodo()));
                pokemonElem.appendChild(apodo);

                Element nivel = doc.createElement("Nivel");
                nivel.appendChild(doc.createTextNode(String.valueOf(p.getNivel())));
                pokemonElem.appendChild(nivel);

                Element movimientos = doc.createElement("Movimientos");
                movimientos.appendChild(doc.createTextNode(p.getMovimientos()));
                pokemonElem.appendChild(movimientos);

                Element numPokedex = doc.createElement("NumeroPokedex");
                numPokedex.appendChild(doc.createTextNode(String.valueOf(p.getNumPokedex())));
                pokemonElem.appendChild(numPokedex);

                raiz.appendChild(pokemonElem);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File(archivoXML));

            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
