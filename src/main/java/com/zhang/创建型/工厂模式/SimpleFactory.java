package com.zhang.创建型.工厂模式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface TV{
    public void play();
}

class HaierTV implements TV{

    @Override
    public void play() {
        System.out.println("海尔电视机播放中....");
    }
}

class HisenseTV implements TV{

    @Override
    public void play() {
        System.out.println("海信电视机播放中....");
    }
}

public class SimpleFactory {
    static TV tv=null;
    static String brand;

    public static void main(String[] args) {
        do {
            brand=getBrand();
            if(brand.equalsIgnoreCase("Haier")){
                System.out.println("电视机工厂生产海尔电视机");
                tv=new HaierTV();//对象创建
            }else if(brand.equalsIgnoreCase("Hisense")){
                System.out.println("电视机工厂生产海信电视机");
                tv=new HisenseTV();
            }else{
                System.out.println("暂不能生产该品牌的电视机");
                System.out.println("--------------");
                break;
            }
            tv.play();
            System.out.println("-------------");
        }while(true);
    }

    static String getBrand(){
        String str=null;
        try{
            BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入电视机的品牌");
             str=strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return str;
    }
}
