package com.zhang.结构型.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/19  20:48
 */

interface Flyweight{//抽象享元
    void operation(String extrinsicState);//操作（设置）外部状态方法
}

class ConcreteFlyweight implements Flyweight{

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    private String intrinsicState;//成员变量，表示内部状态
    @Override
    public void operation(String extrinsicState) {
        System.out.println(extrinsicState+"正在"+intrinsicState+
                ",具体享元对象的hashcode为"+this.hashCode());//内外部状态
    }//具体享元
}

class UnSharedConcreteFlyweight implements Flyweight{

    private String intrinsicState;//内部状态
    private String extrinsicState;//外部状态

    public UnSharedConcreteFlyweight(String extrinsicState) {
        this.extrinsicState = extrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        intrinsicState="系统管理";//intrinsicState表示内部状态
        this.extrinsicState="超级会员"+extrinsicState;//extrinsicState表示外部状态
        System.out.println(this.extrinsicState+"正在进行"+intrinsicState+"," +
                "非共享具体享元对象的hashcode为"+this.hashCode());
    }//非共享具体享元

}

class FlyweightFactory{//享元工厂，它的主要职责是创建对象
    private Map<String,Flyweight> map=new HashMap<>();//享元池，聚合Flyweight
    public Flyweight getFlyweight(String key){
        Flyweight flyweight;
        if(map.get(key)!=null){
            return map.get(key);
        }else{
            if(key=="UnShared"){
                flyweight=new UnSharedConcreteFlyweight(key);//非共享的享元对象
            }else{
                flyweight=new ConcreteFlyweight(key);//共享的享元对象
            }
            map.put(key,flyweight);//保存具体享元对象

        }
        return flyweight;
    }
}

public class Client {
    public static void main(String[] args) {
        //下棋种类为内部状态，下棋者为外部状态
        final FlyweightFactory flyweightFactory = new FlyweightFactory();
        final Flyweight flyweight = flyweightFactory.getFlyweight("下围棋");
        flyweight.operation("张三");
        flyweight.operation("李四");

    }
}
