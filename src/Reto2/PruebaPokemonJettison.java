package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PruebaPokemonJettison {

    public static void main(String[] args) throws Exception {

        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon("Rayquaza", "Jörmungandr", 79, "Enfado, Danza Dragón, Velocidad Extrema, Ascenso Draco", 384));
        lista.add(new Pokemon("Hydreigon", "Cerbero", 70, "Pulso Dragón, Hiperrayo, Golpe Mordaza, Onda Certera", 635));
        lista.add(new Pokemon("Ceruledge", "Sir Lancelot", 56, "Espada Lamento, Garra Umbría, Danza Espada, Cuchilla Solar", 937));

        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{Pokemon.class, ArrayList.class});
        xstream.alias("pokemon", Pokemon.class);
        xstream.alias("listaPokemons", List.class); // alias para la lista si quieres serializar lista

        String json = xstream.toXML(lista); // aunque es toXML, el driver Jettison genera JSON
        Files.write(Paths.get("pokemons.json"), json.getBytes("UTF-8"));
        System.out.println("JSON generado con Jettison:\n" + json);

        String contenido = new String(Files.readAllBytes(Paths.get("pokemons.json")), "UTF-8");
        List<Pokemon> listaRecuperada = (List<Pokemon>) xstream.fromXML(contenido);

        System.out.println("\nPokemons recuperados:");
        for (Pokemon p : listaRecuperada) {
            System.out.print(p);
        }

        /*
         * Al usar JettisonMappedXmlDriver ganamos en compatibilidad entre XML y JSON, y es muy util para trabajar con ambos sin
         * necesidadd de modificar su logica, aunque necesitemos jettison.jar extra. Al mentener la logica de XML,
         * JSON es menos bonito. Lo he preferido porque me ha resultado más interesante que el JsonHierethicalStreamDriver,
         * que es más directo y que en caso de necesitar un JSON y un XML muy parecidos no es lo más óptimo
        */
    }
}

