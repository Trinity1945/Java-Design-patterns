package com.zhang.创建型.原型模式;

import java.util.Hashtable;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/14  9:28
 */

interface OfficialDocument extends Cloneable{
    public OfficialDocument clone();
    public void display();
}

class FAR implements OfficialDocument{

    @Override
    public OfficialDocument clone() {
        OfficialDocument far=null;
        try{
            far=(OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return far;
    }

    @Override
    public void display() {
        System.out.println("<<可行性分析报告>>");
    }
}

class SRS implements OfficialDocument{

    @Override
    public OfficialDocument clone() {
        OfficialDocument srs=null;
        try{
            srs= (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return srs;
    }

    @Override
    public void display() {
        System.out.println("《软件需求规格说明书》");
    }
}


class PrototypeManager{
    //定义一个HashTable，用于存储原型对象
    private Hashtable<String,OfficialDocument> ht=new Hashtable();
    private static PrototypeManager pm=new PrototypeManager();
    //为hashtable增加公文对象
    private PrototypeManager(){
        ht.put("far",new FAR());
        ht.put("srs",new SRS());
    }
    //增加新的公文对象
    public void addOfficialDocument(String key,OfficialDocument doc){
        ht.put(key, doc);
    }
    //通过浅拷贝获取新的对象
    public OfficialDocument getOfficialDocument(String key){
       return ((OfficialDocument)ht.get(key)).clone();
    }

    public static PrototypeManager getPrototypeManager(){
        return pm;
    }
}

public class Client {

    public static void main(String[] args) {
        //获取原型管理器
        PrototypeManager pm=PrototypeManager.getPrototypeManager();
        OfficialDocument doc1,doc2,doc3,doc4;

        doc1=pm.getOfficialDocument("far");
        doc1.display();
        doc2=pm.getOfficialDocument("far");
        doc2.display();

        System.out.println(doc1==doc2);

        doc3=pm.getOfficialDocument("srs");
        doc3.display();
        doc4=pm.getOfficialDocument("srs");
        doc4.display();
        System.out.println(doc3==doc4);
    }



}
