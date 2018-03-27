package com.github.design_mode.decker;

//装饰者具体实现
public class Whip extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .30;
    }
}
