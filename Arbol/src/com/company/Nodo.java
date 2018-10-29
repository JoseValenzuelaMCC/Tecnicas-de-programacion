package com.company;

public class Nodo<T> {
    Nodo izquierdo;
    Nodo derecho;
    int dato;
    String info;

    Nodo(int d){
        izquierdo = null;
        derecho = null;
        dato = d;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
