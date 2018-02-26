package com.github.dge1992.factory.part4;

/**
 * 抽象工厂模式:
 * 提供一个借口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
 */
public class PizzaStore {


}

interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();

}

class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoChess();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies Veggies[] = {new Onion()};
        return Veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}

class ChessPizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public ChessPizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing" + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}

abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Veggies veggies[];
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();
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

    public void setName(String name) {
        this.name = name;
    }
}

class Dough {

}

class ThinCrustDough extends Dough{

}

class Sauce {

}

class MarinaraSauce extends Sauce{

}

class Cheese {

}

class ReggianoChess extends Cheese{

}

class Veggies {

}

class Onion extends Veggies{

}

class Pepperoni {

}

class SlicedPepperoni extends Pepperoni{

}

class Clams {

}

class FreshClams extends Clams{

}
