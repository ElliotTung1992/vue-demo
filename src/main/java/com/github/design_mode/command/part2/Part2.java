package com.github.design_mode.command.part2;

public class Part2 {

    public static void main(String[] args) {
        //顾客小明
        Customer customer = new Customer("小明");

        //小明想吃红烧鱼
        CookA cookA = new CookA();
        HongShaoYuOrder hongShaoYuOrder = new HongShaoYuOrder(cookA);

        //告诉服务员
        Waiter waiter = new Waiter();
        waiter.setOrder(hongShaoYuOrder);

        //服务员提交订单
        waiter.commit();

        //顾客小红
        Customer customerB = new Customer("小红");

        //小明想吃红烧鱼
        waiter.setOrder(hongShaoYuOrder);

        //服务员提交订单
        waiter.commit();


    }
}

//客户
class Customer{

    String name;

    public Customer(String name){
        this.name = name;
    }
}

//订单
interface Order{
    //提交订单
    void orderUp();
}

//红烧鱼订单
class HongShaoYuOrder implements Order{

    CookA cookA;

    HongShaoYuOrder(CookA cookA){
        this.cookA = cookA;
    }

    @Override
    public void orderUp() {
        cookA.cooking("红烧鱼");
    }
}

//白斩鸡订单
class BaiZhanJi implements Order{

    CookB cookB;

    BaiZhanJi(CookB cookB){
        this.cookB = cookB;
    }

    @Override
    public void orderUp() {
        cookB.cooking("白斩鸡");
    }
}

//服务员
class Waiter{

    Order order;

    public Waiter(){

    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void commit(){
        order.orderUp();
    }
}

//厨师
class Cook{
    String name;
    public void cooking(String orderName){
        System.out.println(name + "正在做:" + orderName);
    }
}

class CookA extends Cook{
    public CookA(){
        super.name = "CookA";
    }
}

class CookB extends Cook{
    public CookB(){
        super.name = "CookB";
    }
}
