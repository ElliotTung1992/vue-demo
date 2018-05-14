package com.github.design_mode.state.part2;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        System.out.println(random.nextInt(10));
    }
}
