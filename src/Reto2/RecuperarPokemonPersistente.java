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

            /*Personalmente se me hizo mas comodo y mas facil y comodo lo que hice en el apartado 1, ya que
            * no entiendo muy bien lo que es la clasee Strategy y el mistake, ademas en el apartado uno, creabamos
            * el objeto en java y despues lo guardabamos en un xml, en cambio aqui los creamos en una lista de
            * xstream, y este mismo crea un xml por objeto, en este caso yo creo que un metodo es mas comodo
            * que el otro dependiendo del contexto*/

            /*
            * Respecto al punto 4, leyendo los ejercicios que este contiene, son muy pocos los cambios e implemetnaciones
            * que se puedan realizar, y sean relevantes, ya que lo que mas se ve enm los ejercicios son hacer y recuperar
            * los xmls, y hacerlos persistentes con difeerentes clase, los cuales ya hemos echo y explicado en estos
            * archivos, lo mas interesante que vimos de esto son el metodo "omitField" de XStream para omitir el
            * proveedor, y que el metodo "toXML" puede recibir tambien de parametro un objeto de la clase ObjectOutputStream
            * y el "fromXML" puede recibir un Objeto de la clase "InputStream"
            */
        }
    }
}
