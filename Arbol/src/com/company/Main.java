package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion = 0;

        SBinaryTree sBinaryTree = new SBinaryTree();
        sBinaryTree.insertar(50);
        sBinaryTree.insertar(30);
        sBinaryTree.insertar(25);
        sBinaryTree.insertar(41);
        sBinaryTree.insertar(3);
        sBinaryTree.insertar(35);
        sBinaryTree.insertar(48);
        sBinaryTree.insertar(58);
        sBinaryTree.insertar(90);
        sBinaryTree.insertar(60);
        sBinaryTree.insertar(15);

        while (true) {
            System.out.println("Menu... \nElige una opcion:\n" +
                    "1.- Agregar nodo al arbol.\n" +
                    "2.- Busca.\n" +
                    "3.- Tamaño del arbol.\n" +
                    "4.- Numero de Hijos del Nodo(n).\n" +
                    "5.- Encuentra el padre del Nodo(n).\n" +
                    "6.- Blance de un Nodo.\n" +
                    "7.- Elemento mayor del arbol binario\n" +
                    "8.- Obtener los nodos de una generacion.\n" +
                    "9.- Promedio\n" +
                    "10.- Salir.");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Agrega el valor del nodo a agregar: ");
                    Scanner scanner1 = new Scanner(System.in);
                    sBinaryTree.insertar(scanner1.nextInt());
                    break;
                case 2:
                    System.out.println("Agrega el dato del nodo a buscar: ");
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println(sBinaryTree.busca(scanner2.nextInt()));
                    break;
                case 3:
                    System.out.println("El tamaño del arbol es:" + sBinaryTree.tamano());
                    break;
                case 4:
                    System.out.println("Agrega el dato del Nodo para el cual se quiere saber el numero de hijos.");
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Numero de hijos del nodo es: " + sBinaryTree.nHijos(scanner3.nextInt()));
                    break;
                case 5:
                    System.out.println("Agrega el dato del nodo para el cual deseas conocer el padre.");
                    Scanner scanner4 = new Scanner(System.in);
                    if (sBinaryTree.padreN(scanner4.nextInt()) != null) {
                        System.out.println("El padre del nodo es: " + sBinaryTree.padreN(scanner4.nextInt()).dato);
                    } else {
                        System.out.println("El nodo no existe o es el nodo Raiz y por lo tanto no tiene padre.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el dato del nodo a buscar su balance.");
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("El balance del nodo es:" + sBinaryTree.balance(scanner5.nextInt()));
                    break;
                case 7:
                    System.out.println("El elemento mayor del arbol es: " + sBinaryTree.nodoMayor());
                    break;
                case 8:
                    System.out.println("Que generacion deseas conocer? ");
                    Scanner scanner6 = new Scanner(System.in);
                    int gen = scanner6.nextInt();
                    System.out.println("Los nodos de la generacion " + gen + " es: " + sBinaryTree.nodosGeneracion(gen));
                    break;
                case 9:
                    System.out.println("El promedio del arbol es: " + sBinaryTree.promedio());
                    break;
                case 10:
                    System.exit(-1);
                    break;
            }
        }
    }
}
