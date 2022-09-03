package com.zhang.行为型.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/18  20:52
 */

abstract class Iterator {//抽象迭代器

    protected abstract boolean hasNext();

    protected abstract Object getNextItem();//Object通用类型

    protected abstract void next();
}

abstract class Aggregate {//抽象聚合类

    //抽象聚合类必须定义的方法
    public abstract Iterator createIterator();
}

class ConcreteIterator extends Iterator {//具体迭代器类

    private List<String> list;
    private int cursor;//定义一个游标（正向遍历）

    @Override
    protected boolean hasNext() {
        return (cursor < list.size());
    }

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {//ConcreteIterator关联ConcreteAggregate
        list = concreteAggregate.getList();
        cursor = 0;
    }

    @Override
    protected Object getNextItem() {
        return list.get(cursor);
    }

    @Override
    protected void next() {
        if (cursor < list.size()) {
            cursor++;
        }
    }
}

class ConcreteAggregate extends Aggregate{

    private List<String> list=new ArrayList<>();



    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);//根据聚合对象创建迭代器对象
    }//具体聚合类

    public List<String> getList() {
        return list;
    }
}

public class Client {
    public static void main(String[] args) {
        ConcreteAggregate aggregate=new ConcreteAggregate();//创建聚合对象，Client关联Aggregate
        aggregate.getList().add("计算机科学与技术\n");
        aggregate.getList().add("软件工程\n");
        aggregate.getList().add("网络安全\n");
        final Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getNextItem());
            iterator.next();
        }
    }
}
