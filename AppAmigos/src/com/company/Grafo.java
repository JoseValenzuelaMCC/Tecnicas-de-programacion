package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Grafo {
    private HashMap<String, Persona> personas = new HashMap();

    private HashSet<Persona> pasados = new HashSet<>();

    private HashMap<Integer, Persona> niveles = new HashMap<Integer, Persona>();

    public Grafo(){

    }

    public void leerComandos(String comando){
        String[] divisionComando = comando.split("-");
        
        //Se verifica si el tamaño de la division del comando es 1 o 2, en caso de ser 1 nos dice que el
        //comando es para buscar el nivel de amigos de alguna persona, si es 2 se va agregar un amigo..

        //Buscar
        if(divisionComando.length == 1){

        }
        //Agregar..
        else if(divisionComando.length == 2){
            String[] amigosAgregar = divisionComando[1].split(",");
            Persona persona = getPersona(divisionComando[0]);
            Persona amigo;


            //recorres el array de amigos..
            for(int i = 0; i < amigosAgregar.length; i++){
                amigo = getPersona(amigosAgregar[i]);

                //Agregar amigo a persona y viceversa..
                persona.setAmigo(amigo);
                amigo.setAmigo(persona);
            }
        }

    }

    @Override
    public String toString() {
        return personas.toString();
    }

    private Persona getPersona(String nombre){
        //Validamos si existe persona, si existe se obtiene del Map personas, si no se agrega al Map..
        Persona persona;
        if(personas.containsKey(nombre)){
            persona = personas.get(nombre);
        }
        else{
            persona = new Persona(nombre);
            personas.put(nombre,persona);
        }
        return persona;
    }

    public List<Persona> buscar(String nombre, int nivel){
        List<Persona> amigosNivelN = new ArrayList<>();
        HashSet<Persona> hashAmigos = new HashSet<>();
        if(nivel == 1) return this.personas.get(nombre).getListaAmigos();
        else{
            for(int i = 0; i < nivel; i++){
                amigosNivelN.add(this.personas.get(nombre).getListaAmigos().get(i));
                hashAmigos.add(amigosNivelN);
            }
        }
        return amigosNivelN;
    }

}

