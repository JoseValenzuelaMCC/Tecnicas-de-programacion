package com.company;

public class Main {

    public static void main(String[] args) {

       Person jose = new Person("Jose", "Valenzuela", 49,
                new Person("Nadya","Valenzuela", 18, new Person("sdf", "sdfsdf", 54)),
                new Person("Chavo","Valenzuela", 16));

        // Iterate over the kids
        for (Person amigo : jose)
        {
            String amigosDeAmigos = amigo.getFisrtName();
            System.out.println(amigosDeAmigos);
            System.out.println(amigo.toString());
        }




    }
}
