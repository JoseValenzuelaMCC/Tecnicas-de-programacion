package com.company;

public class Bicycle {
    //the Bicycle has three fields
    public int cadence;
    public int gear;
    private int speed;

    //the bicycle has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public int speed(){
        return speed;
    }
}