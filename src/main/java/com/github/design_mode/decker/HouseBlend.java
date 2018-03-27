package com.github.design_mode.decker;

//(饮料具体实现)
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
