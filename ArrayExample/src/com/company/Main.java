package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        Persona persona1 = new Persona("Jose","Valenzuela",i);
        String name = persona1.getName();
        System.out.println(name);

        /*System.out.println(i);
        if (i == 5){
            System.out.println("Es 5");
        }*/
    }
}
