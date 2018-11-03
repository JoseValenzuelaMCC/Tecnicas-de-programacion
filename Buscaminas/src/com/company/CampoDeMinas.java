package com.company;

import java.util.Random;

public class CampoDeMinas {

    private int coordX;
    private int coordY;
    private int numMinas;
    Casilla[][] tablero = null;

    public CampoDeMinas(int coordX, int coordY, int numMinas) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.numMinas = numMinas;
        this.tablero = new Casilla[coordX][coordY];
    }

    public void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                this.tablero[i][j] = new Casilla();
            }
        }
        colocarMinas();
    }

    private void colocarMinas() {
        Random rnd = new Random();
        int cont = 0;
        do {
            int x = rnd.nextInt(coordX);
            int y = rnd.nextInt(coordY);
            if (!tablero[x][y].getMina()) {
                cont++;
                tablero[x][y].setMina(true);
                llenarValores(x,y);
            }
        } while (cont < numMinas);
    }

    private void llenarValores(int x, int y){
        for(int i = x -1; i <= x +1; i++){
            for(int j = y -1; j <= y+1; j++){
                try{
                    tablero[i][j].incrementarValor();
                }catch (Exception ignored){}
            }
        }
    }

    public Casilla[][] getTablero() {
        return tablero;
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
                if(cas.isHide() && !cas.isFlag()){
                    System.out.print(String.format("%2s %1s", "-", "|"));
                }else if(cas.getMina() && !cas.isFlag()){
                    System.out.print(String.format("%2s %1s", "*", "|"));
                }else if(cas.isFlag()){
                    System.out.print(String.format("%2s %1s", "P", "|"));
                }else{
                    System.out.print(String.format("%2s %1s", cas.getValor(), "|"));
                }

            }
            System.out.println();
        }
    }

}

    /*Casilla casillaActual = this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1];
                    if(casillaActual.isFlag()){
                            mostrarCasilla(Integer.parseInt(coordenadas[0])-1, Integer.parseInt(coordenadas[1])-1);
                            if(this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1].getMina()){
                            perdiste = true;
                            }
                            cont++;
                            }
                            this.tablero.imprimir();
                            break;*/