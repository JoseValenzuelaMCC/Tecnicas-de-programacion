package com.company;

public class Check {
//corregir
    private String verificador;
    private boolean checkParentesis = true;
    private int parenAbren, parenCierran;
    public Check(String a){
        this.verificador = a;
    }

//bienformada
    public boolean VerificarParentesis(){
        for(int i =0; i < verificador.length(); i++){
            char result = verificador.charAt(i);
            if(result == '(' || result == ')'){
                if(result == '('){
                    parenAbren++;
                    parenCierran = 0;
                }else{
                    parenCierran++;
                    parenAbren--;
                }
                if(parenAbren == 0 && parenCierran == 1){
                    checkParentesis = true;
                }else{
                    checkParentesis = false;
                }
            }
        }


    return checkParentesis;
    }
}

