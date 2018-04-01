package com.github.design_mode.decker.part3;

//装饰者模式
public class Decker {

    public static void main(String[] args) {
        //老板来一碗牛肉面
        Noodles noodles = new BeefNoodles();
        //价格鸡蛋
        noodles = new Egg(noodles);
        //加个面结
        noodles = new Mianjie(noodles);
        System.out.println(noodles.getDesc() + " " + noodles.cost());
    }
}

//面条
abstract class Noodles{
    String desc = "";

    abstract double cost();

    public String getDesc() {
        return desc;
    }
}

//面条装饰者
abstract class NoodlesDecorator extends Noodles{

    public abstract String getDesc();
}

//牛肉面
class BeefNoodles extends Noodles{

    public BeefNoodles(){
        desc += "BeefNoodles ";
    }

    @Override
    double cost() {
        return 15.00;
    }
}

//羊肉面
class SheepNoodles extends Noodles{

    public SheepNoodles(){
        desc += "SheepNoodles ";
    }

    @Override
    double cost() {
        return 20.00;
    }
}

//海鲜面
class SeaNoodles extends Noodles{

    public SeaNoodles(){
        desc += "SeaNoodles ";
    }

    @Override
    double cost() {
        return 25.00;
    }
}

//鸡蛋
class Egg extends NoodlesDecorator{

    Noodles noodles;

    public Egg(Noodles noodles){
        this.noodles = noodles;
    }

    @Override
    double cost() {
        return 3.00 + noodles.cost();
    }

    @Override
    public String getDesc() {
        return noodles.getDesc() + " 加鸡蛋";
    }
}

//面结
class Mianjie extends NoodlesDecorator{

    Noodles noodles;

    public Mianjie(Noodles noodles){
        this.noodles = noodles;
    }

    @Override
    double cost() {
        return 5.00 + noodles.cost();
    }

    @Override
    public String getDesc() {
        return noodles.getDesc() + " 加面结";
    }
}

//豆腐
class Tofu extends NoodlesDecorator{

    Noodles noodles;

    public Tofu(Noodles noodles){
        this.noodles = noodles;
    }

    @Override
    double cost() {
        return 4.00 + noodles.cost();
    }

    @Override
    public String getDesc() {
        return noodles.getDesc() + " 加豆腐";
    }
}


