package com.github.design_mode.decker.part1;

/**
 * 类爆炸
 */
public class Part1 {

    public static void main(String[] args) {

    }
}

//饮料抽象类
abstract class Beverage {
    //描述
    String desc;

    //获取描述
    public String getDesc() {
        return desc;
    }

    //花费金额
    abstract float cost();
}


//具体饮料1 + 牛奶 + 摩卡
class HouseBlendWithSteamedMilkandMocha extends Beverage{

    public HouseBlendWithSteamedMilkandMocha(){
        desc = "HouseBlendWithSteamedMilkandMocha";
    }

    @Override
    float cost() {
        return 2.99f;
    }
}


//具体饮料1 + 牛奶
class HouseBlendWithSteamedMilk extends Beverage{

    public HouseBlendWithSteamedMilk(){
        desc = "HouseBlendWithSteamedMilk";
    }

    @Override
    float cost() {
        return 1.99f;
    }
}

//具体饮料1
class HouseBlend extends Beverage{

    public HouseBlend(){
        desc = "HouseBlend";
    }

    @Override
    float cost() {
        return 0.99f;
    }
}

//具体饮料2 + 牛奶 + 摩卡
class DecafWithSteamedMilkandMocha extends Beverage{

    public DecafWithSteamedMilkandMocha(){
        desc = "DecafWithSteamedMilkandMocha";
    }

    @Override
    float cost() {
        return 1.78f;
    }
}


