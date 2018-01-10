package com.github.dge1992.headfirst.test._1_1;

public abstract class SuperDuck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    void swim(){
        System.out.println("swim");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    abstract void display();

    //动态设定行为
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    //动态设定行为
    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}
