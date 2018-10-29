package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Iterable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private List<Person> children = new ArrayList<Person>();

    public Person(String fn, String ln, int a, Person... amigos){
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        for(Person child : amigos){
            children.add(child);
        }
    }

    public String getFisrtName(){return this.firstName;}
    public  String getLastName(){return  this.lastName;}
    public int getAge(){return this.age;}

    public Iterator<Person> iterator(){
        return children.iterator();
    }
    //public Iterator<Person> iterator() { return children.iterator(); }


    public void setFirstName(String value){this.firstName = value;}
    public void setLastName(String value){this.lastName = value;}
    public void setAge(int value){this.age = value;}

    public String toString(){
        return "[Person: " +
                "firstName=" + firstName + " " +
                "lastName=" + lastName + " " +
                "age=" + age + "]";

    }





}
