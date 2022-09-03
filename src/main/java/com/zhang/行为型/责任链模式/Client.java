package com.zhang.行为型.责任链模式;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/17  14:45
 */
//采购单请求类
@Data
@AllArgsConstructor
@NoArgsConstructor
class PurchaseRequest{
    private double amount;//采购金额
    private int number;//采购订单号
    private String purpose;//采购目的
}

//审批者类：抽象处理者
abstract class Approver{
    protected Approver successor;//定义后继者对象
    protected String name;//审批者名称

    public Approver(String name) {
        this.name = name;
    }

    //设置后继者
    public void setSuccessor(Approver successor){
        this.successor=successor;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);
}

//主任类：具体处理者
class Director extends Approver{

    public Director(String name) {
        super(name);
    }

    //具体请求处理方法
    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<5000){
            System.out.println("主任"+this.name+"审批采购单"+request.getNumber()+
                    "，金额："+request.getAmount()+"元，采购目的："+request.getPurpose());//处理请求
        }else{
            this.successor.processRequest(request);//转发请求
        }
    }
}

class VicePresident extends Approver{

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<10000){
            System.out.println("副董事长"+this.name+"审批采购单"+request.getNumber()+
                    "，金额："+request.getAmount()+"元，采购目的："+request.getPurpose());//处理请求
        }else{
            this.successor.processRequest(request);//转发请求
        }
    }
}

class President extends Approver{

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<50000){
            System.out.println("董事长"+this.name+"审批采购单"+request.getNumber()+
                    "，金额："+request.getAmount()+"元，采购目的："+request.getPurpose());//处理请求
        }else{
            this.successor.processRequest(request);//转发请求
        }
    }
}

class Congress extends Approver{

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
            System.out.println("召开董事会审批采购单"+this.name+"审批采购单"+request.getNumber()+
                    "，金额："+request.getAmount()+"元，采购目的："+request.getPurpose());//处理请求
    }
}
@Slf4j
public class Client {
    public static void main(String[] args) {
        Approver wjzhang,gyang,jguo,meeting;
        wjzhang=new Director("张无忌");
        gyang=new VicePresident("杨过");
        jguo=new President("郭靖");
        meeting=new Congress("董事会");
        log.error("哈哈哈0");
        log.debug("qu");
        log.info("皇后伺机待发");
        //闯将职责链
        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);

        //创建采购单
        PurchaseRequest pr1=new PurchaseRequest(45000,10001,"购买倚天剑");
        wjzhang.processRequest(pr1);

        PurchaseRequest pr2=new PurchaseRequest(60000,10002,"购买屠龙刀");
        wjzhang.processRequest(pr2);

        PurchaseRequest pr3=new PurchaseRequest(120000,10003,"购买《九阴真经》");
        wjzhang.processRequest(pr3);

        PurchaseRequest pr4=new PurchaseRequest(5000000,10004,"购买桃花岛");
        wjzhang.processRequest(pr4);

    }
}
