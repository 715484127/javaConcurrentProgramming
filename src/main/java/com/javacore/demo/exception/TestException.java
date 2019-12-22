package com.javacore.demo.exception;

public class TestException {
    public static void main(String[] args){
        TestException testException = new TestException();
        int sum = testException.getSum(1,2);
        System.out.println(sum);
    }

    int getSum(int a, int b){
        int sum = 0;
        try{
            sum = a + b;
            //throw new Exception();
            return sum;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            sum = 5;
            System.out.println("finally");
            return sum;
        }

        //System.out.println("1111111");
        //return sum;
    }
}
