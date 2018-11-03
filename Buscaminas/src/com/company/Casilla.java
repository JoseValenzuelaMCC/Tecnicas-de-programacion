package com.company;

public class Casilla {
    private boolean mina = false;
    private boolean flag = false;
    private int valor = 0;
    private boolean hide = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide(){
        return hide;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public boolean getMina(){
        return this.mina;
    }

    public void incrementarValor(){
        valor++;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
