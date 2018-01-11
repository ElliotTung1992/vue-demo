package com.github.dge1992.headfirst.test._3_1;


public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        double cost = super.cost();
        return (cost + 110);
    }
}
