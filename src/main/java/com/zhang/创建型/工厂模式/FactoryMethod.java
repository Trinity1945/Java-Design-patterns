package com.zhang.创建型.工厂模式;

abstract class Product {
    public abstract void play();
}

class ConcreteProduct1 extends Product {

    @Override
    public void play() {
        System.out.println("海尔电视机播放中。。。。");
    }
}

class ConcreteProduct2 extends Product {

    @Override
    public void play() {
        System.out.println("海信电视机播放中。。。。");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();//电视机工厂生产的电视机
}

class ConcreteCreator1 extends Creator {

    @Override
    public Product factoryMethod() {
        System.out.println("海尔电视机工厂生产的海尔电视机");
        return new ConcreteProduct1();
    }
}

class ConcreteCreator2 extends Creator {

    @Override
    public Product factoryMethod() {
        System.out.println("海信电视机工厂生产的海信电视机");
        return new ConcreteProduct2();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator1();
        Product product = creator.factoryMethod();
        product.play();
        Creator creator1 = new ConcreteCreator2();
        Product d = creator1.factoryMethod();
        d.play();

    }
}
