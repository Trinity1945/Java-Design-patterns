package com.zhang.结构型.适配器模式;

/**
 * @Author:liZiYuan Date: 2022/6/4  23:31
 */

class Adaptee{
    public void specifficRquest(){//被适配者
        System.out.println("被适配对象具有特殊功能");
    }
}

interface Target{
    public void request();
}

class Adapter extends Adaptee implements Target{

    //实现接口方法
    @Override
    public void request() {
        //调用基类方法
        super.specifficRquest();//super表示父类对象
    }
}

public class ClassAdapterClient {
    private static Target adapter;//CLient关联Target

    public static void main(String[] args) {
        adapter=new Adapter();
        adapter.request();
    }
}
