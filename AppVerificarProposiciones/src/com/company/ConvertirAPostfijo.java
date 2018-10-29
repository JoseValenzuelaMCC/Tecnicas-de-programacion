package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class ConvertirAPostfijo{

    public ConvertirAPostfijo(){ }
    public void infijoPosfijo() throws FileNotFoundException, IOException{

        LeerArchivo leerArchivo = new LeerArchivo();

        Stack<Character> stackChar = new Stack<>();
        Stack<Character> stackOpe = new Stack<>();
        int operadores = 0;
        HashSet<Character> hashSet = new HashSet<>();

        List<String> formula1 = leerArchivo.getFormulas();

        for(int i1 = 0;i1<formula1.size();i1++){
            String formula = formula1.get(i1);

            Check check = new Check(formula);

            if (check.VerificarParentesis()) {
                for (int i = 0; i < formula.length(); i++) {
                    switch (formula.charAt(i)) {
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                            stackChar.add(formula.charAt(i));
                            break;
                    }
                    switch (formula.charAt(i)) {
                        case '&':
                        case '=':
                        case '>':
                        case '|':
                            stackOpe.add(formula.charAt(i));break;
                    }
                    if (formula.charAt(i) == '-'){
                        if(formula.charAt(i+1) == '('){
                            stackOpe.add(formula.charAt(i));
                        } else {
                            stackChar.add(formula.charAt(i + 1));
                            stackChar.add('-');
                        }
                        i++;
                    }
                    if(formula.charAt(i) == ')'){
                        stackChar.add(stackOpe.pop());
                    }
                }
                if(stackOpe.size() !=0){
                    int size = stackOpe.size();
                    for(int f = 0; f<size; f++){
                        stackChar.add(stackOpe.pop());
                    }
                }
                System.out.println("Infijo: "+formula);
                System.out.println("Posfijo: "+stackChar.toString());

                for (int a = 0; a<stackChar.size();a++){
                    char s = stackChar.get(a);
                    switch (s){
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                            hashSet.add(stackChar.get(a));break;
                    }
                }
                for (int a = 0; a<stackChar.size();a++) {
                    switch (stackChar.get(a)) {
                        case '&':
                        case '=':
                        case '>':
                        case '|':
                            operadores++;
                            break;
                    }
                }

                EvaluarPosfijo evaluarPosfijo = new EvaluarPosfijo(hashSet.size(),operadores, hashSet, stackChar);
                evaluarPosfijo.imprimirTabla();
                evaluarPosfijo.resultadoEvaluacion();


            }
            else {
                System.out.println(formula1.get(i1) + " No es una formula bien formada..");
            }




            stackChar.clear();
            hashSet.clear();

            operadores = 0;
            System.out.println("----------------------------");
        }
    }
}
