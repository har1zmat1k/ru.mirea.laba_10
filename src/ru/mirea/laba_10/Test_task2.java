package ru.mirea.laba_10;

public class Test_task2 {
    public static void main(String[] args) {
        ChairFactory chair = new ChairFactory();
        VictorianChair victorianChair = new VictorianChair(12);
        MagicChair magicChair = new MagicChair();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        client1.setChair(chair.createMagicChair());
        client2.setChair(chair.createFunctionalChair());
        client3.setChair(victorianChair);
        System.out.println(client1.chair);
        System.out.println(client2.chair);
        System.out.println(client3.chair);
        victorianChair.setAge(13);
        System.out.println(victorianChair.getAge());
        magicChair.doMagic();
    }
}
