package com.zhang.结构型.适配器模式;

/**
 * @Author:liZiYuan Date: 2022/6/4  23:37
 */

class Adapteee{
    public void specifficRquest(){//被适配者
        System.out.println("使用适配者功能");
    }
}

interface Target1{
    public void request();
}

class Adapter1 implements Target1{

    public Adapter1(Adapteee adapter){
        this.adapter=adapter;
    }

    private Adapteee adapter;//Adapter1聚合Adapteee
    @Override
    public void request() {
        adapter.specifficRquest();
    }
}

public class ObjectAdapterClient {
    private static Target1 adapter;

    public static void main(String[] args) {
        adapter=new Adapter1(new Adapteee());
        adapter.request();
    }
}
