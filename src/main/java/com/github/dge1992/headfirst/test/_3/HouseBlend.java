package com.github.dge1992.headfirst.test._3;

public class HouseBlend extends Beverage{

    public HouseBlend(){
        setDescription("HouseBlend");
    }

    @Override
    public void cost() {
        System.out.println("100");
    }
}
