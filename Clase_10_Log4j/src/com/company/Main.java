package com.company;

import org.apache.log4j.Logger;

public class Main {
    // ADD LOGGER TO MAIN
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator(1, 3);
        System.out.println(calculator.sum());
        Calculator calculator2 = new Calculator(1, 0);
        System.out.println(calculator2.divide());
        System.out.println(calculator.divide());
    }
}
