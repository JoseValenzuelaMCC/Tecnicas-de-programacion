package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Conjuntos<Integer> C1 = new Conjuntos<>(1,2,3,4);
        Conjuntos<Integer> C2 = new Conjuntos<>(2,3,4,5);
        Conjuntos<Integer> C = new Conjuntos<>(1,8,2,3);
        Conjuntos<Integer> U = new Conjuntos<>(1,2,3,4,5,6,7,8,9);
        Conjuntos<String> C3 = new Conjuntos<>("A","B","C");
        Conjuntos<String> C4 = new Conjuntos<>("A","C","B");
        /*System.out.println(A.toString());
        System.out.println(A.size());
        System.out.println(A.empty());
        System.out.println(A.equals(B));
        System.out.println(A.contains(2));
        System.out.println(A.union(B));
        System.out.println(A.intersection(B));
        System.out.println(A.diference(B));
        System.out.println(A.subSet(B));*/
        System.out.println(C3.subSetP(C4));
        System.out.println(C1.complement(U));
        System.out.println(C.union(C1));
    }
}
