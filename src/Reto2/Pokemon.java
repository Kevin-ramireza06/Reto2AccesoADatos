package Reto2;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class Pokemon implements Comparable<Pokemon> {

    private int nivel;
    private String nombre;
    private String apodo;
    private String movimientos;
    private int numPokedex;

    static PrintWriter pw;

    public Pokemon() {}

    public Pokemon(String nombre, String apodo, int nivel, String movs, int numPokedex) {

        this.apodo = apodo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.numPokedex = numPokedex;
        this.movimientos = movs;

    }

    public Pokemon(String nombre, String apodo){
        this.nombre = nombre;
        this.apodo = apodo;
    }

    @Override
    public String toString() {
        return "Pokemon: Nivel: " + nivel + ", Nombre: " + nombre + ", Apodo: " + apodo +", Movimientos: "+movimientos+", Numero Pokedex: " + numPokedex+"\n";
    }
//    Comparador
    @Override
    public int compareTo(Pokemon o) {
        if (this.nivel < o.nivel) {
            return -1;
        } else if (this.nivel > o.nivel) {
            return 1;
        } else {
            if (this.numPokedex < o.numPokedex) {
                return -1;
            } else if (this.numPokedex > o.numPokedex) {
                return 1;
            } else {
                return 0;
            }
        }
    }
//      Metodos para comparar si 2 accesoADatos.pokemon son iguales
    @Override
    public int hashCode() {
        return Objects.hash(nivel, nombre, numPokedex, apodo, movimientos);
    }

    public boolean equals(Pokemon p) {
        return ((this.nombre.equals(p.nombre)) && (this.apodo.equals(p.apodo)) && (this.nivel == p.nivel) && (this.movimientos.equals(p.movimientos)) && (this.numPokedex == p.numPokedex));
    }
//      Metodo que reemplaza las "," de los movmientos por "-"
    static String reemplazar(String s){
        if (s.contains(",")){
            s = s.replace(",","-");
        }
        return s;
    }
//      Metodo para escribir con el PrintWriter
    public static void escribir(List<Pokemon> lista){

        try {
            pw = new PrintWriter(new FileWriter(new File("pokemon.csv")));
            pw.write("Nombre,Apodo,Nivel,Movimientos,NumeroPokedex\n");
            for (Pokemon p : lista) {
                pw.println(p.getNombre() + ","
                        + p.getApodo() + ","
                        + p.getNivel() + ","
                        + reemplazar(p.getMovimientos()) + ","
                        + p.getNumPokedex());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                pw.close();
            } catch (Exception e){

            }
        }

    }
//      Metodo para leer el archivo
    public static void leer(){

        try {

            BufferedReader br = new BufferedReader(new FileReader(new File("pokemon.csv")));
            String linea;
//            Saltamos la linea para saltar el Nombre,Nivel...
            br.readLine();
            while ((linea = br.readLine()) != null){
//                Separamos cada campo por ","
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String apodo = partes[1];
                int nivel = Integer.parseInt(partes[2]);
                String movs = partes[3];
                int numPok = Integer.parseInt(partes[4]);

                Pokemon p = new Pokemon(nombre,apodo,nivel,movs,numPok);
                System.out.print(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//      Getters y Setters
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }
}
