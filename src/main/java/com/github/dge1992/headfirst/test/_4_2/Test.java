package com.github.dge1992.headfirst.test._4_2;

public class Test {

    public static void main(String[] args) {
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();

        Pizza pizza = chicagoPizzaStore.orderPizza("2");
        newYorkPizzaStore.orderPizza("2")
    }
}
