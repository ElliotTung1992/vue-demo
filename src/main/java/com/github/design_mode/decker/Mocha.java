package com.github.design_mode.decker;

//装饰者具体实现 摩卡
public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }
}
