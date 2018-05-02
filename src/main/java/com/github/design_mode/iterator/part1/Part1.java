package com.github.design_mode.iterator.part1;

import java.util.ArrayList;

/**
 * 迭代器模式
 */
public class Part1 {

    public static void main(String[] args) {
        Alice alice = new Alice();
        alice.printMenu();
    }
}

/**
 * 菜单项
 */
class MenuItem{

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
}

/**
 * 煎饼屋菜单实现
 */
class PancakeHouseMenu{

    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();

        addMenuItem("K&B's Pancake Breakfast",
                "Pancake with scrambled eggs, and toast",
                true,
                2.99);

        addMenuItem("Regular Pancake Breakfast",
                "Pancake with fried eggs, and sausage",
                false,
                2.99);

        addMenuItem("Blueberry Pancake",
                "Pancake made with fresh blueberries",
                true,
                3.49);

        addMenuItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);

    }

    public void addMenuItem(String name, String description, boolean vegeterian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegeterian, price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }
}

/**
 * 晚餐菜单
 */
class DinerMenu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];

        addMenuItem("Vegetarian BLT",
                "Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);

        addMenuItem("BLT",
                "Bacon with lettuce & tomato on whole whrat",
                false,
                2.99);

        addMenuItem("Soup of the day",
                "Soup of the day with a side of potato salad",
                false,
                3.29);

        addMenuItem("Hotdog",
                "A hot dog, with a side of potato salad",
                false,
                3.09);
    }

    public void addMenuItem(String name, String description, boolean vegeterian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegeterian, price);
        if (numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry, menu is full! Can't add item to menu");
        }else{
            menuItems[numberOfItems] = menuItem;
            numberOfItems ++;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}

/**
 * 服务员
 */
class Alice{

    public void printMenu(){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        ArrayList menuItems = pancakeHouseMenu.getMenuItems();
        MenuItem[] menuItems1 = dinerMenu.getMenuItems();

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = (MenuItem) menuItems.get(i);
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.description);
        }

        for (int i = 0; i < menuItems1.length; i++) {
            MenuItem menuItem = menuItems1[i];
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.description);
        }
    }
}



















