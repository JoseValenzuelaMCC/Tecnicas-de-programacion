package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre, int puntuacion){
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public void datosJugador() throws IOException {
        String ruta = "C:\\Users\\JoseA\\IdeaProjects\\Buscaminas\\src\\com\\company\\DatosDelJugador";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()){
            //El fichero ya existe..
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Nombre: " + nombre + "\nPuntuacion: " + puntuacion);
        }else{
            //El fichero no existe, hay que crearlo..
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Nombre: " + nombre + "\n Puntuacion: " + puntuacion);
        }
        bw.close();
    }


}
