package com.company;

import java.util.ArrayList;

public class SBinaryTree  implements IBinaryTree {
    private Nodo raiz;

    //Constructor para arbol vacio..
    public void SBinaryTree(){
        raiz = null;
    }

    public boolean busca(int d) {
        return busca(raiz, d);
    }
    private  boolean busca(Nodo nodo, int d){
        if(nodo == null) return false;
        if(d ==nodo.dato)return true;
        else
            if(d<nodo.dato) return busca(nodo.izquierdo, d);
            else return busca(nodo.derecho, d);
    }

    public Nodo buscaNodo(int d){
        if (raiz == null) return raiz;
        else return buscaNodo(raiz, d);
    }

    private Nodo buscaNodo(Nodo raiz, int d){
        Nodo t = null;

        if(raiz.dato == d) {
            t = raiz;
        }
        else{
            if(raiz.dato > d) {
                t = buscaNodo(raiz.izquierdo, d);
            }
            else {
                t = buscaNodo(raiz.derecho, d);
            }
        }
        return t;
    }

    public int tamano(){
        return tamano(raiz);
    }

    private int tamano(Nodo raiz){
        if(raiz == null) return 0;
        else
            return 1 + tamano(raiz.izquierdo) + tamano(raiz.derecho);
    }

    /*public double sumaNodos(){
        if(raiz == null) return 0;
        else return sumaNodos(raiz);
    }*/

    private int sumaNodos(Nodo raiz){
        if(raiz == null) return 0;
        else{
            return raiz.dato + sumaNodos(raiz.izquierdo) + sumaNodos(raiz.derecho);
        }
    }

    public void insertar(int n){
        raiz = insertar(raiz, n);
    }

    private Nodo insertar(Nodo r, int n){
        if(r==null) r = new Nodo(n);
        else
            if(n <= r.dato )
                r.izquierdo = insertar(r.izquierdo, n);
            else
                r.derecho = insertar(r.derecho, n);
        return r;
    }

    public void remover(int d){

    }

    public boolean vacio(){

        return false;
    }

    public void inorden(){
        inorden(raiz);
        System.out.println();
    }

    private void inorden(Nodo r){
        if (r!=null) {
            inorden(r.izquierdo);
            System.out.print (r.dato+" ");
            inorden(r.derecho);
        }
    }

    public void preorden(){
        preorden(raiz);
        System.out.println();
    }

    private void preorden(Nodo r){
        if (r!=null) {
            System.out.print (r.dato+" ");
            preorden(r.izquierdo);
            preorden(r.derecho);
        }
    }

    public void postorden(){
        postorden(raiz);
        System.out.println();
    }

    private void postorden(Nodo r){
        if (r!=null) {
            postorden(r. izquierdo);
            postorden(r.derecho);
            System.out.print (r.info+" ");
        }
    }

    public int nHijos(int n){
        if(raiz == null)return  -2;
        else return nHijos(raiz,n);
    }

    private int nHijos(Nodo raiz ,int n){
        Nodo t = buscaNodo(raiz, n);
        int c = 0;
        if(t == null) return -1;
        else
            if(t.izquierdo != null) c++;
            if(t.derecho != null) c++;
        return c;
    }

    public Nodo  padreN(int n){
        if(raiz == null) return null;
        else return padreN(raiz, n);
    }

    private Nodo padreN(Nodo raiz, int n){
        if(busca(n)){
            if(raiz.dato == n) return  null;
            else {
                if (raiz.izquierdo != null && raiz.izquierdo.dato == n || raiz.derecho != null && raiz.derecho.dato == n){
                    return raiz;
                }
                if(raiz.dato > n) return padreN(raiz.izquierdo, n);
                else return padreN(raiz.derecho, n);
            }
        }else
            return null;

    }

    public int balance(int n){
        if(raiz == null) return  -2;
        else return balance(raiz, n);
    }

    private int balance(Nodo raiz, int n){
        Nodo nodoABuscarBalance = buscaNodo(n);
        int tamSubIzq = 0, tamSubDer = 0;
        if(nodoABuscarBalance.izquierdo != null)tamSubIzq = tamano(nodoABuscarBalance.izquierdo);
        if (nodoABuscarBalance.derecho != null)tamSubDer = tamano(nodoABuscarBalance.derecho);
        return tamSubIzq - tamSubDer;
    }

    public ArrayList<Integer> nodosGeneracion(int n){
        if(n < 0) return null;
        else return nodosGeneracion(raiz,n);
    }

    private ArrayList<Integer> nodosGeneracion(Nodo raiz, int n) {
        ArrayList<Integer> nodos = new ArrayList<>();
        if(n == 0){
            nodos.add(raiz.dato);
            return nodos;
        }
        if(raiz.izquierdo != null)
        {
            nodos.addAll(nodosGeneracion(raiz.izquierdo,n-1));
        }
        if(raiz.derecho != null){
            nodos.addAll(nodosGeneracion(raiz.derecho,n-1));
        }
        return nodos;
    }

    public int nodoMayor(){
        if(raiz == null) return -2;
        else return nodoMayor(raiz);
    }

    private int nodoMayor(Nodo raiz){
        if(raiz.derecho == null) return raiz.dato;
        else{
            return nodoMayor(raiz.derecho);
        }
    }

    public double promedio(){
        if(raiz == null) return -2;
        else return promedio(raiz);
    }

    private double promedio(Nodo raiz){
        if(tamano(raiz) == 1) return raiz.dato;
        else{
            return (double)sumaNodos(raiz) / tamano(raiz) ;
        }
    }
}



















