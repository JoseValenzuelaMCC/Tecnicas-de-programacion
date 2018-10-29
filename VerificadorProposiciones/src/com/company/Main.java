package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int parenesis = 0;
        Deque<Character> stackChar = new LinkedList<Character>();
        Stack<Character> stackCharOpe = new Stack<Character>();

        // System.out.println(stackCharOpe.get(2));

        System.out.println("Agrega una Preposicion...");
        Scanner addProp = new Scanner(System.in);
        String prop = addProp.next();
        System.out.println(prop);



        for(int i = 0; i < prop.length(); i++ ){
            char result = prop.charAt(i);

            switch (result){
                case '&':
                    stackCharOpe.add(result);
                    break;
                case '|':
                    stackCharOpe.add(result);
                    break;
                case '-':
                    stackCharOpe.add(result);
                    break;
                case '>':
                    stackCharOpe.add(result);
                    break;
                case '=':
                    stackCharOpe.add(result);
                    break;
            }

            if(result == 'p' | result == 'P'){ stackChar.add(result); }
            if(result == 'q' | result == 'Q'){ stackChar.add(result); }
            if(result == 'r' | result == 'R'){ stackChar.add(result); }
            if(result == 's' | result == 'S'){ stackChar.add(result); }
            if(result == 't' | result == 'T'){ stackChar.add(result); }
            /*//Calcular el numero de parentesis en la preposicion..
            if(result == '(' | result == ')'){
                parenesis++;
            }*/
        }

        //qSystem.out.println(stackChar.getFirst());

        //System.out.println(stackChar);
        System.out.println(stackCharOpe);

        System.out.println("La cantidad de parentesis es: " +parenesis);

    }

}
