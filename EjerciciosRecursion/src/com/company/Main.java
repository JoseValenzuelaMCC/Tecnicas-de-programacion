package com.company;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();




        if(recursividad.factorial(-2) > 0){
            System.out.println(recursividad.factorial(-2));
        }
        else{
            System.out.println("Error: El factorial de un numero negativo no existe.");
        }

        //recursividad.decimalBinario(23);
        System.out.println(recursividad.euclides(10000,1145));
    }
}