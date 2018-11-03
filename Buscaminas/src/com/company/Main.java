package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Jugador jugador = new Jugador("Nancy", 0);
        jugador.datosJugador();

        LogicaDelJuego buscaminas= new LogicaDelJuego();
        buscaminas.iniciarJuego();
    }
}
