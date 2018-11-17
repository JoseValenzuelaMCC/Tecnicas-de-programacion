package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recursividad {

    public Recursividad() {

    }

    public double elevarPotencia(int base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) {
            return (1 / (elevarPotencia(base, exponente * -1)));
        } else {
            if (exponente == 1) return base;
            else return base * elevarPotencia(base, exponente - 1);
        }
    }

    public int fibonacci(int n) {
        if (n < 0) return -1;
        else return numFibonacci(n);
    }

    private int numFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return numFibonacci(n - 1) + numFibonacci(n - 2);
    }

    public int iterativoFibonacci(int n) {
        if (n < 0) return -1;
        else return jiterativoFibonacci(n);
    }

    private int jiterativoFibonacci(int n) {
        int resultado = 1;
        int n1 = 0;
        if (n == 0) return 0;
        else {
            for (int i = 0; i < n - 2; i++) {
                resultado = resultado + n1;
                n1 = resultado - n1;
            }
            return resultado + n1;
        }
    }

    public String fibonacciEstados(int numero) {
        if (numero < 0) return "Excepcion: No se puede calcular el fibonacci de un numero negativo.";
        else return jfibonacciEstados(numero);
    }

    private String jfibonacciEstados(int numero) {
        int fibo = 2, fibo1 = 1, fibo2 = 0;
        String estado = "" + 0;

        if (numero == 0) {
            fibo = 0;
            estado = "" + fibo;
        } else if (numero == 1) {
            fibo = 1;
            estado = "" + fibo;
        } else {
            for (int i = 0; i < numero; i++) {
                fibo = fibo1 + fibo2;
                estado = "" + estado + " " + fibo;
                fibo1 = fibo2;
                fibo2 = fibo;
            }
        }
        return estado;
    }

    public int factorial(int n) {
        if (n < 0) return -1;
        else return nFactorial(n);
    }

    private int nFactorial(int num) {
        if (num == 0) return 1;
        else if (num == 1) return 1;
        else return num * factorial(num - 1);
    }

    public int sumaArreglo(int[] arreglo, int size) {
        if (size == 0) return 0;
        else if (size == 1) return arreglo[0];
        else return arreglo[size - 1] + sumaArreglo(arreglo, size - 1);
    }

    public int multiplicacionArreglo(List<Integer> arreglo, int size) {
        if (size == 0) return 0;
        else if (size == 1) return arreglo.get(0);
        else return arreglo.get(size - 1) * multiplicacionArreglo(arreglo, size - 1);
    }

    public void imprimirArreglo(int[] arreglo, int size) {
        if (size == 0) System.out.println("");
        else if (size == 1) System.out.print(arreglo[0]);
        else {
            System.out.println(arreglo[size - 1]);
            imprimirArreglo(arreglo, size - 1);
        }
    }

    public int sumaLista(List<Integer> list, int size) {
        if (size == 0) return 0;
        else if (size == 1) return list.get(0);
        else return list.get(size - 1) + sumaLista(list, size - 1);
    }

    public int ackerman(int m, int n) {
        if (m < 0) return -1;
        return funcionAckermann(m, n);
    }

    private int funcionAckermann(int m, int n) {
        int Ackerman = 0;
        if (m == 0) return n + 1;
        else if (m > 0 && n == 0) Ackerman = funcionAckermann(m - 1, 1);
        else if (m > 0 && n > 0) Ackerman = funcionAckermann(m - 1, funcionAckermann(m, n - 1));
        return Ackerman;
    }

    public double numerosCatalanes(double n) {
        if (n < 0) return -1;
        else if (n == 0) return 1;
        else return ((2 * (2 * n - 1)) / (n + 1)) * numerosCatalanes(n - 1);
    }

    public int busquedaBin(int n, int[] arreglo, int limiteSuperior, int limiteInferior) {
        boolean flag = false;
        if (arreglo == null) return -1;
        for (int i = 0; i < limiteSuperior; i++) {
            if (n == arreglo[i]) {
                flag = true;
            }
        }
        if (flag) return busquedaBinaria(n, arreglo, limiteSuperior, limiteInferior);
        else return -1;
    }

    private int busquedaBinaria(int n, int[] arreglo, int limiteSuperior, int limiteInferior) {
        int posicion = (limiteInferior + limiteSuperior) / 2;

        if (n == arreglo[posicion]) return posicion;
        else {
            if (arreglo[posicion] > n) {
                limiteSuperior = posicion - 1;
                return busquedaBinaria(n, arreglo, limiteSuperior, limiteInferior);
            } else {
                limiteInferior = posicion + 1;
                return busquedaBinaria(n, arreglo, limiteSuperior, limiteInferior);
            }
        }
    }

    //public void

    public String decimalBinario(int decimal) {
        String binario = "";
        if (decimal < 0) {
            binario += "No se puede convertir un numero decimal negativo a binario";
        } else {
            if (decimal < 2) binario += decimal;
            else {
                binario += decimalBinario(decimal / 2);
                binario += decimal % 2;
            }
        }
        return binario;
    }

    public int euclides(int p, int q) {
        if (q == 0) return p;
        else {
            return euclides(q, p % q);
        }
    }

    public int divisores(int num1, int num2) {
        int mcd = 0;
        ArrayList list1;
        ArrayList list2;
        ArrayList list3 = new ArrayList();

        list1 = dividir(num1);
        list2 = dividir(num2);

        if (list1.size() > list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i)))
                    list3.add(list1.get(i));
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                if (list1.contains(list2.get(i)))
                    list3.add(list2.get(i));
            }
        }

        for (int i = 0; i < list3.size(); i++) {
            if ((int) list3.get(i) > mcd) {
                mcd = (int) list3.get(i);
            }
        }
        return mcd;
    }

    private ArrayList dividir(int num) {
        ArrayList divisores = new ArrayList();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                divisores.add(i);
        }
        return divisores;
    }

    public void factoresPrimos(int n) {
        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                n = n / i;
                System.out.print(i + "  ");
                //Para evitar hacer cálculos innecesarios :
                if (n == 1) {
                    System.exit(0);
                }
            }
        }
    }

    public void gray(int n) {
        String a = "";
        inversoGray(a, n);
    }

    private void inversoGray(String palabra, int n) {
        if (n == 0) System.out.println(palabra);
        else {
            codigoGray(palabra + "1", n - 1);
            inversoGray(palabra + "0", n - 1);
        }
    }

    private void codigoGray(String palabra, int n) {
        if (n == 0) System.out.println(palabra);
        else {
            codigoGray(palabra + "0", n - 1);
            inversoGray(palabra + "1", n - 1);
        }
    }


}
