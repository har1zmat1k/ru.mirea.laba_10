package ru.mirea.laba_10;

public class Client {
    public Chair chair;

    public void sit(){
        System.out.println("Метод sit вызван " + chair.toString());
    }

    public void setChair(Chair chair){
        this.chair = chair;
    }

    @Override
    public String toString() {
        return chair.toString();
    }
}
