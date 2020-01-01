package com.javacore.demo.oomdemo;

public class StackOverflowError {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
