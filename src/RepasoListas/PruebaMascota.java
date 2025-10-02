package RepasoListas;

import java.util.*;

public class PruebaMascota {

    public static void main(String[] args) {

        List<Mascota> perrera = new ArrayList<Mascota>();

        Mascota pepe = new Mascota("Pepe", 5);
        Mascota pepa = new Mascota("Pepa", 6);
        Mascota pepito = new Mascota("Pepito", 2);
        Mascota pepita = new Mascota("Pepita", 3);
        Mascota pepita1 = new Mascota("AndreaPepita", 3);
        Mascota pepita2 = new Mascota("AndreaPepita", 3);



        perrera.add(pepe);
        perrera.add(pepa);
        perrera.add(pepita);
        perrera.add(pepito);
        perrera.add(pepita1);

        for ( Mascota index : perrera){
            //System.out.println(index.nombre + " " + index.edad);
            System.out.println(index);
        }

        //Array en principio ordenado

        Collections.sort(perrera);

        System.out.println("--------------Array Ordenado-----------");

        for ( Mascota index : perrera){
            System.out.println(index.getNombre() + " " + index.getEdad());
        }

        /*Uso del hashset*/

        System.out.println("---------------------------------------");

        Set<Mascota> perreraSet = new HashSet<Mascota>();

        perreraSet.add(pepe);
        perreraSet.add(pepa);
        perreraSet.add(pepita);
        perreraSet.add(pepito);
        perreraSet.add(pepita1);
        perreraSet.add(pepita2);

        for ( Mascota index : perreraSet){
            System.out.println(index.getNombre() + " " + index.getEdad());
        }

        System.out.println(perreraSet.contains(new Mascota("Pepa", 6)));

        System.out.println("---------------------------------------");

        /*Uso del Map*/

        Map<String,Mascota> perreraMap = new HashMap<String,Mascota>();

        perreraMap.put("A123456", pepe);
        perreraMap.put("B123456",pepa);
        perreraMap.put("C123456",pepita);
        perreraMap.put("D123456",pepito);
        perreraMap.put("K123456",pepita1);

        /*
        for (int i = 0; i < perrera.size(); i++) {
            perreraMap.put(i,perrera.get(i));
        }*/

        for(Map.Entry<String,Mascota> mapEntero: perreraMap.entrySet() ){
            System.out.println(mapEntero.getKey() + " -> " + mapEntero.getValue());
        }

        System.out.println(perreraMap.get("S123456"));
        System.out.println(perreraMap.get("K123456"));
    }
}
