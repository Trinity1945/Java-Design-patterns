package com.zhang.结构型.外观模式;

class SubSystemOne{
    public void method1(){//子系统角色，想象成CPU
        System.out.println("CPU 运行成功");
    }
}

class SubSystemTwo{
    public void method2(){//子系统角色，想象成内存
        System.out.println("内存自检成功");
    }
}

class SubSystemThree{
    public void method3(){//子系统角色，想象成硬盘
        System.out.println("硬件读取成功");
    }
}

class SubSystemFour{
    public void method4(){//子系统角色，想象成操作系统
        System.out.println("Windows 载入成功");
    }
}

class Facade{//外观类角色：聚合其他子系统，想象成主机箱
    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;
    private SubSystemFour subSystemFour;

    public Facade(){//构造方法
        subSystemOne=new SubSystemOne();
        subSystemTwo=new SubSystemTwo();
        subSystemThree=new SubSystemThree();
        subSystemFour=new SubSystemFour();
    }

    public void on(){//想象成电源开关
        try{
            subSystemOne.method1();
            subSystemTwo.method2();
            subSystemThree.method3();
            subSystemFour.method4();
        }catch (Exception e){
            System.out.println("启动失败");
        }
    }
}



public class Client {//客户端
    public static void main(String[] args) {
        Facade facade=new Facade();//client关联facade
        facade.on();
        System.out.println("电脑启动成功");
    }
}
