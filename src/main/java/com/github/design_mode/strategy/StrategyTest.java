package com.github.design_mode.strategy;

import java.io.File;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 策略模式
 */
public class StrategyTest {

    public static void main(String[] args) {

        Human human = new Human("小明", 990);

       /*
        用一个工厂方法来封装
        human.setStrategy(null);
        Integer distance = human.getDistance();
        if(distance < 1000){

        }else if(distance >= 1000 && distance < 2000){
            human.setStrategy(new StrategyBike());
        }else if(distance >= 2000){
            human.setStrategy(new StrategyBus());
        }
        Strategy strategy = StrategyFactory.getStrategy(human.getDistance());
        human.setStrategy(strategy);

        human.stragegy();
        */
        StrategyFactory instance = StrategyFactory.getInstance();
        Strategy strategy = instance.createStrategy(human.getDistance());
        human.setStrategy(strategy);
        human.stragegy();
    }
}

//策略工厂
class StrategyFactory{

    /*
        通过自定义注解来优化
        public static Strategy getStrategy(Integer distance){
        Strategy strategy = null;
        if(distance < 1000){
            strategy = new StrategyWalk();
        }else if(distance >= 1000 && distance < 2000){
            strategy = new StrategyBike();
        }else if(distance >= 2000){
            strategy = new StrategyBus();
        }
        return strategy;
        }
    */
    //策略子集所在的包
    private static final String STRATEGY_PACKAGE = "com.github.design_mode.strategy";
    //存放策略子集的集合
    private List<Class<? extends Strategy>> strategyList;
    //类加载器
    private ClassLoader classLoader = getClass().getClassLoader();

    //根据传进来的参数返回对应的策略实例
    public Strategy createStrategy(int distance){
        for (Class<? extends Strategy> clazz:strategyList) {
            DistanceSection distanceSection = handleAnnotation(clazz);
            if(distanceSection != null){
                if(distance >= distanceSection.min() && distance <= distanceSection.max()){
                    try {
                        return clazz.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("获取策略失败");
                    }
                }
            }
        }
        return null;
    }

    //把加上@DistanceSection的策略子集返回注解信息
    private DistanceSection handleAnnotation(Class<? extends Strategy> clazz) {
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        if(declaredAnnotations == null || declaredAnnotations.length == 0){
            return null;
        }
        for (Annotation annotation:declaredAnnotations) {
            if(annotation instanceof DistanceSection){
                return (DistanceSection)annotation;
            }
        }
        return null;
    }

    //找到策略子集并放入集合
    private void init() {
        strategyList = new ArrayList<Class<? extends Strategy>>();
        File[] resources = getResources();
        Class<Strategy> strategyClazz = null;
        try {
            strategyClazz = (Class<Strategy>) classLoader.loadClass(Strategy.class.getName());
//            for (int i = 0; i < resources.length; i++ ){
//                Class<?> clazz = classLoader.loadClass(STRATEGY_PACKAGE + "." + resources[i].getName().replace(".class", ""));
//                if(strategyClazz.isAssignableFrom(clazz) && clazz != strategyClazz){
//                    strategyList.add((Class<? extends Strategy>) clazz);
//                }
//            }
            Class<Strategy> finalStrategyClazz = strategyClazz;
            IntStream.range(0, resources.length)
                    .forEach(e -> {
                        Class<?> clazz = null;
                        try {
                            clazz = classLoader.loadClass(STRATEGY_PACKAGE + "." + resources[e].getName().replace(".class", ""));
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        if(finalStrategyClazz.isAssignableFrom(clazz) && clazz != finalStrategyClazz){
                            strategyList.add((Class<? extends Strategy>) clazz);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取包路径下的资源集
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(STRATEGY_PACKAGE.replace(".", "/")).toURI());
//            return file.listFiles(new FileFilter() {
//                @Override
//                public boolean accept(File pathname) {
//                    if(pathname.getName().endsWith(".class")){
//                        return true;
//                    }
//                    return false;
//                }
//            });
            return file.listFiles(e -> e.getName().endsWith(".class"));
        } catch (Exception e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    StrategyFactory(){
        init();
    }


    public static StrategyFactory getInstance(){
        return StrategyFactoryInstance.instance;
    }

    //通过静态内部类实现单例
    private static class StrategyFactoryInstance{
        private static StrategyFactory instance = new StrategyFactory();
    }
}

//自定义注解
@Target(ElementType.TYPE)//表示只能给类添加注解
@Retention(RetentionPolicy.RUNTIME)//这个必须要将注解保留在运行时
@interface DistanceSection{
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}

//人物类
class Human implements Strategy{

    public Human(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    //姓名
    private String name;
    //距离
    private Integer distance;
    //策略
    private Strategy strategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    //让具体策略实现来执行
    @Override
    public void stragegy() {
        strategy.stragegy();
    }

    //动态切换策略
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

//策略接口
interface Strategy{
    abstract void stragegy();
}

//走路
@DistanceSection(max = 999)
class StrategyWalk implements Strategy{

    @Override
    public void stragegy() {
        System.out.println("走路");
    }
}

//骑自行车
@DistanceSection(min = 1000, max = 1999)
class StrategyBike implements Strategy{

    @Override
    public void stragegy() {
        System.out.println("骑自行车");
    }
}

//乘车
@DistanceSection(min = 2000)
class StrategyBus implements Strategy{

    @Override
    public void stragegy() {
        System.out.println("乘公交车");
    }
}

