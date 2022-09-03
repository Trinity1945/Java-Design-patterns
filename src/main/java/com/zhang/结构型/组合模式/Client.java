package com.zhang.结构型.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:liZiYuan Date: 2022/6/5  23:08
 */

abstract class Componet{//抽象构建
    protected String name;//组件名称

    public Componet(String name){
        this.name=name;
    }

    protected abstract void operation();//业务方法
    protected abstract void add(Componet c);//增加成员
    protected abstract void remove(Componet c);//删除成员
    protected abstract List<Componet> getChild();//获取成员
}

class Leaf extends Componet{

    public Leaf(String name){
        super(name);//调用父类构造方法
    }

    @Override
    protected void operation() {//打印组件名称
        System.out.println(name);
    }

    @Override
    protected void add(Componet c) {
        throw new UnsupportedOperationException();//可以是空实现
    }

    @Override
    protected void remove(Componet c) {
        throw new UnsupportedOperationException();//可以是空实现
    }

    @Override
    protected List<Componet> getChild() {
        return null;
    }
}

class Composite extends Componet{

    private List<Componet> components=new ArrayList<>();//Composite组合Componet

    public Composite(String name) {
        super(name);
    }

    @Override
    protected void operation() {
        System.out.println("-----"+name+"------");
        for (Componet c:
             components) {
            c.operation();
        }
    }

    @Override
    protected void add(Componet c) {
    components.add(c);
    }

    @Override
    protected void remove(Componet c) {
    components.remove(c);
    }

    @Override
    protected List<Componet> getChild() {
        return components;
    }
}


public class Client {
    public static void main(String[] args) {
        Componet university,computerCollege,infoEnginerrCollege;//关联Componet
        //创建根容器组件
        university=new Composite("清华大学");
        //创建2个子容器组件
        computerCollege=new Composite("计算机学院");
        university.add(computerCollege);
        infoEnginerrCollege=new Composite("信息工程学院");
        university.add(infoEnginerrCollege);
        //创建叶子构件并添加到相应的容器组件中
        computerCollege.add(new Leaf("软件工程系"));
        computerCollege.add(new Leaf("网络工程系"));
        computerCollege.add(new Leaf("计算机科学与技术系"));
        infoEnginerrCollege.add(new Leaf("通信工程系"));
        infoEnginerrCollege.add(new Leaf("电子工程系"));

        university.operation();//调用递归方法，遍历根容器组件
//        computerCollege.operation();//调用递归方法，遍历特定子容器组件
//        new Leaf("计算机科学与技术系").operation();//调用递归方法，遍历叶子构件
    }

}
