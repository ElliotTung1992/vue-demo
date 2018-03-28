package com.github.design_mode.factory;

public class SimpleDemo {

    public static void main(String[] args) {
        Creator creator1 = new CreatorA();
        Product product1 = creator1.createProduct("1");
        System.out.println(product1.name);

        Creator creator2 = new CreatorB();
        Product product2 = creator2.createProduct("2");
        System.out.println(product2.name);
    }
}

//工厂接口
abstract class Creator{

    //创建商品
    abstract Product createProduct(String type);
}

//产品接口
abstract class Product{
    String name;
}

//产品A_1
class ProductA_1 extends Product{
    ProductA_1(){
        name = "ProductA_1";
    }
}

//产品A_2
class ProductA_2 extends Product{
    ProductA_2(){
        name = "ProductA_2";
    }
}

//产品B_1
class ProductB_1 extends Product{
    ProductB_1(){
        name = "ProductB_1";
    }
}

//产品B_2
class ProductB_2 extends Product{
    ProductB_2(){
        name = "ProductB_2";
    }
}

//A工厂创建产品A系列
class CreatorA extends Creator{

    @Override
    Product createProduct(String type) {
        Product product = null;
        if(type.equals("1")){
            product = new ProductA_1();
        }else if(type.equals("2")){
            product = new ProductA_2();
        }
        return product;
    }
}

//B工厂创建产品B系列
class CreatorB extends Creator{

    @Override
    Product createProduct(String type) {
        Product product = null;
        if(type.equals("1")){
            product = new ProductB_1();
        }else if(type.equals("2")){
            product = new ProductB_2();
        }
        return product;
    }
}

