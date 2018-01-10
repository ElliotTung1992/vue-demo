package com.github.dge1992.headfirst.test._1;

public class ADuck extends SuperDuck implements RunAbleInterface{

    void display() {
        System.out.println("blue");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
