package com.github.design_mode.bridge;

/**
 * 桥接模式
 *
 * 耦合
 */
public class Test1 {

    public static void main(String[] args) {

    }
}

//形状
interface Shape{
    void desc();
}

//圆形
class Circle implements Shape{

    @Override
    public void desc() {
        System.out.println("圆形");
    }
}

//红色圆形
class RedCircle extends Circle{

    @Override
    public void desc() {
        System.out.println("红色圆形");
    }
}

//黄色圆形
class YellowCircle extends Circle{

    @Override
    public void desc() {
        System.out.println("黄色圆形");
    }
}








