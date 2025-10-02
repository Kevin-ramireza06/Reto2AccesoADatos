package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class GuardarPokemonPersistente {

    public static void main(String[] args) {

        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("PokemonesPersistentes"));
        XmlArrayList listaPokemones = new XmlArrayList(strategy);

        Pokemon pikachu = new Pokemon("Pikachu", "Sparky", 25, "Impactrueno, Placaje, Ataque Rápido, Rayo", 25);
        Pokemon charizard = new Pokemon("Charizard", "Draco", 36, "Lanzallamas, Garra Dragón, Vuelo, Sofoco", 6);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Leafy", 15, "Látigo Cepa, Placaje, Somnífero, Hoja Afilada", 1);
        Pokemon squirtle = new Pokemon("Squirtle", "Shelly", 18, "Pistola Agua, Burbuja, Refugio, Mordisco", 7);
        Pokemon gengar = new Pokemon("Gengar", "Shade", 45, "Bola Sombra, Psíquico, Hipnosis, Puño Sombra", 94);

        listaPokemones.add(pikachu);
        listaPokemones.add(charizard);
        listaPokemones.add(bulbasaur);
        listaPokemones.add(squirtle);
        listaPokemones.add(gengar);

        Pokemon error = new Pokemon("Lucario", "Aura", 50, "Esfera Aural, Puño Meteoro, Danza Espada, Velocidad Extrema", 448);
        ;

        /*
        convertirXML.addPermission(AnyTypePermission.ANY);

        //Pokemon pikachu = new Pokemon("Pikachu", "Sparky", 25, "Impactrueno, Placaje, Ataque Rápido, Rayo", 25);

        convertirXML.alias("Pokemon" , Pokemon.class);
        convertirXML.aliasField("NumeroPokedex" , Pokemon.class , "numPokedex");
        convertirXML.aliasField("Level" , Pokemon.class , "nivel");





        //-----------Guardar XML en fichero-----------

        try{
            File archivo = new File("PokemonesPersistentes");
            FileWriter escritor = new FileWriter(archivo);
            //BufferedWriter escritorOptimo = new BufferedWriter(escritor);

            escritor.write(xml);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
              */
    }
}
