package com.zhang.结构型.装饰模式;

/**
 * @Author:liZiYuan Date: 2022/6/17  23:08
 */

abstract class Component{
    //抽象构建，也可以设计为接口
    protected abstract String operation();//抽象方法
}

class ConcreteComponent extends Component{
    //具体构建（被装饰类）
    @Override
    protected String operation() {
        return "我学习过的编程语言有：C 语言";
    }
}

abstract class Decorator extends Component{
    private Component component;//维护一个抽象构建（父类）对象
    public Decorator(Component component){//聚合（构造器注入）
        this.component=component;
    }

    public Component getComponent(){
        return component;
    }
    //抽象类Decorator作为抽象类Component的子类，不必重写父类的抽象方法，而是延迟到具体的类中
}

class ConcreteDecoratorA extends Decorator{//具体装饰类

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    protected String operation() {
        return getComponent().operation()+",C++";//累加
    }
}

class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    protected String operation() {
        return getComponent().operation()+"，Java";
    }
}

public class Client {
    public static void main(String[] args) {
        Component concreteComponent=new ConcreteComponent();//被转世对象，无参
        System.out.println("大一，"+concreteComponent.operation());
        System.out.println("=========================");
        Decorator concreteDecoratorA=new ConcreteDecoratorA(concreteComponent);
        System.out.println("大二，"+concreteDecoratorA.operation());
        System.out.println("=========================");
        Decorator concreteDecoratorB=new ConcreteDecoratorB(concreteDecoratorA);
        System.out.println("大三，"+concreteDecoratorB.operation());
        System.out.println("=========================");
    }
}
