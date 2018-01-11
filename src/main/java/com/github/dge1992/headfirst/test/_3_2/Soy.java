package com.github.dge1992.headfirst.test._3_2;

public class Soy extends CondimentDecorator{

    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }
}
