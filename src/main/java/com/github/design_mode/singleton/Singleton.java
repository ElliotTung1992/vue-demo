package com.github.design_mode.singleton;

//恶汉式
public class Singleton {

    public static final Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}
