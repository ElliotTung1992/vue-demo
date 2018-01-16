package com.github.dge1992.headfirst.test._4_1;

public class PizzaStore {
    SimplePizzaFactory pizzaFactory;

    public PizzaStore(SimplePizzaFactory factory){
        this.pizzaFactory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
