package com.company;

public class Par<T, E> {
    private T x;
    private E y;

    public Par( T x, E y){
        this.x = x;
        this.y = y;
    }

    public E getY() {
        return y;
    }

    public T getX() {
        return x;
    }

    @Override
    public String toString() {
        return "("+ x +","+ y +")";
    }
}