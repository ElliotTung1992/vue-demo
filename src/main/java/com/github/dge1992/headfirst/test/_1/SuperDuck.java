package com.github.dge1992.headfirst.test._1;

public abstract class SuperDuck {

    //呱呱叫
    void quack(){
        System.out.println("quack");
    }

    //游泳
    void swim(){
        System.out.println("swim");
    }

    //外观
    abstract void display();

    //飞行
    void fly(){
        System.out.println("fly");
    }
}
