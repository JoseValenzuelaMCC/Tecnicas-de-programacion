package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
       Bicycle bici = new Bicycle(10,25,14);
        bici.speedUp(12);
        System.out.println(bici.speed());

    }

}