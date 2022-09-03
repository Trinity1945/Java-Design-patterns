package com.zhang.创建型.工厂模式;

abstract class AbstractProductA{//抽线电视机类
    public abstract void play();
}

class ConcreteProductA1 extends AbstractProductA{

    @Override
    public void play() {
        System.out.println("海尔电视机播放中。。。。");
    }
}

class ConcreteProductA2 extends AbstractProductA{

    @Override
    public void play() {
        System.out.println("海信电视机播放中。。。。");
    }
}

class ConcreteProductA3 extends AbstractProductA{

    @Override
    public void play() {
        System.out.println("Sony 电视机播放中。。。。");
    }
}


abstract class AbstractProductB{//抽象空调类
    public abstract void changeTemperature();
}

class ConcreteProductB1 extends AbstractProductB{

    @Override
    public void changeTemperature() {
        System.out.println("海尔空调温度改变中。。。。");
    }
}

class  ConcreteProductB2 extends AbstractProductB{

    @Override
    public void changeTemperature() {
        System.out.println("海信空调温度变化中。。。。");
    }
}

class ConcreteProductB3 extends AbstractProductB{
    @Override
    public void changeTemperature() {
        System.out.println("Sony 空调温度改变中。。。");
    }
}

abstract class AbstractFactorys{//抽象工厂类
    public abstract AbstractProductA createProductA();
    public abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactorys{

    @Override
    public AbstractProductA createProductA() {
        System.out.println("海尔工厂生产海尔电视机");
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        System.out.println("海尔工厂生产海尔空调");
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactorys{

    @Override
    public AbstractProductA createProductA() {
        System.out.println("海信工厂生产海信电视机");
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        System.out.println("海信工厂生产海信空调");
        return new ConcreteProductB2();
    }
}

class ConcreteFactory3 extends AbstractFactorys{

    @Override
    public AbstractProductA createProductA() {
        System.out.println("海信工厂生产海信电视机");
        return new ConcreteProductA3();
    }

    @Override
    public AbstractProductB createProductB() {
        System.out.println("海信工厂生产海信空调");
        return new ConcreteProductB3();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        AbstractFactorys factory=new ConcreteFactory1();
        AbstractProductA productA=factory.createProductA();
        productA.play();
        AbstractProductB productB = factory.createProductB();
        productB.changeTemperature();
    }

}
