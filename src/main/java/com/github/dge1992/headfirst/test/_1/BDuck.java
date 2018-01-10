package com.github.dge1992.headfirst.test._1;

public class BDuck extends SuperDuck implements RunAbleInterface{

    void display() {
        System.out.println("green");
    }

    @Override
    void fly() {

    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
