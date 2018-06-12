package com.github.design_mode.flyweight;

/**
 * 享元模式
 */
public class Test2 {

    /**
     * 只用一个树实例和一个客户对象来维护”所有“树的状态。
     * @param args
     */
    public static void main(String[] args) {
        TreeManager treeManager = new TreeManager();
        treeManager.displayTree();
    }
}

/**
 * 客户对象
 */
class TreeManager{

    int[][] treeArray = {{10,10,10},{20,20,20},{30,30,30}};

    public void displayTree() {
        for (int i = 0; i < treeArray.length; i++) {
            FlyweightTree.display(treeArray[i][0], treeArray[i][1], treeArray[i][2]);
        }
    }
}

/**
 * 树实例
 */
class FlyweightTree{

    public static void display(int xCoord, int yCoord, int age) {
        System.out.println("Position is (" + xCoord + " , " + yCoord + ") , age is " + age + ".)");
    }
}
