package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarPokemon {

    public static void main(String[] args) {
        XStream convertirXML = new XStream(new DomDriver());

        convertirXML.allowTypes(
                new Class[] { Pokemon.class }
        );
        /*Las versiones recientes de XStream no permiten que se puedan recuperar facilmente de cualquier xml,
         * para solucionarlo debemos de indiarle a XStream que clases podemos usar, para eso usamos el codigo anterior*/

        Pokemon pikachu = new Pokemon("Pikachu", "Sparky", 25, "Impactrueno, Placaje, Ataque Rápido, Rayo", 25);

        String xml = convertirXML.toXML(pikachu);
        /*EL xtream convierte un objeto a XML pero no lo guarda, solo lo vuelve un String con un formato de
        * xml y nosotros somos quines lo transformamos a un fichero*/

        System.out.println(xml);
        Pokemon pikachuRecuperado = (Pokemon)convertirXML.fromXML(xml);
        System.out.println(pikachuRecuperado.toString());

        //-----------Guardar XML en fichero-----------

        try{
            File archivo = new File("Pokemon.xml");
            FileWriter escritor = new FileWriter(archivo);
            //BufferedWriter escritorOptimo = new BufferedWriter(escritor);

            escritor.write(xml);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
