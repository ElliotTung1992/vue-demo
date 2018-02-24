package com.github.dge1992.factory.part2;

public class Store {

    SimplePizzaFactory factory;

    public Store(SimplePizzaFactory factory){
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        /**
         * 把这里的代码抽取出来创建一个新的类
         * 我们称为工厂类
         */
//        Pizza pizza = null;
//        if(type.equals("beef")){
//            pizza = new BeefPizza();
//        }
//        else if(type.equals("fish")){
//            pizza = new FishPizza();
//        }
//        else if(type.equals("pig")){
//            pizza = new PigPizza();
//        }
        Pizza pizza = factory.createPizza("");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}

interface SimplePizzaFactory{

    Pizza createPizza(String type);
}

class NingboPizzaFactory implements SimplePizzaFactory{

    @Override
    public Pizza createPizza(String type) {
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
        return pizza;
    }
}

class ShangHaiPizzaFactory implements SimplePizzaFactory{

    @Override
    public Pizza createPizza(String type) {
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
