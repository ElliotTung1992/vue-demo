package com.github.design_mode.templet.part1;

public class Part1 {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        Tea tea = new Tea();
        tea.prepareRecipe();
    }

}

//咖啡
class Coffee{

    //泡咖啡步骤
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    private void addSugarAndMilk() {
        System.out.println("addSugarAndMilk");
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }

    private void brewCoffeeGrinds() {
        System.out.println("brewCoffeeGrinds");
    }

    private void boilWater() {
        System.out.println("boilWater");
    }
}

//茶
class Tea{

    //泡茶步骤
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    private void addLemon() {
        System.out.println("addLemon");
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }

    private void steepTeaBag() {
        System.out.println("steepTeaBag");
    }

    private void boilWater() {
        System.out.println("boilWater");
    }
}
