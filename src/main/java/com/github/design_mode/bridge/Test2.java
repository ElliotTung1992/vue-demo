package com.github.design_mode.bridge;

/**
 * 桥接模式
 *
 * 解耦
 */
public class Test2 {

    public static void main(String[] args) {

        White white = new White();
        Red red = new Red();

        Circle2 circle2 = new Circle2();
        circle2.setColor(white);
        circle2.draw();

        Rectangle2 rectangle2 = new Rectangle2();
        rectangle2.setColor(red);
        rectangle2.draw();
    }
}

/**
 * 颜色(实现的类层次)
 */
interface Color{

    void bepaint(String shape);
}

/**
 * 白色
 */
class White implements Color{

    @Override
    public void bepaint(String shape) {
        System.out.println("白色的" + shape);
    }
}

/**
 * 红色
 */
class Red implements Color{

    @Override
    public void bepaint(String shape) {
        System.out.println("红色的" + shape);
    }
}

/**
 * 形状(抽象的类层次)
 */
abstract class Shape2{

    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

/**
 * 圆形
 */
class Circle2 extends Shape2{

    @Override
    public void draw() {
        color.bepaint("圆");
    }
}

/**
 * 长方形
 */
class Rectangle2 extends Shape2{

    @Override
    public void draw() {
        color.bepaint("长方形");
    }
}
