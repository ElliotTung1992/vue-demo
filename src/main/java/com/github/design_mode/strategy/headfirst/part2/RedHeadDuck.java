package com.github.design_mode.strategy.headfirst.part2;

public class RedHeadDuck extends Duck implements FlyAble{

    @Override
    void display() {
        System.out.println("外观是红色的");
    }

    @Override
    public void fly() {
        System.out.println("飞行");
    }
}
