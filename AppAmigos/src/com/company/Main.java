package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String comandos;
        Grafo grafo = new Grafo();

        ArchivoTexto archivoTexto = new ArchivoTexto();
        for (int i = 0; i<archivoTexto.getListaAmigos().size(); i++ ){
            comandos = archivoTexto.getListaAmigos().get(i);
            grafo.leerComandos(comandos);
        }

        while (true){
            System.out.println("Eliga una opcion.. \n1 - Agregar amigo. \n2 - Buscar amigos. \n3 - Salir. " );
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            Scanner scn1 = new Scanner(System.in);
            String comando = scn1.nextLine();
            switch (opcion){
                case 1: grafo.leerComandos(comando) ; break;
                case 2: grafo.leerComandos(comando) ;break;
                case 3: System.exit(-1);break;


            }
        }
    }
}
