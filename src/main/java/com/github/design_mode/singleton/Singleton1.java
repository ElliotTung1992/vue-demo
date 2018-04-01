package com.github.design_mode.singleton;

//懒汉式
public class Singleton1 {

    /**
     * volatile关键词确保当初始化singleton实例时
     * 多个线程正确地使用singleton实例
     */
    private volatile static Singleton1 singleton = null;

    private Singleton1(){

    }

    public static synchronized Singleton1 getInstance(){
        if(singleton == null){
            synchronized (Singleton1.class){
                if(singleton == null){
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}
