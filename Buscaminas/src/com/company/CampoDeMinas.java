package com.company;

import java.util.Random;

public class CampoDeMinas {

    private int coordX;
    private int coordY;
    private int numMinas;
    private int columnas;
    private int filas;
    Casilla[][] tablero = null;

    public CampoDeMinas(int coordX, int coordY, int numMinas) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.numMinas = numMinas;
        this.tablero = new Casilla[coordX][coordY];
    }

    //Casillas casilla = new Casillas();


    public void llenarTablero() {
        Random rnd = new Random();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                this.tablero[i][j] = new Casilla();
                columnas = rnd.nextInt(coordY);
                filas = rnd.nextInt(coordX);
                if ((i == filas) && (j == columnas)) {
                    tablero[i][j].setMina(true);
                    System.out.println("Es true" + i + j);
                }
            }
        }
    }


    public void imprimir() {

        System.out.print("    ");
        for (int i = 1; i <= this.coordY; i++) {
            System.out.print(String.format("%2s %1s", i, " "));
        }

        System.out.println();

        for (int i = 0; i < this.coordX; i++) {

            System.out.print(String.format("%2s ", i + 1));
            System.out.print("|");
            for (int j = 0; j < this.coordY; j++) {
                Casilla cas = this.tablero[i][j];

                //System.out.print(String.format("%2s %1s", cas.getMina(), "|"));
//
                if(cas.getMina()){
                    System.out.print(String.format("%2s %1s", "*", "|"));
                }else {
                    System.out.print(String.format("%2s %1s", "-", "|"));
                }

            }
            System.out.println();
        }
    }

}
