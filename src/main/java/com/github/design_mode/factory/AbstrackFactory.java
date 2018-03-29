package com.github.design_mode.factory;

//抽象工厂
public class AbstrackFactory {

    public static void main(String[] args) {
        //来一碗宁波蛋炒饭
        EggsRice eggsRice = SimpleFactory.createEggsRice("NB");
        eggsRice.fry();
    }
}

//class HardCoded{
//
//    public EggsRice fryEggsRice(String type){
//        EggsRice eggsRice = null;
//        if(type.equals("NB")){
//            eggsRice = new EggsRice(new EggsA(), new RiceA());
//        }else if(type.equals("SH")){
//            eggsRice = new EggsRice(new EggsB(), new RiceB());
//        }
//        return eggsRice;
//    }
//}

//简单工厂
class SimpleFactory{

    public static EggsRice createEggsRice(String type){
        EggsRice eggsRice = null;
        if(type.equals("NB")){
            eggsRice = new EggsRice(new NBStyleEggsRiceFactory());
        }else if(type.equals("SH")){
            eggsRice = new EggsRice(new SHStyleEggsRiceFactory());
        }
        return eggsRice;
    }
}

//蛋炒饭
class EggsRice{

    Eggs eggs;
    Rice rice;
    EggsRiceFactory eggsRiceFactory;

    EggsRice(EggsRiceFactory eggsRiceFactory){
        this.eggsRiceFactory = eggsRiceFactory;
    }

    public void fry(){
        this.eggs = eggsRiceFactory.createEggs();
        this.rice = eggsRiceFactory.createRice();
        System.out.println("用" + eggs.name + "和" + rice.name + "炒");
    }
}

//蛋炒饭工厂
interface EggsRiceFactory{
    Eggs createEggs();
    Rice createRice();
}

//宁波蛋炒饭
class NBStyleEggsRiceFactory implements EggsRiceFactory{

    @Override
    public Eggs createEggs() {
        return new EggsA();
    }

    @Override
    public Rice createRice() {
        return new RiceA();
    }
}

//上海蛋炒饭
class SHStyleEggsRiceFactory implements EggsRiceFactory{

    @Override
    public Eggs createEggs() {
        return new EggsB();
    }

    @Override
    public Rice createRice() {
        return new RiceB();
    }
}

//鸡蛋
abstract class Eggs{
    String name;
}

//米饭
abstract class Rice{
    String name;
}

//鸡蛋A
class EggsA extends Eggs{

    public EggsA(){
        name = "EggsA";
    }
}

//鸡蛋B
class EggsB extends Eggs{
    public EggsB(){
        name = "EggsB";
    }
}

//米饭A
class RiceA extends Rice{
    public RiceA(){
        name = "RiceA";
    }
}

//米饭B
class RiceB extends Rice{
    public RiceB(){
        name = "RiceB";
    }
}