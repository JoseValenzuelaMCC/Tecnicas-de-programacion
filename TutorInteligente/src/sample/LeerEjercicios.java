package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerEjercicios  {
    private List<String> listaEjercicios = new ArrayList<>();

    public LeerEjercicios() throws IOException {
        String cadena; //nombre del archivo txt
        FileReader file = new FileReader("C:\\Users\\JoseA\\IdeaProjects\\AppAmigos\\src\\com\\company\\Ejercicios");
        BufferedReader buffer = new BufferedReader(file);

        while((cadena = buffer.readLine())!=null) {
            listaEjercicios.add(cadena.toLowerCase());
        }
        buffer.close();

    }

}
