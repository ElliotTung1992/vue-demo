package com.github.design_mode.strategy.headfirst.part3;

public class Part3 {

    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.performFly();

        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.setFlyBehavior(new FlyLikeRocket());

        mallardDuck.performFly();
    }
}

//超类
abstract class Duck{

    //面向接口编程
    FlyBehavior flyBehavior;

    void performFly(){
        //让子类进行具体实现
        flyBehavior.fly();
    }

    //动态设定行为
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void swim(){
        System.out.println("游泳");
    }

    abstract void display();
}

//绿头鸭
class MallardDuck extends Duck{

    MallardDuck(){
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("绿头鸭");
    }
}

//木头鸭不会飞
class RubberDuck extends Duck{

    RubberDuck(){
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("木头做的");
    }
}

//飞行接口
interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("用翅膀飞行");
    }
}

class FlyLikeRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("像火箭一样发射");
    }
}

class FlyNoWay implements  FlyBehavior{

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}


