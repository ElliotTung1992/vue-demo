package com.github.design_mode.strategy.headfirst.part2;

public class Test {

    public static void main(String[] args) {
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.fly();

        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.display();
    }
}
