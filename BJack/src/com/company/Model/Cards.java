package com.company.Model;

public enum Cards {

    TrebolA("Trebol A", 1),
    Trebol2("Trebol 2", 2),
    Trebol3("Trebol 3", 3),
    Trebol4("Trebol 4", 4),
    Trebol5("Trebol 5", 5),
    Trebol6("Trebol 6", 6),
    Trebol7("Trebol 7", 7),
    Trebol8("Trebol 8", 8),
    Trebol9("Trebol 9", 9),
    Trebol10("Trebol 10", 10),
    TrebolJ("Trebol J", 10),
    TrebolQ("Trebol Q", 10),
    TrebolK("Trebol K", 10),

    DiamantesA("Diamantes A", 1),
    Diamantes2("Diamantes 2", 2),
    Diamantes3("Diamantes 3", 3),
    Diamantes4("Diamantes 4", 4),
    Diamantes5("Diamantes 5", 5),
    Diamantes6("Diamantes 6", 6),
    Diamantes7("Diamantes 7", 7),
    Diamantes8("Diamantes 8", 8),
    Diamantes9("Diamantes 9", 9),
    Diamantes10("Diamantes 10", 10),
    DiamantesJ("Diamantes J", 10),
    DiamantesQ("Diamantes Q", 10),
    DiamantesK("Diamantes K", 10);


    private String name;
    private int value;

    Cards(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }



}
