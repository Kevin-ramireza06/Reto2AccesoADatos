package Reto2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.Iterator;

public class RecuperarPokemonPersistente {

    public static void main(String[] args) {

        XStream convertirXML = new XStream(new DomDriver());

        convertirXML.allowTypes(
                new Class[] { Pokemon.class }
        );

        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("PokemonesPersistentes"),convertirXML);
        XmlArrayList listaPokemones = new XmlArrayList(strategy);

        for (Iterator iterador = listaPokemones.iterator(); iterador.hasNext(); ){
            Pokemon pokemonRecuperado = (Pokemon) iterador.next();
            if (pokemonRecuperado.getNombre().equals("Lucario")){
                System.out.println("Se borro lucario");
                //Prefguntar
                iterador.remove();
            } else {
                System.out.println("Manteniendo " + pokemonRecuperado.getNombre());
            }

            /*Personalmente se me hixo mas comodo y mas facil y comodo lo que hice en el apartado 1, ya que
            * no entiendo muy bien lo que es la clasee Strategy y el mistake, ademas en el apartado uno, creabamos
            * el objeto en java y despues lo guardabamos en un xml, en cambio aqui los creamos en una lista de
            * xstream, y este mismo crea un xml por objeto, en este caso yo creo que un metodo es mas comodo
            * que el otro dependiendo del contexto*/

            /*
            * Respecto al punto 4, nos percatamos que de los ejercicios del archivo, son pocos los cambios interesantes
            * que podemos hacer con respecto a lo que tenemos hecho, ya que lo que hay en los ejercicios son lo que
            * hemos hecho pero con distintas clases, lo unico interesante que habia de los ejercicios son que el metodo
            * "toXML()" puede recibir por un objeto de la clase ObjectOutputStream, y el metodo "fromXML" puede
            *recibir un objeto de la clase "InputStream"
            */
        }
    }
}
