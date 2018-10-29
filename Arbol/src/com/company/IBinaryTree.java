package com.company;

public interface IBinaryTree {
    public boolean busca(int d);
    public void insertar(int d);
    public int tamano();
    public void remover(int d);
    public boolean vacio();
    public Nodo padreN(int n);

    public void inorden();
    public void postorden();
    public void preorden();

}
