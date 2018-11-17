package sample;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio {
    ArrayList<EjercicioModel> ejercicios;
    Random rand = new Random();

    public Ejercicio() throws FileNotFoundException {
        Gson gson = new Gson();
        String path = "C:\\Users\\JoseA\\IdeaProjects\\TutorInteligente\\src\\sample\\JsonEjercicios.json";
        String json = "";

        Scanner archivo = new Scanner(new File(path));
        while (archivo.hasNextLine()){
            json += archivo.nextLine();
        }

        EstructuraEjercicios estructura = gson.fromJson(json,EstructuraEjercicios.class);
        this.ejercicios = estructura.getEjercicios();
    }

    public EjercicioModel getEjercicio(Nivel nivelActual){
        ArrayList<EjercicioModel> ejerciciosActual = new ArrayList<>();
        for( EjercicioModel ejercicio : this.ejercicios){
            if(ejercicio.getNivel() == nivelActual){
                ejerciciosActual.add(ejercicio);
            }
        }

        int posicionEjercicio = rand.nextInt(ejerciciosActual.size());

        return ejerciciosActual.get(posicionEjercicio);
    }
}
