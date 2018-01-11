package com.github.dge1992.headfirst.test._3_1;

public class Test {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        DarkRoast darkRoast = new DarkRoast();
        String description = darkRoast.getDescription();
        System.out.println(description);

        darkRoast.setMilk(true);
        darkRoast.setMocha(true);
        double cost = darkRoast.cost();
        System.out.println(cost);
    }
}
