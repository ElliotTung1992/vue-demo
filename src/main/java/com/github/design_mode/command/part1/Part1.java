package com.github.design_mode.command.part1;

public class Part1 {

    public static void main(String[] args) {
    Customer customerA = new Customer("小明");
    CookA cookA = new CookA("厨师师傅A");
    customerA.order("红烧鱼", cookA);

    Customer customerb = new Customer("小红");
    CookB cookB = new CookB("厨师师傅B");
    customerb.order("白斩鸡", cookB);
}
}

class Customer{
    String name;
    public Customer(String name){
        this.name = name;
    }
    public void order(String orderName, Cook cook){
        System.out.println(name + "点了" + orderName + "," + cook.name + "来接单");
        cook.cooking(orderName);
    }
}

class Cook{
    String name;
    public void cooking(String orderName){
        System.out.println(name + "正在做:" + orderName);
    }
}

class CookA extends Cook{
    public CookA(String name){
        super.name = name;
    }
}

class CookB extends Cook{
    public CookB(String name){
        super.name = name;
    }
}

