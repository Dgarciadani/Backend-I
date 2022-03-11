package com.company;

import org.apache.log4j.Logger;

public class Calculator {
    //ADD LOGGER TO CLASS
    private static final Logger logger = Logger.getLogger(Calculator.class);

    private int value1;
    private int value2;

    public Calculator(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int sum() {
        logger.info("started sum: " + value1 + " + " + value2);
        return value1 + value2;
    }

    public int rest() {
        logger.info("started rest: " + value1 + " + " + value2);
        return value1 - value2;
    }

    public int multiply() {
        logger.info("started multiply: " + value1 + " + " + value2);
        return value1 * value2;
    }

    public double divide() {
        logger.info("started divide: " + value1 + " / " + value2);
        double result;
        try {
            result = value1 / value2;
        } catch (Exception e) {
            logger.error("Failed to divide");
            return 0;
        }
        logger.info("successful division");
        return result;
    }


    public int getvalue1() {
        return value1;
    }

    public void setvalue1(int value1) {
        value1 = value1;
    }

    public int getvalue2() {
        return value2;
    }

    public void setvalue2(int value2) {
        value2 = value2;
    }
}
