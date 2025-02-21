package org.app.dicegame.Classes;

import java.util.Random;

public class Generator {

    public static int generateNumber(){

        Random rand = new Random();

        return rand.nextInt((6-1)+1)+1;
    }

}
