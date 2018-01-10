package com.github.dge1992.headfirst.test._1;

/**
 * @author  dong
 * @create  2018/1/9 16:29
 * @desc 策略模式抛出问题
 **/
public class Test {

    public static void main(String[] args) {
        Test.run();
    }

    private static void run() {
        test1();
    }

    private static void test1() {
        ADuck aDuck = new ADuck();
        BDuck bDuck = new BDuck();
        aDuck.quack();
        aDuck.swim();
        aDuck.display();
        bDuck.quack();
        bDuck.swim();
        bDuck.display();
        aDuck.fly();
        bDuck.fly();
        aDuck.run();
        bDuck.run();
    }
}
