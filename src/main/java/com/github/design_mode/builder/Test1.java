package com.github.design_mode.builder;

/**
 * 生成器模式
 */
public class Test1 {

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder1());
        Product product = director.constructProduct();
        System.out.println(product);

        director.setBuilder(new ConcreteBuilder2());
        Product product2 = director.constructProduct();
        System.out.println(product2);
    }
}

/**
 * 指挥者
 */
class Director{

    Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product constructProduct(){
        builder.buildpartA();
        builder.buildpartB();
        builder.buildpartC();
        return builder.returnProduct();
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
}

/**
 * 抽象创建者
 */
abstract class Builder{

    Product product;

    abstract void buildpartA();
    abstract void buildpartB();
    abstract void buildpartC();

    public Product returnProduct(){
        return product;
    }
}

/**
 * 具体创建者1
 */
class ConcreteBuilder1 extends Builder {

    public ConcreteBuilder1(){
        super.product = new Product();
    }

    @Override
    void buildpartA() {
        product.setPartA("haha");
    }

    @Override
    void buildpartB() {
        product.setPartB("hehe");
    }

    @Override
    void buildpartC() {
        product.setPartC("xixi");
    }
}

/**
 * 具体创建者2
 */
class ConcreteBuilder2 extends Builder {

    public ConcreteBuilder2(){
        super.product = new Product();
    }

    @Override
    void buildpartA() {
        product.setPartA("111");
    }

    @Override
    void buildpartB() {
        product.setPartB("222");
    }

    @Override
    void buildpartC() {
        product.setPartC("333");
    }
}

/**
 * 商品
 */
class Product{

    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
