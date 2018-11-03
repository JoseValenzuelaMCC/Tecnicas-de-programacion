package com.company;

import java.util.Scanner;

public class LogicaDelJuego {

    CampoDeMinas tablero = null;

    public LogicaDelJuego(){

    }


    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("BUSCAMINAS");
        System.out.println("=========================");
        System.out.println("Menu:");
        System.out.println("1: Jugar Nivel Principiante");
        System.out.println("2: Jugar Nivel Intermedio");
        System.out.println("3: Jugar Nivel Avanzado");
        System.out.println("4: Jugar Nivel perzonalizado");
        System.out.println("5: Salir");
        System.out.println("");
        System.out.print("Selecciona una opción del 1 al 5: ");
        int opcion = sc.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                this.tablero = new CampoDeMinas(3,3,1);
                tablero.llenarTablero();
                jugar( 9,1);
                break;
            case 2:
                this.tablero = new CampoDeMinas(2,2,1);
                tablero.llenarTablero();
                //jugar(tablero2);
                break;
            case 3:
                this.tablero = new CampoDeMinas(2,2,1);
                tablero.llenarTablero();
                //jugar(tablero3);
                break;
            case 4:
                System.out.println("Ingresa el numero de filas: ");
                Scanner sc1 = new Scanner(System.in);
                int X = sc1.nextInt();
                System.out.println("Ingresa el numero de columnas: ");
                Scanner sc2 = new Scanner(System.in);
                int Y = sc2.nextInt();
                System.out.println("Ingresa el numero de minas: ");
                Scanner scanner = new Scanner(System.in);
                int minas = scanner.nextInt();

                this.tablero = new CampoDeMinas(X,Y,minas);
                tablero.llenarTablero();
                jugar(X * Y , minas);

                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Introduce una opción valida!!");
                break;
        }
    }

    private void jugar(int numCasillas, int numMinas){
        //this.tablero.imprimir();
        int cont = 0;
        int numCasillasSinMinas = numCasillas - numMinas;
        boolean perdiste = false;
        do {
            System.out.println("1 - Despejar casilla \n" +
                    "2 - Colocar/quitar Bandera \n");
            this.tablero.imprimir();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    Scanner sc = new Scanner(System.in);
                    String casillaMostrar = sc.next();
                    String[] coordenadas  = casillaMostrar.split(",");
                    mostrarCasilla(Integer.parseInt(coordenadas[0])-1, Integer.parseInt(coordenadas[1])-1);
                    if(this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1].getMina()){
                        perdiste = true;
                    }
                    this.tablero.imprimir();
                    cont++;
                    break;
                case 2:
                   // this.tablero.imprimir();
                    Scanner scanner1 = new Scanner(System.in);
                    String casillaBandera = scanner1.next();
                    String[] coordBandera  = casillaBandera.split(",");
                    bandera(Integer.parseInt(coordBandera[0]) - 1, Integer.parseInt(coordBandera[1]) - 1);
                    this.tablero.imprimir();
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
            }
        }while ((cont != numCasillasSinMinas) && (!perdiste));
        if(perdiste) System.out.println("Perdiste!! :(");
        else{
            System.out.println("Ganaste!!");
        }
    }

    private void mostrarCasilla(int x, int y){
        try{
            if(this.tablero.getTablero()[x][y].getValor() > 0){
                this.tablero.getTablero()[x][y].setHide(false);
            } else if(this.tablero.getTablero()[x][y].getValor() == 0){
                this.tablero.getTablero()[x][y].setHide(false);
                recursionValores(x,y);
            }
        }catch (Exception ignored){}
    }

    private void recursionValores( int x, int y){
        for(int i = x-1; i <= x+1; i++){
            for(int j = y -1; j <= y+1; j++){
                try{
                    if(this.tablero.getTablero()[i][j].isHide())
                      mostrarCasilla(i,j);
                }catch (Exception ignored){}
            }
        }
    }

    private void bandera(int x, int y){
        if(this.tablero.getTablero()[x][y].isFlag()){
            //this.tablero.getTablero()[x][y].setHide(false);
            this.tablero.getTablero()[x][y].setFlag(false);
            this.tablero.getTablero()[x][y].setMina(true);
        }else{
            this.tablero.getTablero()[x][y].setMina(false);
            this.tablero.getTablero()[x][y].setFlag(true);
        }
    }
}
