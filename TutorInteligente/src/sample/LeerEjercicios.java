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
        FileReader file = new FileReader("D:\\Test\\output.txt");
        BufferedReader buffer = new BufferedReader(file);

        while((cadena = buffer.readLine())!=null) {
            listaEjercicios.add(cadena.toLowerCase());
        }
        buffer.close();
    }

    public String getResultado() {
        return listaEjercicios.get(10);
    }
}
