package ru.mirea.laba_10;

public class Test_task1 {
    public static void main(String[] args) {
        ConcreteFactory cf = new ConcreteFactory();
        cf.createComplex();
        cf.CreateComplex(-23, 34);
        System.out.println(cf.toString());
    }
}
