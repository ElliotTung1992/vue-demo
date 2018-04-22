package com.github.design_mode.templet.part2;

public class Part2 {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        Tea tea = new Tea();
        tea.prepareRecipe();
    }
}


abstract class CaffeineBeverage{

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantCondiments()){
            addCondiments();
        }

    }

    public void boilWater(){
        System.out.println("boil Water");
    }

    public void pourInCup(){
        System.out.println("pour In Cup");
    }

    boolean customerWantCondiments(){
        return true;
    }

    abstract void brew();

    abstract void addCondiments();
}

//咖啡
class Coffee extends CaffeineBeverage{

    public void addCondiments() {
        System.out.println("addSugarAndMilk");
    }

    public void brew() {
        System.out.println("brewCoffeeGrinds");
    }
}

//茶
class Tea extends CaffeineBeverage{

    public void addCondiments() {
        System.out.println("addLemon");
    }

    public void brew() {
        System.out.println("steepTeaBag");
    }
}
