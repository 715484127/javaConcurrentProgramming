package com.javacore.demo.polymorphism;

public class Running {
    public static void main(String[] args){
        Shape shape = new Circle();
        shape.draw(); //输出Circle-draw
        shape.erase();//输出Circle-erase
        System.out.println(shape.s);//输出Shape
    }
}
