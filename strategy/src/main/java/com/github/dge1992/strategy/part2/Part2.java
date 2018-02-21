package com.github.dge1992.strategy.part2;

public class Part2 {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.quack();
        mallardDuck.fly();
        BathDuck bathDuck = new BathDuck();
        bathDuck.quack();
    }
}

/**
 *
 * 把 fly 和 quack 抽出来定义成接口
 * 如果子类会飞或会叫自己去实现接口
 *
 * ？？？？？
 * 鸭子实现一多工作量会非常大，代码量会增多等弊端
 *
 */
abstract class Duck {
    void swim(){
        System.out.println("游泳");
    }
    abstract void display();
}

/**
 * 飞行
 */
interface Flyable {
    void fly();
}

/**
 * 叫
 */
interface Quackable {
    void quack();
}

class MallardDuck extends Duck implements Quackable, Flyable{

    @Override
    void display() {
        System.out.println("外观是绿头");
    }

    @Override
    public void fly() {
        System.out.println("飞行");
    }

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

class RedheadDuck extends Duck implements Quackable, Flyable{

    @Override
    void display() {
        System.out.println("外观是红头");
    }

    @Override
    public void fly() {
        System.out.println("飞行");
    }

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

class BathDuck extends Duck implements Quackable{

    @Override
    void display() {
        System.out.println("玩具鸭");
    }

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}


