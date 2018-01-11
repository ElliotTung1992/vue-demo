package com.github.dge1992.headfirst.test._3;

public class Test {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HouseBlend houseBlend = new HouseBlend();
        String description = houseBlend.getDescription();
        System.out.println(description);
        houseBlend.cost();

        DarkRoast darkRoast = new DarkRoast();
        String description1 = darkRoast.getDescription();
        System.out.println(description1);
        darkRoast.cost();
    }
}
