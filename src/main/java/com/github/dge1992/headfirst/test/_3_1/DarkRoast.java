package com.github.dge1992.headfirst.test._3_1;

public class DarkRoast extends Beverage{

    public DarkRoast(){
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        double cost = super.cost();
        return (cost + 100);
    }
}
