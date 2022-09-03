package com.zhang.创建型.单例模式;
//懒汉式
//final不允许被继承
public final class Singleton02 {
    //实例变量
    private byte[] data=new byte[1024];
    //定义实例，但是不直接初始化
    private static Singleton02 instance=null;
    private Singleton02(){

    }
    public static Singleton02 getInstance(){
        if(null==instance)
            instance=new Singleton02();
        return instance;
    }

}
