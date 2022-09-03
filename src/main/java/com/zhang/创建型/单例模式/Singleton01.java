package com.zhang.创建型.单例模式;

//饿汉式
//final不允许被继承
public final class Singleton01 {

    //实例变量
    private final byte[] data=new byte[1024];
    //在定义实例对象的时候直接初始化
    private static final Singleton01 instance=new Singleton01();
    private Singleton01(){

    }

    public static Singleton01 getInstance(){
        return instance;
    }

}
