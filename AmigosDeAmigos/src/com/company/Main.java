package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Arreglos con las listas necesarias para los niveles de amigos..
        List<String> amigosNivel1 = new ArrayList<>();
        List<String> amigosNivel2 = new ArrayList<>();
        List<String> amigosNivel3 = new ArrayList<>();
        List<String> listaFinal = new ArrayList<>();
        int n = 0;

        //Arbol de amigos de amigos de jose..
        Amigos jose = new Amigos("Jose","Valenzuela", 23,
                new Amigos("Hector", "Murillo", 23,
                        new Amigos("Juan", "Cardenas",32,
                                new Amigos("Alan", "Bojorquez", 18),
                               new Amigos("Ezequiel", "Diaz", 21),
                                new Amigos("Missael", "Bojoruez",27)),
                        new Amigos("Susan", "Orduño",21,
                                new Amigos("Fernando", "Lopez", 25),
                                new Amigos("Rosa","Quintero",32)),
                        new Amigos("Orlando", "Luna",23,
                                new Amigos("Karen","Aguilar",23))),
                new Amigos("Chester","Cheetos",35,
                        new Amigos("Abelino", "Reyes",24,
                                new Amigos("Fransisco","Alvarez",28),
                                new Amigos("Enrique","Aguilar",29)),
                        new Amigos("Zaid", "Espinoza", 23,
                                new Amigos("Esteban","Galvez",25),
                                new Amigos("Humberto","Lopez",23),
                                new Amigos("Manuel","Lizarraga",23))));

        //Agregas los amigos de cada nivel a una  lista para despues agregarla a una lista final
        for(Amigos aN1 : jose){
            amigosNivel1.add(aN1.toString());
            for(Amigos aN2 : aN1){
                amigosNivel2.add(aN2.toString());
                for(Amigos aN3 : aN2){
                    amigosNivel3.add(aN3.toString());
                }
            }
        }


        //Agrega la lista de los amigos de todos los niveles a una lista final
        listaFinal.add(amigosNivel1.toString());
        listaFinal.add(amigosNivel2.toString());
        listaFinal.add(amigosNivel3.toString());

        //Indicas el nivel de amigos que desees conocer y se extrae el elemento y lo imprime una lista
        System.out.println("Ingresa el nivel de amigos de Jose que deseas conocer");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt() - 1;
        System.out.println(listaFinal.get(n));


    }
}
