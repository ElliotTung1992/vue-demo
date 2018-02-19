package com.github.dge1992.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式的写法有好几种：懒汉式单例, 恶汉式单例, 登记式单例
 *
 * 单例类有以下特点：
 * 1.单例类只能有一个实例
 * 2.单例类必须自己创建自己的唯一实例
 * 3.单例类必须给其他对象提供这一实例
 *
 *
 * 恶汉式和懒汉式的区别：
 * 恶汉就是类一旦加载，就把实例初始化完成，保证在getInstance的时候，实例就已经存在了
 * 而懒汉比较懒，只有当第一次调用getInstance的时候，才会去初始化这个单例。
 *
 * 1.线程安全
 * 恶汉式天生是线程安全的，可以直接用于多线程而不会出现问题
 * 懒汉式本身是非线程安全的
 *
 * 2.资源加载和性能
 * 恶汉式在类创建的同时就实例化静态实例，不管之后会不会使用这个单例，都会占据一定的内存，
 * 但是相应的，在第一次调用时速度也会更快，因为其资源已经初始化完成，
 *
 * 而懒汉式顾名思义，会延迟加载，在第一次使用该单例的时候才会实例化对象出来，
 * 第一次调用时要做初始化，如果要做的工作比较多，性能上会有些延迟，之后就和饿汉式一样了。
 *
 */


public class Singleton {

    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.setName("dong");
        singleton1.setAge(11);
        Singleton1 singleton11 = Singleton1.getInstance();
        System.out.println(singleton11.getName());
        System.out.println(singleton11.getAge());
        System.out.println(singleton1 == singleton11);

        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.setName("feng");
        singleton2.setAge(99);
        Singleton2 singleton22 = Singleton2.getInstance();
        System.out.println(singleton22.getName());
        System.out.println(singleton22.getAge());
        System.out.println(singleton2 == singleton22);

        Singleton3 singleton3 = Singleton3.getInstance(null);
        System.out.println(singleton3.about());
        Singleton31 singleton31 = (Singleton31) Singleton3.getInstance("com.github.dge1992.singleton.Singleton31");
        System.out.println(singleton31.about());
        singleton31.setName("paul");
        singleton31.setAge(34);
        Singleton31 singleton31_2 = (Singleton31) Singleton3.getInstance("com.github.dge1992.singleton.Singleton31");
        System.out.println(singleton31_2.getName());
        System.out.println(singleton31_2.getAge());

    }
}

/**
 * 懒汉式
 */
class Singleton1{

    private Singleton1(){}
    private static Singleton1 singleton1 = null;
    public static Singleton1 getInstance(){
        if(singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

/**
 * 线程安全懒汉式1
 *
 * 第1种，在方法调用上加了同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟99%的情况下是不需要同步的，
 */
class Singleton11{

    private Singleton11(){}
    private static Singleton11 singleton11 = null;
    public static synchronized Singleton11 getInstance(){
        if(singleton11 == null){
            singleton11 = new Singleton11();
        }
        return singleton11;
    }
}

/**
 * 线程安全懒汉式2
 *
 * 在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗
 */
class Singleton12{

    private Singleton12(){}
    private static Singleton12 singleton12 = null;
    public static Singleton12 getInstance(){
        if(singleton12 == null){
            synchronized (Singleton12.class) {
                if (singleton12 == null) {
                    singleton12 = new Singleton12();
                }
            }
        }
        return singleton12;
    }
}


/**
 * 线程安全懒汉式3
 *
 * 利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所以一般我倾向于使用这一种。
 */
class Singleton13{

    private static class LazyHolder {
        private static final Singleton13 INSTANCE = new Singleton13();
    }
    private Singleton13 (){}
    public static final Singleton13 getInstance() {
        return LazyHolder.INSTANCE;
    }
}


/**
 * 恶汉式
 */
class Singleton2{

    private Singleton2(){}
    private static final Singleton2 singleton2 = new Singleton2();
    public static Singleton2 getInstance(){
        return singleton2;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


/**
 * 登记式单例
 */
class Singleton3{

    private static Map<String, Singleton3> map = new HashMap<>();
    static {
        Singleton3 singleton3 = new Singleton3();
        map.put(singleton3.getClass().getName(), singleton3);
    }
    protected Singleton3(){}
    public static Singleton3 getInstance(String name){
        if(name == null) {
            name = Singleton3.class.getName();
            System.out.println("name="+name);
        }
        if(map.get(name) == null) {
            try {
                map.put(name, (Singleton3) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    public String about() {
        return "Hello, I am Singleton3.";
    }
}

class Singleton31 extends Singleton3{
    public String about() {
        return "Hello, I am Singleton31.";
    }
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


