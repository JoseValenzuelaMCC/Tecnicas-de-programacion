package com.company;

import java.util.Scanner;

public class Main {

    public static char[][] matriz = new char[17][31];
    public static char[][] matriz2 = new char[17][31];
    public static int filas = 0;
    public static int columnas = 0;
    public static int minas = 0;
    public static int mov1 = 0;
    public static int mov2 = 0;
    public static int win = 0;
    public static boolean fipartida = false;
    public static boolean debug = false;
    public static int count = 0;
    public static boolean fi = false;

    public static void main(String[] args) {
        CampoDeMinas tab = new CampoDeMinas(8,8,15);
        tab.llenarTablero();
        tab.imprimir();


    }

   /* public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("BUSCAMINAS");
        System.out.println("=========================");
        System.out.println("Menu:");
        System.out.println("1. Jugar Nivel Principiante");
        System.out.println("2. Jugar Nivel Intermedio");
        System.out.println("3. Jugar Nivel Avanzado");
        System.out.println("4. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción [1-5]: ");
        int opcion = sc.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                CampoDeMinas tablero = new CampoDeMinas(9,9,10);
                tablero.llenarTablero();
                tablero.imprimir();
                break;
            case 2:
                filas = 17;
                columnas = 17;
                minas = 40;
                win = (16 * 16) - 40;
                break;
            case 3:
                filas = 17;
                columnas = 31;
                minas = 99;
                win = (16 * 30) - 99;
                break;
            case 4:
                fi = true;
                System.exit(0);
                break;
            default:
                System.out.println("Introduce una opción valida!!");
                break;
        }
    }*/


}
