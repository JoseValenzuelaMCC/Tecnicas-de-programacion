package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here


        ContactsManager myContactsManager = new ContactsManager();
        while(true){
        System.out.println("Opcion 1: Agregar contacto\nOpcion 2: Buscar un contacto\nOpcion 3: Salir");
        Scanner scanner5 = new Scanner(System.in);
        int option = scanner5.nextInt();

            if (option == 1) {
                System.out.println("Agrega el nombre del contacto");
                Scanner scanner1 = new Scanner(System.in);
                String name = scanner1.next();

                System.out.println("Agrega el email del contacto");
                Scanner scanner2 = new Scanner(System.in);
                String email = scanner2.next();

                System.out.println("Agrega el numero del contacto");
                Scanner scanner3 = new Scanner(System.in);
                String phoneNumber = scanner3.next();

                //Adding a new contact
                Contact a = new Contact(name, email, phoneNumber);
                myContactsManager.addContact(a);

                option = scanner5.nextInt();
            } else if (option == 2) {
                System.out.println("Escriba el nombre del contacto:");
                Scanner scanner0 = new Scanner(System.in);
                String contactToSearch = scanner0.next();
                //Printing a specific contact
                myContactsManager.searchContact(contactToSearch);
                System.out.println(myContactsManager.searchContact(contactToSearch).phoneNumber);
                option = scanner5.nextInt();
            } else if (option == 3) {
                System.exit(0);
            }

        }
    }
}

