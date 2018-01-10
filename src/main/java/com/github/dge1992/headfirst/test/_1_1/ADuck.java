package com.github.dge1992.headfirst.test._1_1;

public class ADuck extends SuperDuck {

    public ADuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    void display() {
        System.out.println("blue");
    }
}
