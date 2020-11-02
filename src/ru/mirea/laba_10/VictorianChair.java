package ru.mirea.laba_10;

public class VictorianChair implements Chair{
    private int age;

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public VictorianChair(int age) {
        this.age = age;
    }

    public VictorianChair() { }

    @Override
    public String toString() {
        return "Викторианский стул, возрасть "+ age;
    }
}
