package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RecuperarPokemonAlias {

    public static void main(String[] args) {

        XStream convertirXML = new XStream(new DomDriver());

        convertirXML.allowTypes(
                new Class[] { Pokemon.class }
        );

        //----------Recuperar desde fichero----------

        try {
            File archivo = new File("PokemonAlias.xml");
            /*Al haber hecho un lector directamente del archivo donde guardo, este ya recupera y lee el xml con los
            * nombre que cambiamos*/
            FileReader lector = new FileReader(archivo);
            BufferedReader lectorOptimo = new BufferedReader(lector);

            String linea;

            while ((linea = lectorOptimo.readLine()) != null){
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
