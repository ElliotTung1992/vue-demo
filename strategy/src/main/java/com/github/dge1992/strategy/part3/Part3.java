package com.github.dge1992.strategy.part3;

public class Part3 {

    public static void main(String[] args) {

        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.setQuackBehavior(new MuteQuack());
        mallardDuck.performFly();
        mallardDuck.performQuack();

        BathDuck bathDuck = new BathDuck();
        bathDuck.performFly();
        bathDuck.performQuack();
    }
}

/**
 *
 * 设计原则：
 * 1.找出应用中需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
 * 2.针对接口编程，而不是针对实现编程
 * 3.多用组合，少用继承
 *
 * 策略模式：
 * 定义了算法族，分别封装起来，让它们之间可以相互替换，此模式让算法的变化独立于使用算法的客户
 *
 * 这个例子中我们发现会变的是 fly 和 quack
 * 针对会变得两个行为，抽取出相应的接口 FlyBehavior 和 QuackBehavior 并分别实现了一组算法
 * 把接口作为属性放置到 Duck类
 * 子类在构造方法里实现具体行为
 *
 *
 */
abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    void swim(){
        System.out.println("游泳");
    }
    abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    //动态设定行为
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}

/**
 * 飞行
 */
interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("飞行");
    }
}

class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}

/**
 * 叫
 */
interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("安静好吗？？");
    }
}

class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("外观是绿头");
    }

}

class RedheadDuck extends Duck {

    public RedheadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("外观是红头");
    }

}

class BathDuck extends Duck {

    public BathDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("玩具鸭");
    }

}
