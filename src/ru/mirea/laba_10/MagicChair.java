package ru.mirea.laba_10;

public class MagicChair implements Chair{
    public void doMagic(){
        System.out.println("Вызван мктод doMagic");
    }

    @Override
    public String toString() {
        return "Магический стул";
    }
}
