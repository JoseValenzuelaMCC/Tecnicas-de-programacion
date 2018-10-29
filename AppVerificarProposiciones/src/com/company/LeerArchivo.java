package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class LeerArchivo {

    private List<String> proposicion =new ArrayList<>();

    public LeerArchivo() throws FileNotFoundException, IOException {
        String cadena; //nombre del archivo txt
        FileReader file = new FileReader("C:\\Users\\JoseA\\IdeaProjects\\AppVerificarProposiciones\\src\\com\\company\\ListaInfijos");
        BufferedReader buffer = new BufferedReader(file);

        while((cadena = buffer.readLine())!=null) {
            proposicion.add(cadena.toLowerCase());
        }
        buffer.close();

    }


    public List<String> getFormulas(){
        return proposicion;
    }


}
