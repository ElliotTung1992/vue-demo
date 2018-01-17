package com.github.dge1992.headfirst.test._4_2;

public class NewYorkPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if(type.equals("1")){
            return new NewYork1Pizza();
        }else if(type.equals("2")){
            return new NewYork2Pizza();
        }
        return null;
    }
}
