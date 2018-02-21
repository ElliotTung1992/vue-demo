package com.github.dge1992.strategy.part1;

public class Part1 {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.quack();
        mallardDuck.fly();
        BathDuck bathDuck = new BathDuck();
        bathDuck.quack();
        bathDuck.fly();
    }
}

/**
 *
 * 创建一个Duck超类
 *
 * quack和swim所有鸭子都会
 * display不同的鸭子有不同的外形
 *
 * 新增能功能fly,直接把fly方法加到超类Duck中,所有继承Duck的鸭子都会飞(包括玩具鸭)
 * 玩具鸭不会呱呱叫只会吱吱叫，玩具鸭覆盖父类方法
 * 覆盖飞行方法，什么也不做
 *
 * ?????
 *
 * 维护太麻烦，新增其它的新鸭子和父类行为不同要覆盖重写
 *
 */
abstract class Duck {
    void quack(){
        System.out.println("呱呱叫");
    }
    void swim(){
        System.out.println("游泳");
    }
    abstract void display();
    //新增功能飞翔
    void fly(){
        System.out.println("飞翔");
    }
}

class MallardDuck extends Duck {

    @Override
    void display() {
        System.out.println("外观是绿头");
    }
}

class RedheadDuck extends Duck {

    @Override
    void display() {
        System.out.println("外观是红头");
    }
}

class BathDuck extends Duck {

    @Override
    void quack() {
        System.out.println("吱吱叫");
    }

    @Override
    void display() {
        System.out.println("玩具鸭");
    }

    @Override
    void fly() {

    }
}

