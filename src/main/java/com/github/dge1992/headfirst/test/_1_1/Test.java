package com.github.dge1992.headfirst.test._1_1;

/**
 * @author  dong
 * @create  2018/1/9 16:30
 * @desc 策略模式解决问题
 **/
public class Test {

    public static void main(String[] args) {
        ADuck aDuck = new ADuck();
        BDuck bDuck = new BDuck();
        aDuck.performFly();
        aDuck.performQuack();
        aDuck.display();
        aDuck.swim();
        bDuck.performFly();
        bDuck.performQuack();
        bDuck.display();
        bDuck.swim();

        System.out.println("---------------------");
        CDuck cDuck = new CDuck();
        cDuck.performFly();
        cDuck.setFlyBehavior(new FlyWithWings());
        cDuck.performFly();
    }

}
