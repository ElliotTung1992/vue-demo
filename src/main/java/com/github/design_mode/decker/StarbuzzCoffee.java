package com.github.design_mode.decker;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        //打印不加任何装饰的Espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " " + beverage.cost());

        //创建新的饮料Espresso
        Beverage beverage2 = new Espresso();
        //添加Mocha装饰 .20
        beverage2 = new Mocha(beverage2);
        //添加Mocha装饰 .20
        beverage2 = new Mocha(beverage2);
        //添加Whip装饰  .30
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " " + beverage2.cost());

    }
}
