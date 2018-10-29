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

            switch (opcion){
                case 1:
                    Scanner scn1 = new Scanner(System.in);
                    String comandoBuscar = scn1.nextLine();
                    grafo.leerComandos(comandoBuscar); break;
                case 2:
                    Scanner scn2 = new Scanner(System.in);
                    String comandoAgregar = scn2.nextLine();
                    grafo.leerComandos(comandoAgregar); break;
                case 3: System.exit(1); break;
                default:
                    System.out.println("Ingresa una opcion valida");
                    break;
            }
        }
    }
}
