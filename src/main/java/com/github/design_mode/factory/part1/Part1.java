package com.github.design_mode.factory.part1;

public class Part1 {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        Pizza pizza = pizzaStore.orderPizza("chess");
        System.out.println(pizza.name);
    }
}

//披萨店
class PizzaStore{

    //预定披萨
    public Pizza orderPizza(String type){
        Pizza pizza = null;
        if(type.equals("chess")){
            pizza = new ChessPizza();
        }else if(type.equals("greek")){
            pizza = new GreekPizza();
        }else if(type.equals("pepper")){
            pizza = new PepperPizza();
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

//披萨接口
abstract class Pizza{
    String name;
    void prepare(){
        System.out.println("prepare");
    }
    void bake(){
        System.out.println("bake");
    }
    void cut(){
        System.out.println("cut");
    }
    void box(){
        System.out.println("box");
    }
}

//芝士披萨
class ChessPizza extends Pizza{
    public ChessPizza(){
        name = "ChessPizza";
    }
}

//希腊披萨
class GreekPizza extends Pizza{
    public GreekPizza(){
        name = "GreekPizza";
    }
}

//胡椒披萨
class PepperPizza extends Pizza{
    public PepperPizza(){
        name = "PepperPizza";
    }
}
