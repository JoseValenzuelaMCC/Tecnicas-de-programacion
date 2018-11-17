package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private Estado estatus = Estado.JUGANDO;

    public Jugador(){
    }

    public void guardarDatos() throws IOException {
        String ruta = "C:\\Users\\JoseA\\IdeaProjects\\Buscaminas\\src\\com\\company\\DatosDelJugador";
        File archivo = new File(ruta);
        BufferedWriter bw;
        //if(archivo.exists()){
        //El fichero ya existe..
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("Nombre: " + nombre + "\nPuntuacion: " + puntuacion);
       /* }else{
            //El fichero no existe, hay que crearlo..
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Nombre: " + nombre + "\n Puntuacion: " + puntuacion);
        }*/
        bw.close();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() { return nombre; }

    public int getPuntuacion() { return puntuacion; }

    public Estado getEstatus() { return estatus; }

    public void setEstatus(Estado estatus) { this.estatus = estatus; }
}