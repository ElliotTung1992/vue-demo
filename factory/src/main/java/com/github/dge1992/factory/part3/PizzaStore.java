package com.github.dge1992.factory.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂方法模式:
 * 定义了一个创建对象的接口，但由子类决定要实例化的对象是哪一个。工厂方法让类的实例化推迟到子类。
 *
 * 1创建者类(Creator)
 * 2产品类
 *
 *
 * 抽象创建者类,它定义了一个抽象的工厂方法，让子类实现此方法制造产品
 * PizzaStore
 *
 * 创建者通常会包含依赖于抽象产品的代码
 * pizza.prepare();
   pizza.bake();
   pizza.cut();
   pizza.box();
 *
 * 能够生产产品的类称为具体的创建者
 * NingboPizzaSrore
 * ShanghaiPizzaStore
 *
 * 每个子类都实现实现了createPizza方法
 * 子类可以根据自己的情况创建自己的产品
 *
 *
 * 产品类(Pizza)
 *
 * 具体的实现BeefPizza FishPizza
 *
 */

/**
 * 原本是由一个对象负责所有类的实例化
 * 现在通过对PizzaStore做一些小转变，变成由一群子类来负责实例化
 */
public abstract class PizzaStore {

    public static void main(String[] args) {
        NingboPizzaSrore ningboPizzaSrore = new NingboPizzaSrore();
        ningboPizzaSrore.orderPizza("beef");
        ShanghaiPizzaStore shanghaiPizzaStore = new ShanghaiPizzaStore();
        shanghaiPizzaStore.orderPizza("fish");
    }

    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}

class NingboPizzaSrore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("beef")){
            System.out.println("beef NingboPizzaSrore");
            pizza = new BeefPizza();
        }
        else if(type.equals("fish")){
            System.out.println("fish NingboPizzaSrore");
            pizza = new FishPizza();
        }
        else if(type.equals("pig")){
            System.out.println("pig NingboPizzaSrore");
            pizza = new PigPizza();
        }
        return pizza;
    }
}

class ShanghaiPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("beef")){
            System.out.println("beef ShanghaiPizzaStore");
            pizza = new BeefPizza();
        }
        else if(type.equals("fish")){
            System.out.println("fish ShanghaiPizzaStore");
            pizza = new FishPizza();
        }
        else if(type.equals("pig")){
            System.out.println("pig ShanghaiPizzaStore");
            pizza = new PigPizza();
        }
        return pizza;
    }
}

abstract class Pizza {

    String name;
    String dough;
    String sauce;
    List topping = new ArrayList();

    public void prepare(){
        System.out.println("preparing " + name);
        System.out.println("dough.." + dough);
        System.out.println("sauce.." + sauce);
        if(topping != null && topping.size() > 0){
            topping.stream().forEach(System.out::println);
        }
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
    BeefPizza(){
        name = "BeefPizza";
        dough = "海鲜酱";
        sauce = "胡椒";
        topping.add("....不要放味精");
    }
}

class FishPizza extends Pizza{
    FishPizza(){
        name = "FishPizza";
        dough = "甜酱";
        sauce = "辣椒";
    }

    @Override
    public void cut() {
        System.out.println("切成方的！！！！");
    }
}

class PigPizza extends Pizza{

}
