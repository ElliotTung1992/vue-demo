package com.github.design_mode.factory;

//工厂方法
public class Factory {

    public static void main(String[] args) {
        ShoeShop shoeShop = new NikeShoesShop();
        shoeShop.returnShoes("NikeAirFoamposite");
        shoeShop = new AdidasShoesShop();
        shoeShop.returnShoes("YeezyBoost");
    }
}

//鞋店
abstract class ShoeShop{

    public Shoes returnShoes(String type){
        Shoes shoes;
        shoes = createShoes(type);
        shoes.tryOn();
        return shoes;
    }

    abstract Shoes createShoes(String type);
}

//Nike鞋店
class NikeShoesShop extends ShoeShop{

    @Override
    Shoes createShoes(String type) {
        Shoes shoes = null;
        if(type.equals("NikeAirFoamposite")){
            shoes = new NikeAirFoamposite();
        }else if(type.equals("AirJordan")){
            shoes = new AirJordan();
        }
        return shoes;
    }
}

//Adidas鞋店
class AdidasShoesShop extends ShoeShop{

    @Override
    Shoes createShoes(String type) {
        Shoes shoes = null;
        if(type.equals("YeezyBoost")){
            shoes = new YeezyBoost();
        }else if(type.equals("NMDHumn")){
            shoes = new NMDHumn();
        }
        return shoes;
    }
}

//鞋子
abstract class Shoes{
    String name;
    //试穿
    void tryOn(){
        System.out.println("试穿");
    }
}


class YeezyBoost extends Shoes{
    public YeezyBoost(){
        name = "YeezyBoost";
    }

    @Override
    void tryOn() {
        System.out.println("踩屎感 买买买");
    }
}

class NMDHumn extends Shoes{
    public NMDHumn(){
        name = "NMDHumn";
    }
}

class NikeAirFoamposite extends Shoes{
    public NikeAirFoamposite(){
        name = "NikeAirFoamposite";
    }

    @Override
    void tryOn() {
        System.out.println("内靴,不是很舒服！！！");
    }
}

class AirJordan extends Shoes{
    public AirJordan(){
        name = "AirJordan";
    }

    @Override
    void tryOn() {
        System.out.println("这鞋颜值真高");
    }
}
