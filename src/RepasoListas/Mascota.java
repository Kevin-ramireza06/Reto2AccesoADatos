package RepasoListas;

import java.util.*;

public class Mascota implements Comparable<Mascota>{
    @Override
    public int compareTo(Mascota otraMascota) {

        int comparador = Integer.compare(this.edad, otraMascota.edad);

        if (comparador == 0){
            return comparador = this.nombre.compareTo(otraMascota.nombre);
        } else {
            return comparador;
        }
        /* La clase Integer tienen un metodo compare, que lo que hace es devolver un valor, dependiendo
        * si es menor, mayor o igual*/
    }

    protected String nombre;
    protected int edad;

    public Mascota(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre = " + nombre +
                ", edad = " + edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return getEdad() == mascota.getEdad() && Objects.equals(getNombre(), mascota.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad());
    }




}
