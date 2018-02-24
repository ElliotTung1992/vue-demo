package com.github.dge1992.factory.part1;

public class Store {

    public Pizza orderPizza(){
        Pizza pizza = new Pizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 会有新的口味增加，也有老的口味淘汰
     * 我们会频繁地修改这里的代码
     * 我们应该对修改关闭
     * 我们把这里变化的代码抽取出来封装
     * @param type
     * @return
     */
    public Pizza orderPizza1(String type){
        Pizza pizza = null;
        if(type.equals("beef")){
            pizza = new BeefPizza();
        }
        else if(type.equals("fish")){
            pizza = new FishPizza();
        }
        else if(type.equals("pig")){
            pizza = new PigPizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}

class Pizza {

    public void prepare(){
        System.out.println("prepare");
    }

    public void bake(){
        System.out.println("bake");
    }

    public void cut(){
        System.out.println("cut");
    }

    public void box(){
        System.out.println("box");
    }
}

class BeefPizza extends Pizza{

}

class FishPizza extends Pizza{

}

class PigPizza extends Pizza{

}
