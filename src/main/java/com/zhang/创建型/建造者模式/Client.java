package com.zhang.创建型.建造者模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/19  21:50
 */

class Product{
    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Product{" +
                "food='" + food + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}

abstract class Builder{//抽象建造者
    public abstract void buildFood(String food);//产品部件
    public abstract void buildDrink(String drink);//产品部件
    public abstract Product buildProduct();//完整产品
}

class ConcreteBuilder extends Builder{//具体建造者

    String food;
    String drink;
    @Override
    public void buildFood(String food) {
        this.food=food;
    }

    @Override
    public void buildDrink(String drink) {
        this.drink=drink;
    }

    @Override
    public Product buildProduct() {
        final Product product = new Product();
        product.setDrink(drink);
        product.setFood(food);
        return product;
    }
}

class Director{//由指挥者类聚合Builder对象，指挥建造过程
    private Builder builder;//聚合

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct(String food,String drink){//装配方法
        builder.buildDrink(food);
        builder.buildDrink(drink);
        return builder.buildProduct();//返回复杂产品
    }
}

public class Client {

    private static Director director;
    public static void main(String[] args) {
        final ConcreteBuilder concreteBuilder = new ConcreteBuilder();//创建建造者
        director=new Director(concreteBuilder);//创建指挥者
        final Product product = director.construct("炸鸡", "可乐");
        System.out.println(product.toString());
    }
}
