package com.github.dge1992.headfirst.test._4_2;

public class NewYork2Pizza extends Pizza{

    public NewYork2Pizza(){
        name = "NewYork2Pizza";
        dough = "NewYork2Pizza_dough";
        sauce = "NewYork2Pizza_sauce";

        toppings.add("NewYork2Pizza toppings");
    }

    @Override
    void cut() {
        System.out.println("NewYork2Pizza cut");
    }
}
