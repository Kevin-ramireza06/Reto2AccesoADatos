package Reto2;
import java.util.ArrayList;
import java.util.List;

public class MainPokemonesXML {
    public static void main(String[] args) {
        // 1. Crear lista de Pokémon
        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon("Pikachu", "Sparky", 12, "Impactrueno,Placaje", 25));
        lista.add(new Pokemon("Bulbasaur", "Leafy", 10, "Látigo Cepa,Placaje", 1));

        // 2. Guardar la lista en XML
        PokemonEscrituraXML.escribirA_XML(lista, "pokemones.xml");
        System.out.println("XML generado correctamente.");

        // 3. Leer la lista desde el XML
        List<Pokemon> listaLeida = PokemonLecturaXML.leerDesdeXML("pokemones.xml");
        System.out.println("Pokémon leídos del XML:");

        // 4. Imprimir los Pokémon leídos
        for (Pokemon p : listaLeida) {
            System.out.println(p);
        }
    }
}
