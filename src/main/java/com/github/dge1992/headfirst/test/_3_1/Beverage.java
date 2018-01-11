package com.github.dge1992.headfirst.test._3_1;

public abstract class Beverage {

    protected String description;

    private boolean milk;

    private boolean soy;

    private boolean mocha;

    private boolean whip;

    public double cost(){
        double price = 0.0;
        if(isMilk()){
            price += 1;
        }
        if(isSoy()){
            price += 2;
        }
        if(isMocha()){
            price += 3;
        }
        if(isWhip()){
            price += 4;
        }
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }
}
