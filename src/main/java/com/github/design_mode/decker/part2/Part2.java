package com.github.design_mode.decker.part2;


public class Part2 {

    public static void main(String[] args) {
        HouseBlend houseBlend = new HouseBlend();
        houseBlend.setMilk(true);
        houseBlend.setMocha(true);
        System.out.println(houseBlend.cost());
    }
}

//饮料抽象
abstract class Beverage{
    //描述
    String desc;
    //是否加了牛奶
    private boolean milk;
    //是否加了摩卡
    private boolean mocha;
    float otherCost;

    //花费
    abstract float cost();

    public float otherCost(){
        if(isMilk()){
            otherCost += 0.10f;
        }
        if(isMocha()){
            otherCost += 0.11f;
        }
        return otherCost;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
}

//具体实现
class HouseBlend extends Beverage{

    public HouseBlend(){
        desc = "HouseBlend";
    }

    @Override
    float cost() {
        float v = otherCost();
        return 1.00f + v;
    }
}


