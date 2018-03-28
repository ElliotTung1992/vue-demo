package com.github.design_mode.strategy.headfirst.part1;

public class Part1 {
    public static void main(String[] args) {
        RubberDuck duck = new RubberDuck();
        duck.fly();
    }
}

//鸭子超类
abstract class Duck{

    void quack(){
        System.out.println("呱呱叫");
    }

    void swim(){
        System.out.println("游泳");
    }

    void fly(){
        System.out.println("飞翔");
    }

    abstract void display();
}

//红头鸭
class MallardDuck extends Duck{

    @Override
    void display() {
        System.out.println("外观是绿色的");
    }
}

//绿头鸭
class RedHeadDuck extends Duck{

    @Override
    void display() {
        System.out.println("外观是红色的");
    }
}

class RubberDuck extends Duck{

    @Override
    void display() {
        System.out.println("外观是木头");
    }

    @Override
    void fly() {

    }
}
