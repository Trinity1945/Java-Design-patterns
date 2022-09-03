package com.zhang.创建型.单例模式;
//枚举
//final不允许被继承
public enum SIngleton06 {

    INSTANCE;
    //实例变量
    private byte[] data=new byte[1024];

    SIngleton06(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method(){
        //调用该方法则会主动使用Singleton,INSTANCE将会被实例化
    }

    public static SIngleton06 getInstance(){
        return INSTANCE;
    }

}
