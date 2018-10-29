package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoTexto{

    private List<String> listaAmigos = new ArrayList<>();

    public ArchivoTexto() throws IOException {
        String cadena; //nombre del archivo txt
        FileReader file = new FileReader("C:\\Users\\JoseA\\IdeaProjects\\AppAmigos\\src\\com\\company\\ListaAmigos");
        BufferedReader buffer = new BufferedReader(file);

        while((cadena = buffer.readLine())!=null) {
            listaAmigos.add(cadena.toLowerCase());
        }
        buffer.close();
    }

    public List<String> getListaAmigos(){ return listaAmigos;}
}
