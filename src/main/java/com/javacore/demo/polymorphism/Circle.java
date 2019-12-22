package com.javacore.demo.polymorphism;

public class Circle extends Shape {
    public String s = "Circle";
    public void draw() {
        System.out.println("Circle-draw");
    }

    @Override
    public void erase() {
        System.out.println("Circle-erase");
    }
}
