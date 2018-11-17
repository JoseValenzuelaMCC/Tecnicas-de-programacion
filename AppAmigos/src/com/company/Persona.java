package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Persona {
    private String nombre;

    private List<Persona> listaAmigos = new ArrayList<Persona>();

    public Persona(String n){
        this.nombre = n;
        /*
        for(Persona aN1 : amigoN1){
            listaAmigos.add(aN1);
        }*/
    }

    public String getNombre(){return this.nombre;}

    public void setAmigo(Persona amigo){
        listaAmigos.add(amigo);
    }

    public List<Persona> getListaAmigos() {
        return listaAmigos;
    }

    public String toString() {
        return nombre;
    }
}
