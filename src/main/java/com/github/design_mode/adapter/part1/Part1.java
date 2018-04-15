package com.github.design_mode.adapter.part1;

public class Part1 {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();

        //绵羊来参加
        Mutton mutton = new Mutton();
        rabbit.welcomeToParty(mutton);

        //山羊来参加
        Goat goat = new Goat();
        rabbit.welcomeToParty(goat);

        //大灰狼来参加,不让进
        TimberWolf timberWolf = new TimberWolf();

        //披着羊皮的狼
        SheepskinWolf sheepskinWolf = new SheepskinWolf(timberWolf);
        rabbit.welcomeToParty(sheepskinWolf);

    }
}

//兔子
class Rabbit{

    public void welcomeToParty(Sheep sheep){
        System.out.println("欢饮参加全羊party");
        //叫几声表示很开心
        sheep.shout();
    }
}

//羊
abstract class Sheep{
    //外观
    public abstract void display();
    //羊叫
    void shout(){
        System.out.println("咩咩");
    }
}

//绵羊
class Mutton extends Sheep{
    String name;
    public Mutton(){
        this.name = "绵羊";
    }

    @Override
    public void display() {
        System.out.println("白色");
    }
}

//山羊
class Goat extends Sheep{
    String name;
    public Goat(){
        this.name = "山羊";
    }
    @Override
    public void display() {
        System.out.println("白色");
    }
}

//狼
abstract class Wolf{
    //外观
    public abstract void display();
    //吼叫
    void roar(){
        System.out.println("嗷嗷, 我要吃了你们");
    }
}

//大灰狼
class TimberWolf extends Wolf{

    String name;
    public TimberWolf(){
        this.name = "大灰狼";
    }
    @Override
    public void display() {
        System.out.println("灰色");
    }
}

//披着羊皮的狼
class SheepskinWolf extends Sheep{

    TimberWolf timberWolf;

    SheepskinWolf(TimberWolf timberWolf){
        this.timberWolf = timberWolf;
    }

    @Override
    public void display() {
        System.out.println("披上羊皮我变成了一只羊");
    }

    @Override
    void shout() {
        timberWolf.roar();
    }
}
