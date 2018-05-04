package com.github.design_mode.component.part1;

import java.util.ArrayList;
import java.util.Iterator;

public class Part1 {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake house menu", "breakfast");
        MenuComponent lunchMenu = new Menu("Lunch Menu", "lunch");
        MenuComponent cafeMenu = new Menu("Cafe Menu", "lunch");
        MenuComponent dessertMenu = new Menu("Dessert Menu", "dinner");

        MenuComponent allMenu = new Menu("All Menu", "lol");

        allMenu.add(pancakeHouseMenu);
        allMenu.add(lunchMenu);
        allMenu.add(cafeMenu);
        allMenu.add(dessertMenu);

        lunchMenu.add(new MenuItem("K&B's Pancake Breakfast",
                "Pancake with scrambled eggs, and toast",
                true,
                2.99));

        lunchMenu.add(new MenuItem("Regular Pancake Breakfast",
                "Pancake with fried eggs, and sausage",
                false,
                2.99));

        lunchMenu.add(new MenuItem("Blueberry Pancake",
                "Pancake made with fresh blueberries",
                true,
                3.49));

        Waitress waitress = new Waitress(allMenu);
        waitress.print();

    }
}

/**
 * 服务员
 */
class Waitress{
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void print(){
        allMenus.print();
    }
}

/**
 * 菜单
 */
class Menu extends MenuComponent{
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent) menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("---------------");
        System.out.println(getName());
        System.out.println(getDescription());
        System.out.println("---------------");

        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}

/**
 * 菜单组件
 */
abstract class MenuComponent{

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegeterian() {
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}

/**
 * 菜单项
 */
class MenuItem extends MenuComponent{

    String name;
    String description;
    boolean vegeterian;
    double price;

    public MenuItem(String name, String description, boolean vegeterian, double price) {
        this.name = name;
        this.description = description;
        this.vegeterian = vegeterian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public void setVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print() {
        System.out.println(getName());
        System.out.println(getDescription());
        System.out.println(getPrice());
        System.out.println(isVegeterian());
    }
}
