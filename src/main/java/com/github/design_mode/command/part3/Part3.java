package com.github.design_mode.command.part3;

import java.util.ArrayList;
import java.util.List;

public class Part3 {

    public static void main(String[] args) {
        Customer customerA = new Customer("小明");
        Customer customerB = new Customer("小红");

        Waiter waiter = new Waiter();

        CookA cookA = new CookA();
        CookB cookB = new CookB();
        //先点一个红烧肉
        HongShaoYuOrder hongShaoYuOrder = new HongShaoYuOrder(cookA);
        waiter.setOrder(hongShaoYuOrder);
        waiter.commit();

        //再点一个白斩鸡
        BaiZhanJi baiZhanJi = new BaiZhanJi(cookB);
        waiter.setOrder(baiZhanJi);
        waiter.commit();

        //再点一个鱼香肉丝
        YuXiangRouSi yuXiangRouSi = new YuXiangRouSi(cookB);
        waiter.setOrder(yuXiangRouSi);
        waiter.commit();

        //满三个提交

        //再点一个蛋花汤
        DanHuaTang danHuaTang = new DanHuaTang(cookB);
        waiter.setOrder(danHuaTang);
        waiter.commit();

        //撤销红烧肉
        boolean undo = waiter.undo(hongShaoYuOrder);
        System.out.println(undo);
        //撤销蛋花汤
        boolean undo1 = waiter.undo(danHuaTang);
        System.out.println(undo1);
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

//鱼香肉丝订单
class YuXiangRouSi implements Order{

    CookB cookB;

    YuXiangRouSi(CookB cookB){
        this.cookB = cookB;
    }

    @Override
    public void orderUp() {
        cookB.cooking("鱼香肉丝");
    }
}

//蛋花汤订单
class DanHuaTang implements Order{

    CookB cookB;

    DanHuaTang(CookB cookB){
        this.cookB = cookB;
    }

    @Override
    public void orderUp() {
        cookB.cooking("蛋花汤");
    }
}

//服务员
class Waiter{

    List<Order> orders;

    public Waiter(){
        orders = new ArrayList<>();
    }

    public void setOrder(Order order){
        orders.add(order);
    }

    public void commit(){
        if(orders.size() >= 3){
            orders.stream().forEach(e -> e.orderUp());
            orders.clear();
        }
    }

    public boolean undo(Order order){
        boolean b = false;
        int index = orders.indexOf(order);
        if(index >= 0){
            orders.remove(index);
            b = true;
        }
        return b;
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
