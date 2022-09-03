package com.zhang.创建型.单例模式;
//懒汉式+同步方法
//final不允许被继承
public class Singleton03 {

    //实例变量
    private byte[] data=new byte[1024];
    private static Singleton03 instance=null;
    private Singleton03(){

    }

    public static synchronized Singleton03 getInstance(){
        if(null==instance)
            instance=new Singleton03();
        return instance;
    }
}
