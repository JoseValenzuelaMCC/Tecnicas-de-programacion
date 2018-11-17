package com.company;

import java.io.IOException;
import java.util.Scanner;

public class LogicaDelJuego {

    private CampoDeMinas tablero = null;
    private int cont = 0;
    private long startTime = 0,endTime = 0;
    private String nombre;
    private Jugador jugador = new Jugador();
    private Scanner sc = new Scanner(System.in);

    public LogicaDelJuego(){

    }

    public void iniciarJuego() throws IOException {
        while (this.jugador.getEstatus() == Estado.JUGANDO){
            juegoNuevo();
        }
    }

    private void juegoNuevo() throws IOException {

        System.out.println("Ingresa el nombre: ");
        nombre = sc.next();
        jugador.setNombre(nombre);
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
                    this.tablero = new CampoDeMinas(8, 8, 10);
                    tablero.llenarTablero();
                    setAllHide(tablero);
                    tablero.imprimir();
                    setAllHide(tablero);
                    tablero.imprimir();
                    jugar(64, 10);
                    break;
                case 2:
                    this.tablero = new CampoDeMinas(16, 16, 40);
                    tablero.llenarTablero();
                    setAllHide(tablero);
                    tablero.imprimir();
                    setAllHide(tablero);
                    tablero.imprimir();
                    jugar(256, 1);
                    break;
                case 3:
                    this.tablero = new CampoDeMinas(16, 30, 99);
                    tablero.llenarTablero();
                    setAllHide(tablero);
                    tablero.imprimir();
                    setAllHide(tablero);
                    tablero.imprimir();
                    jugar(480, 99);
                    break;
                case 4:
                    System.out.println("Ingresa el numero de filas: ");
                    int X = sc.nextInt();
                    System.out.println("Ingresa el numero de columnas: ");
                    int Y = sc.nextInt();
                    System.out.println("Ingresa el numero de minas: ");
                    int minas = sc.nextInt();
                    this.tablero = new CampoDeMinas(X, Y, minas);
                    tablero.llenarTablero();
                    setAllHide(tablero);
                    tablero.imprimir();
                    setAllHide(tablero);
                    tablero.imprimir();
                    jugar(X * Y, minas);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Introduce una opción valida!!");
                    break;
            }
    }

    private void jugar(int numCasillas, int numMinas) throws IOException {
        int numCasillasSinMinas = numCasillas - numMinas;
        boolean perdiste = false;

        startTime = System.currentTimeMillis();
        do {
            System.out.println("Numero de casillas destapadas: " + cont);

            System.out.println("1 - Despejar casilla: \n" +
                    "2 - Colocar/quitar Bandera \n" +
                    "Ingrese una de las opciones anteriores..");
            String opcion = sc.next();
            System.out.println("Ingrese la instruccion con el siguiente formato: 1,1 ");
            switch (opcion){
                case "1":

                   // Scanner sc = new Scanner(System.in);
                    String casillaMostrar = sc.next();
                    String[] coordenadas  = casillaMostrar.split(",");
                    try{
                        if(this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1].isFlag()){
                            System.out.println("Esta casilla tiene Bandera");
                        }else{
                            if(this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1].isHide())
                            mostrarCasilla(Integer.parseInt(coordenadas[0])-1, Integer.parseInt(coordenadas[1])-1);
                            else{
                                System.out.println("Esta casilla ya fue destapada. Intentalo de nuevo.");
                            }
                        }
                        if(this.tablero.getTablero()[Integer.parseInt(coordenadas[0]) - 1][Integer.parseInt(coordenadas[1]) - 1].getMina()){
                            perdiste = true;
                    }}catch (Exception ex){
                        System.out.println("Esta casilla no existe.. intentalo de nuevo");
                    }
                    this.tablero.imprimir();
                    break;
                case "2":
                   // Scanner scanner1 = new Scanner(System.in);
                    String casillaBandera = sc.next();
                    String[] coordBandera  = casillaBandera.split(",");
                    bandera(Integer.parseInt(coordBandera[0]) - 1, Integer.parseInt(coordBandera[1]) - 1);
                    this.tablero.imprimir();
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
            }
        }while ((cont != numCasillasSinMinas) && (!perdiste));
        if(perdiste){
            this.jugador.setEstatus(Estado.PERDISTE);
            System.out.println(jugador.getEstatus());
        }
        else{
            this.jugador.setEstatus(Estado.GANASTE);
            System.out.println(jugador.getEstatus());
        }
        endTime = (System.currentTimeMillis() - startTime)/1000;
        jugador.setPuntuacion((int)endTime);
        jugador.guardarDatos();
        System.out.println("Deseas continuar jugando?");
        String resp = sc.next();
        resp = resp.toLowerCase();
        if(resp.equals("si")){
            jugador.setEstatus(Estado.JUGANDO);
        }
    }

    private void mostrarCasilla(int x, int y){
        try{
            if(this.tablero.getTablero()[x][y].getValor() > 0){
                this.tablero.getTablero()[x][y].setHide(false);
                cont++;
            } else if(this.tablero.getTablero()[x][y].getValor() == 0){
                this.tablero.getTablero()[x][y].setHide(false);
                cont++;
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
            this.tablero.getTablero()[x][y].setFlag(false);
            this.tablero.getTablero()[x][y].setMina(true);
        }else{
            this.tablero.getTablero()[x][y].setMina(false);
            this.tablero.getTablero()[x][y].setFlag(true);
        }
    }

    private void setAllHide(CampoDeMinas tab){
        for (int i =0; i<tab.getTablero().length;i++){
            for(int j = 0; j < tab.getTablero()[0].length;j++){
                if(tab.getTablero()[i][j].isHide()){
                    tab.getTablero()[i][j].setHide(false);
                }else {
                    tab.getTablero()[i][j].setHide(true);
                }

            }
        }
    }
}
