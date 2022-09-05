package com.example.clinicavet.exception;


public final class ExceptionCustom extends Exception{

    public static void check(boolean expression, String msg) {

        if (expression) {
            throw new RuntimeException(msg);
        }
    }
}
