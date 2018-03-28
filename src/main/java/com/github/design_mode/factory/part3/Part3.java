package com.github.design_mode.factory.part3;

import java.util.ArrayList;

public class Part3 {

    public static void main(String[] args) {
        PizzaStore nYStylePizzaStore = new NYStylePizzaStore();
        PizzaStore chicagoStylePizzaStore = new ChicagoStylePizzaStore();

        Pizza chess = nYStylePizzaStore.orderPizza("chess");
        System.out.println(chess.getName());

        Pizza chess1 = chicagoStylePizzaStore.orderPizza("chess");
        System.out.println(chess1.getName());

    }
}

//披萨店
abstract class PizzaStore{

    //预定披萨
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

//纽约风味披萨店
class NYStylePizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("chess")){
            pizza = new NYStyleChessPizza();
        }else if(type.equals("greek")){
            pizza = new NYStyleGreekPizza();
        }else if(type.equals("pepper")){
            pizza = new NYStylePepperPizza();
        }
        return pizza;
    }
}

//芝加哥风味披萨店
class ChicagoStylePizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("chess")){
            pizza = new ChicagoStyleChessPizza();
        }else if(type.equals("greek")){
            pizza = new ChicagoStyleGreekPizza();
        }else if(type.equals("pepper")){
            pizza = new ChicagoStylePepperPizza();
        }
        return pizza;
    }
}


//披萨接口
abstract class Pizza{
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare(){
        System.out.println("prepare");
        toppings.forEach(e -> System.out.println(" " + e));
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

    public String getName() {
        return name;
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

//纽约芝士披萨
class NYStyleChessPizza extends Pizza{
    public NYStyleChessPizza(){
        name = "NYStyleChessPizza";
        dough = "thin crust Dough";
        sauce = "marinara sauce";
        toppings.add("grated reggiano chess");
    }
}

//纽约希腊披萨
class NYStyleGreekPizza extends Pizza{
    public NYStyleGreekPizza(){
        name = "NYStyleGreekPizza";
    }
}

//纽约胡椒披萨
class NYStylePepperPizza extends Pizza{
    public NYStylePepperPizza(){
        name = "NYStylePepperPizza";
    }
}

//芝加哥芝士披萨
class ChicagoStyleChessPizza extends Pizza{
    public ChicagoStyleChessPizza(){
        name = "ChicagoStyleChessPizza";
        dough = "extra thick crust Dough";
        sauce = "plum tomato sauce";
        toppings.add("shredded mozz chess");
    }

    @Override
    void cut() {
        System.out.println("cutting the pizza into square slices");
    }
}

//芝加哥希腊披萨
class ChicagoStyleGreekPizza extends Pizza{
    public ChicagoStyleGreekPizza(){
        name = "ChicagoStyleGreekPizza";
    }
}

//芝加哥胡椒披萨
class ChicagoStylePepperPizza extends Pizza{
    public ChicagoStylePepperPizza(){
        name = "ChicagoStylePepperPizza";
    }
}