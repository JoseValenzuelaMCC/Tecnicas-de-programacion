package com.company;

import java.util.*;

public class Conjuntos<T> {
    private HashSet<T> conjunto = new HashSet<>();

    public Conjuntos(T... elementos){
        conjunto.addAll(Arrays.asList(elementos));
    }

    public Conjuntos(){
        super();
    }

    public Conjuntos(Collection<T> valores){
        conjunto.addAll(valores);
    }

    @Override
    public String toString() {
        return conjunto.toString().replace("[","{" ).replace("]","}");
    }

    public int size(){
        return conjunto.size();
    }


    public boolean empty(){
        return conjunto.isEmpty();
    }

    public boolean equals(Conjuntos<T> comparar) {
        return conjunto.equals(comparar.conjunto);
    }

    public boolean contains(T elemento){
        return conjunto.contains(elemento);
    }

    public boolean addAll(Collection<T> elementosAgregar){
        return conjunto.addAll(elementosAgregar);

    }

    public Conjuntos<T> union(Conjuntos<T> conjuntoUnion){
        Conjuntos<T> resultadoUnion = new Conjuntos<T>();
        resultadoUnion.addAll(conjunto);
        resultadoUnion.addAll(conjuntoUnion.conjunto);
        return resultadoUnion;
    }


    public Conjuntos<T> intersection(Conjuntos<T> conjuntoIntersection){
        Conjuntos<T> resultadoIntersection = new Conjuntos<>();
        resultadoIntersection.addAll(conjunto);
        resultadoIntersection.conjunto.retainAll(conjuntoIntersection.conjunto);

        return resultadoIntersection;
    }
    //los que estan en A y no estan en B...
    public Conjuntos<T> diference(Conjuntos<T> conjuntoDiference){
        List<T> list = new ArrayList<>();
        for (T i: conjunto) {
            if(!conjuntoDiference.contains(i)){
                list.add(i);
            }
        }

        Conjuntos<T> resultadoDiference = new Conjuntos<>(list);
        return resultadoDiference;
    }

    public boolean subSet(Conjuntos<T> subConjunto){
        boolean resultado = false;
        int cont = 0;
        for (T i: conjunto) {
            if(subConjunto.contains(i)) {
                cont++;
            }
        }

        if (cont == conjunto.size()) resultado = true;
        else resultado = false;
        return resultado;
    }

    public boolean subSetP(Conjuntos<T> subConjunto){
        boolean resultado = false;
        int cont = 0;
        for (T i: conjunto) {
            if(subConjunto.contains(i)) {
                cont++;
            }
        }
        if (cont == conjunto.size() && !conjunto.equals(subConjunto.conjunto) ) {
            resultado = true;
        }
        return resultado;
    }

    public Conjuntos<T> complement(Conjuntos<T> universo){
        List<T> list = new ArrayList<>();

        for (T i: universo.conjunto) {
            if(!conjunto.contains(i)){
                list.add(i);
            }
        }

        Conjuntos<T> resultadoComplement = new Conjuntos<>(list);
        return resultadoComplement;
    }

    /*public Conjuntos<T> productC(){


        Conjuntos<T>
        return
    }*/
 }
