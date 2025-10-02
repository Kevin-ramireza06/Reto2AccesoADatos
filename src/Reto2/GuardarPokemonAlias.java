package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarPokemonAlias {

    public static void main(String[] args) {
        XStream convertirXML = new XStream(new DomDriver());

        convertirXML.allowTypes(
                new Class[] { Pokemon.class }
        );

        Pokemon pikachu = new Pokemon("Pikachu", "Sparky", 25, "Impactrueno, Placaje, Ataque Rápido, Rayo", 25);

        convertirXML.alias("Pokemon" , Pokemon.class);
        convertirXML.aliasField("NumeroPokedex" , Pokemon.class , "numPokedex");
        convertirXML.aliasField("Level" , Pokemon.class , "nivel");
        /*Los alias nos perrmiten cambiar los nombres de las etiquetas con los que se guardan los xml, por los que
        * nosotros decidamos, para eso asinamos el nueno nombre, y la clase de la que hablamos, y si es un atributo
        * especificamos cual en el tercer parametro*/

        String xml = convertirXML.toXML(pikachu);

        System.out.println(xml);
        Pokemon pikachuRecuperado = (Pokemon)convertirXML.fromXML(xml);
        System.out.println(pikachuRecuperado.toString());

        //-----------Guardar XML en fichero-----------

        try{
            File archivo = new File("PokemonAlias.xml");
            FileWriter escritor = new FileWriter(archivo);
            //BufferedWriter escritorOptimo = new BufferedWriter(escritor);

            escritor.write(xml);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
