package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Amigos implements Iterable<Amigos> {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Amigos> listaAmigos = new ArrayList<Amigos>();

    public Amigos(String n, String a, int e, Amigos... amigoN1){
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
        for(Amigos aN1 : amigoN1){
            listaAmigos.add(aN1);
        }
    }

    public String getNombre(){return this.nombre;}
    public String getApellido(){return  this.apellido;}
    public int getEdad(){return this.edad;}

    public Iterator<Amigos>iterator(){return listaAmigos.iterator();}

    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setApellido(String apellido) { this.apellido = apellido;}
    public void setEdad(int edad) { this.edad = edad;}

    public String toString() {
        return "\nNombre: " + nombre + " " +
                "Apellido: " + apellido + " " +
                "Edad: " + edad;
    }


}
