package com.company;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class EvaluarPosfijo {

    private int variablesDeVerdad;
    private int numOperadores;
    private List<Character> operandos;

    //Postfijo
    private Stack<Character> st;

    public EvaluarPosfijo(int variablesDeVerdad, int operadores, HashSet<Character> hashSet, Stack<Character> stack){
        this.variablesDeVerdad = variablesDeVerdad;
        this.numOperadores = operadores;
        this.operandos = new ArrayList<>(hashSet);
        this.st = stack;
    }

//metodos empiezan con min.
    private boolean[][] crearTabla(){
        int numFilas = (int)Math.pow(2,(variablesDeVerdad));
        boolean Matriz[][] = new boolean[numFilas][variablesDeVerdad + 1];
        int valorPotencia = variablesDeVerdad -1;
        int contador = 1;
        int numValores = 0;


        for(int i = 0; i < variablesDeVerdad; i++){
            numValores = (int)Math.pow(2,(valorPotencia));
            if (valorPotencia == 0) numValores = 1;
            for(int j =0; j < numFilas; j++){
                if(contador <= numValores){
                    Matriz[j][i] = true;
                    contador++;
                }
                else {
                    Matriz[j][i] = false;
                    contador++;
                }
                if(contador >(numValores*2)){
                    contador = 1;
                }
            }
            valorPotencia--;
            contador = 1;
        }
        return Matriz;
    }
    private boolean[][] evualuarTabla(){
        boolean[][] matriz = crearTabla();
        boolean res;
        boolean a, b;

        Stack<Boolean> stackVariablesDeVerdad = new Stack<>();


        for(int i = 0; i < matriz.length; i++){
            for (Character aSt : st) {
                if (Character.isLetter(aSt)) {
                    int posicionDelOperando = operandos.indexOf(aSt);
                    stackVariablesDeVerdad.push(matriz[i][posicionDelOperando]);
                } else {
                    if (aSt == '-') {
                        boolean c = stackVariablesDeVerdad.pop();
                        stackVariablesDeVerdad.push(!c);
                    } else {
                        b = stackVariablesDeVerdad.pop();
                        a = stackVariablesDeVerdad.pop();
                        switch (aSt) {
                            case '&':
                                res = a && b;
                                stackVariablesDeVerdad.push(res);
                                break;
                            case '|':
                                res = a || b;
                                stackVariablesDeVerdad.push(res);
                                break;
                            case '=':
                                res = a == b;
                                stackVariablesDeVerdad.push(res);
                                break;
                            case '>':
                                res = !a || b;
                                stackVariablesDeVerdad.push(res);
                                break;
                        }
                    }
                }
            }
            matriz[i][matriz[i].length - 1] = stackVariablesDeVerdad.pop();
        }
        return matriz;
    }
    public void imprimirTabla(){
        boolean[][] tabla = evualuarTabla();
        for (int i=0; i < tabla.length; i++) {
            System.out.print("|");
            for (int j=0; j <tabla[i].length; j++) {
                System.out.print (tabla[i][j]);
                if (j!=tabla[i].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
    public void resultadoEvaluacion(){
        boolean[][] tabla = evualuarTabla();

        int contador = 0;
        for(int i = 0; i < tabla.length; i++){
            if (tabla[i][tabla[i].length-1] ) {
                contador++;
            }
        }

        if(contador  == tabla.length) System.out.println("Es tautologia");
        else if(contador == 0) System.out.println("Es contradiccion");
        else System.out.println("Es contingencia");
    }
}
