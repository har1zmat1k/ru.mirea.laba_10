package ru.mirea.laba_10;

public class ConcreteFactory implements ComplexAbstractFactory{
    private Complex complexNumber;
    @Override
    public Complex createComplex() {
        complexNumber = new Complex();
        return complexNumber;
    }

    @Override
    public Complex CreateComplex(int real, int image) {
        complexNumber = new Complex(real, image);
        return complexNumber;
    }

    @Override
    public String toString() {
        return complexNumber.toString();
    }
}
