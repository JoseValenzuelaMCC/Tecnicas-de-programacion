package com.company.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baraja {
    private List<Cards> Baraja = Arrays.asList(Cards.values());

    private void showInfo(){
        System.out.println(Baraja);

    }

}
