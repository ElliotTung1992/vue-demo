package com.github.design_mode.flyweight;

/**
 * 享元模式
 */
public class Test1 {

    /**
     * 创建多个树对象，内存负担大
     * @param args
     */
    public static void main(String[] args) {
        Tree tree1 = new Tree(10, 10, 10);
        Tree tree2 = new Tree(20, 20, 20);
        Tree tree3 = new Tree(30, 30, 30);
        Tree tree4 = new Tree(40, 40, 40);

        tree1.display();
        tree2.display();
        tree3.display();
        tree4.display();
    }
}

class Tree{

    private int  xCoord;

    private int yCoord;

    private int age;

    public Tree(int xCoord, int yCoord, int age) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.age = age;
    }

    public void display() {
        System.out.println("Position is (" + xCoord + " , " + yCoord + " , age is " + age + ".)");
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
