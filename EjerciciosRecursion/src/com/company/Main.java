package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();
        int[] arreglo = {1,2,3,4,5};
        int[] arregloVacio = {};
        List<Integer> listaVacia = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        while (true){

            System.out.println("Menu..\n" +
                    "1.- Sumar numeros de un arreglo.\n" +
                    "2.- Sumar numeros de una lista\n" +
                    "3.- Impresion de datos de una arreglo.\n" +
                    "4.- Factorial.\n" +
                    "5.- Fibonacci.\n" +
                    "6.- Busqueda binaria.\n" +
                    "7.- Convertir decimal a binario.\n" +
                    "8.- Elevar a una potencia un numero.\n" +
                    "9.- Funcion Ackerman.\n" +
                    "10.- Numeros Catalan.\n" +
                    "11.- Divisores.\n" +
                    "12.- Factores primos.\n" +
                    "13.- Euclides.\n" +
                    "14.- Codigo Grey.");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();


            switch (opcion){
                case 1:
                    System.out.println("La suma del arreglo {1,2,3,4,5} es: " + recursividad.sumaArreglo(arreglo, arreglo.length));
                    System.out.println("La suma de un arreglo vacio: " + recursividad.sumaArreglo(arregloVacio,arregloVacio.length));
                    break;
                case 2:
                    System.out.println("La suma de la lista [1,2,3,4,5] es: " + recursividad.sumaLista(list,list.size()));
                    System.out.println("La suma de la lista [] es: " + recursividad.sumaLista(listaVacia,listaVacia.size()));

                    break;
                case 3:
                    System.out.println("Impresion del arreglo {1,2,3,4,5}");
                    recursividad.imprimirArreglo(arreglo,arreglo.length);
                    recursividad.imprimirArreglo(arregloVacio,arregloVacio.length);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Agregue el numero para sacar el factorial.");
                    int numeroFacrtorial = scanner.nextInt();
                    if(numeroFacrtorial<0){
                        System.out.println("No se puede calcular el factorial de un numero negativo");
                    }else{
                        System.out.println("El factorial de " + numeroFacrtorial + " es: " + recursividad.factorial(numeroFacrtorial));
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el numero para sacar el Fibonacci con los tres metodos: ");
                    int numFib = scanner.nextInt();
                    System.out.print("El Fibonacci recursivo es: ");
                    long startTime = System.nanoTime();//System.currentTimeMillis();   //System.nanoTime();
                    System.out.print(recursividad.fibonacci(numFib));
                    long endTime = System.nanoTime() - startTime;
                    System.out.println(" Tiempo de ejecucion: " + endTime);
                    System.out.print("El fibonacci Iterativo es: ");
                    startTime = System.nanoTime();
                    System.out.print(recursividad.iterativoFibonacci(numFib));
                    endTime = System.nanoTime() - startTime;
                    System.out.println(" Tiempo de ejecucion: " + endTime);
                    System.out.print("El fibonacci guardando valores previos es: ");
                    startTime = System.nanoTime();
                    System.out.print(recursividad.fibonacciEstados(numFib));
                    endTime = System.nanoTime() - startTime;
                    System.out.println(" Timepo de ejecucion: " + endTime);
                    break;
                case 6:
                    System.out.println("Ingrese el numero que desea saber la posicioin en el siguiente arreglo {1,2,3,4,5} ");
                    int num = scanner.nextInt();
                    System.out.println("Busqueda binaria del arreglo {1,2,3,4,5} es: " + recursividad.busquedaBin(num,arreglo,list.size(),0));
                    break;
                case 7:
                    System.out.println("Ingrese el numero que desea convertir a binario");
                    int numDecimal = scanner.nextInt();
                    System.out.print("El numero en binario es: ");
                    System.out.println(recursividad.decimalBinario(numDecimal));
                    System.out.println();

                    break;
                case 8:
                    System.out.println("Ingrese el valor base");
                    int numeroBase = scanner.nextInt();
                    System.out.println("Ingrese el valor del exponente");
                    int numExponente = scanner.nextInt();
                    System.out.println("El valor de la potencia es: " + recursividad.elevarPotencia(numeroBase,numExponente));
                    break;
                case 9:
                    int m = scanner.nextInt();
                    int n = scanner.nextInt();
                    System.out.println("Funcion Ackerman: "+ recursividad.ackerman(m,n));
                    break;
                case 10:
                    System.out.println("Ingrese el numero catalan");
                    double numCatalan = scanner.nextInt();
                    System.out.println("Catalan: " + recursividad.numerosCatalanes(numCatalan));
                    break;
                case 11:
                    System.out.println("Ingrese los numeros para sacar sus divisores");
                    int num1 = scanner.nextInt();
                    int num2 = scanner.nextInt();
                    System.out.println(recursividad.divisores(num1,num2));
                    break;
                case 12:

                    break;
                case 13:
                    System.out.println("Ingresa un numero A");
                    int a = scanner.nextInt();
                    System.out.println("Ingresa el valor B");
                    int b = scanner.nextInt();
                    System.out.println("Euclides: "+recursividad.euclides(a,b));
                    break;
                case 14:
                    System.out.println("Codigo Gray. ");
                    int numGray = scanner.nextInt();
                    recursividad.gray(numGray);
                    break;
                default:
                    System.out.println("Ingrese una opcion del menú.");
                    break;



            }



        }
    }
}