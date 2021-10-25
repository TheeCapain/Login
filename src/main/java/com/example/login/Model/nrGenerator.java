package com.example.login.Model;

import java.util.Random;

public class nrGenerator {
    int random;

    public int randomGenerator(){
        Random rnd = new Random();
        return random = rnd.nextInt(100)+1;
    }
}
