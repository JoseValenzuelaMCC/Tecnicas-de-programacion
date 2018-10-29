package com.company;

import java.util.*;

public class Grafo {
    private HashMap<String, Persona> personas = new HashMap();

    private HashSet<Persona> pasados = new HashSet<>();

    private HashMap<Integer, Set> niveles = new HashMap<Integer, Set>();

    public Grafo(){

    }

    public void leerComandos(String comando){
        int nivel = 1;
        String nombre;
        String[] divisionComando = comando.split("-");
        
        //Se verifica si el tamaño de la division del comando es 1 o 2, en caso de ser 1 nos dice que el
        //comando es para buscar el nivel de amigos de alguna persona, si es 2 se va agregar un amigo..

        //Buscar
        if(divisionComando.length == 1){
            divisionComando = divisionComando[0].split(" ");

            nombre = divisionComando[0];
            nivel = divisionComando.length == 1 ? 1 : Integer.parseInt( divisionComando[1] );

            this.buscarAmigos( nombre.toLowerCase(), nivel );
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

    private void buscarAmigos(String nombre, int nivel){
        int cont = 1;
        Persona persona = this.getPersona(nombre);
        List<Persona> amigos = persona.getListaAmigos();

        this.niveles.clear();
        this.pasados.clear();

        this.pasados.add(persona);


        do{
            HashSet<Persona> nivelHasSet = new HashSet<>();

            niveles.put(cont,  nivelHasSet );

            if( cont == 1 ){
                // Recorremos los amigos
                for( Persona amigo: amigos ){

                    // Validamos si ya fue filtrado
                    if( this.pasados.add( amigo ) ){
                        nivelHasSet.add( amigo );
                    }
                }
            }
            else{

                /* En el set nivelAnteior agregamos el set de amigos que anteriormente fueron agregados al map niveles,
                esto para verificar si los amigos del siguiente nivel no han sido repetidos*/
                Set<Persona> nivelAnterior = niveles.get( cont -1 );
                /*Recorremos todas las personas del nivel anterior para obtener sus amigos y posteriormente recorrerlos
                para verificar si se puede o no agregar al hashSet pasados y asi agregar o no al map de niveles
                el cual se imprimira al finalizar la condicion del while..*/
                for(Persona personaNivelAnterior : nivelAnterior ){
                    amigos = personaNivelAnterior.getListaAmigos();

                    /*Se recorren la lista de amigos de las personas del nivel aterior para realizar otro filtrado de peronas
                    y evitar repetirlas en otros niveles */
                    for( Persona amigo: amigos ){

                        // Validamos si ya fue filtrado
                        if( this.pasados.add( amigo ) ){
                            nivelHasSet.add( amigo );
                        }
                    }
                }
            }

            cont++;
        }while( cont <= nivel );

        System.out.println("Buscando los amigos de nivel " + nivel + " de  " + nombre.toUpperCase() );
        System.out.println( niveles.get(nivel) );
        System.out.println("\n\n");



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

}

