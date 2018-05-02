package com.github.design_mode.iterator.part2;

import java.util.ArrayList;

/**
 * 迭代器模式
 */
public class Part2 {

    public static void main(String[] args) {
        Waitress waitress = new Waitress(new PancakeHouseMenu(), new DinerMenu());
        waitress.printMenu();
    }
}

/**
 * 服务员
 */
class Waitress{

    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu(){
        Iterator iterator1 = pancakeHouseMenu.createIterator();
        Iterator iterator = dinerMenu.createIterator();

        printMenu(iterator1);
        printMenu(iterator);
    }

    public void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.description);
        }
    }
}

/**
 * 迭代器
 */
interface Iterator{
    boolean hasNext();
    Object next();
}

/**
 * 晚餐的迭代器
 */
class DinerMenuIterator implements Iterator{

    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(menuItems[position] == null || position >= menuItems.length){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position ++;
        return menuItem;
    }
}

/**
 * 早餐的迭代器
 */
class PancakeHouseMenuIterator implements Iterator{

    ArrayList menuItems;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.size() || menuItems.get(position)== null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) menuItems.get(position);
        position ++;
        return menuItem;
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

//    public ArrayList getMenuItems() {
//        return menuItems;
//    }

    public Iterator createIterator(){
        PancakeHouseMenuIterator pancakeHouseMenuIterator = new PancakeHouseMenuIterator(menuItems);
        return pancakeHouseMenuIterator;
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

//    public MenuItem[] getMenuItems() {
//        return menuItems;
//    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
