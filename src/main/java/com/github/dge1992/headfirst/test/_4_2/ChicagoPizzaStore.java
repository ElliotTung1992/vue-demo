package com.github.dge1992.headfirst.test._4_2;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if(type.equals("1")){
            return new Chicago1Pizza();
        }else if(type.equals("2")){
            return new Chicago2Pizza();
        }
        return null;
    }
}
