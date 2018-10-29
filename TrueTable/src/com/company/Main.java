package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.logging.SocketHandler;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        boolean tabla= false;
        boolean var2Bool = false;
        //Stack<Integer> stackAnd = new Stack<Integer>();
        //Stack<Integer> stackOr = new Stack<Integer>();
        int and = 0;
        int or = 0;
        String AND = "";
        String OR = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Numero");
        int longitud = Integer.parseInt(br.readLine());
        String numBin = "";
        for(int i = 0; i<(int)Math.pow(2, longitud); i++ ){
            numBin = Integer.toBinaryString(i);
            while(numBin.length()<longitud){
                numBin = 0+ numBin;
            }
            System.out.println(numBin);
            if(longitud == 2){
                if(numBin.charAt(0) == '1' && numBin.charAt(1) == '1'){
                    and++;
                    AND = AND.concat("1");
                }
                else {
                    AND = AND.concat("0");
                }
                if(numBin.charAt(0) == '1' || numBin.charAt(1) == '1'){
                    or++;
                    OR = OR.concat("1");
                }
                //else {stackOr.add(0);}
            }
        }
        System.out.println(AND);
        if(and != 4){
            System.out.println("Es contingencia");
        }else{
            System.out.println("Es Tautologia");
        }
    }
    }
