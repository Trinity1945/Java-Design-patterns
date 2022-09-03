package com.zhang.结构型.桥接模式;

/**
 * @Author:liZiYuan Date: 2022/6/15  23:10
 */

//像素举证类，辅助类，各种格式的文件最终都被转化为像素矩阵，不同的操作系统提供不同的方式
//显示像素矩阵
class Matrix{
    //此处代码省略
}

//抽象图像类：抽象类
abstract class Image{
    protected ImageImpl impl;
    public void setImageImp(ImageImpl impl){
        this.impl=impl;
    }

    public abstract void parseFile(String fileName);
}

//抽象操作系统实现类：实现类接口
interface ImageImpl{
    public void doPaint(Matrix m);
}

//windows操作系统实现类：具体实现类
class WindowsImpl implements ImageImpl{

    @Override
    public void doPaint(Matrix m) {
        //调用windows系统的绘制函数绘制像素图像
        System.out.println("在windows操作系统中显示图像");
    }
}

//linux操作系统实现类：具体实现类
class LinuxImpl implements ImageImpl{

    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Linux操作系统中显示图像");
    }
}

//Unix操作系统实现类：具体实现类
class UnixImpl implements ImageImpl{

    @Override
    public void doPaint(Matrix m) {
        System.out.println("在UNIX操作系统中显示图像");
    }
}

//JPG格式图像：扩充抽象类
class JPGImage extends Image{

    @Override
    public void parseFile(String fileName) {
        //模拟解析JPG文件获得一个像素矩阵对象m
        Matrix m=new Matrix();
        impl.doPaint(m);
        System.out.println(fileName+",格式为JPG");
    }
}

//PNG格式图像：扩充抽象类
class PNGUImage extends Image{

    @Override
    public void parseFile(String fileName) {
        //模拟解析PNG文件并获得一个像素举证对象m
        Matrix m=new Matrix();
        impl.doPaint(m);
        System.out.println(fileName+"，格式为PNG。");
    }
}

//BMP 格式图像：扩充抽象类
class BMPImage extends Image{

    @Override
    public void parseFile(String fileName) {
            //模拟解析BMP文件并获得一个像素矩阵对象m
            Matrix m=new Matrix();
            impl.doPaint(m);
            System.out.println(fileName+",格式为BMP");
    }
}

//GIF格式图像：扩充抽象类
class GIFImage extends Image{

    @Override
    public void parseFile(String fileName) {
        //模拟解析GIF文件并获得一个像素矩阵对象m
        Matrix m=new Matrix();
        impl.doPaint(m);
        System.out.println(fileName+",格式为GIF");
    }
}

public class Client{
    public static void main(String[] args) {
        Image image;
        ImageImpl imp;
        image=(Image) XMLUtil.getBean("image");
        imp=(ImageImpl) XMLUtil.getBean("os");
        assert image != null;
        image.setImageImp(imp);
        image.parseFile("小龙女");
    }
}
