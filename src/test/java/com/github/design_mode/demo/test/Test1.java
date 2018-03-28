package com.github.design_mode.demo.test;

import java.util.stream.IntStream;

public class Test1 {

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(e -> System.out.println(e));
    }
}
