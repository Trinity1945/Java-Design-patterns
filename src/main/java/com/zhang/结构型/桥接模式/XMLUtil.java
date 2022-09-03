package com.zhang.结构型.桥接模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @Author:liZiYuan Date: 2022/6/15  23:43
 */
public class XMLUtil {
    //该方法用于从XML配置文件中提取具体类名，并返回一个实例对象
    public static Object getBean(String args){
        try{
            //闯将文档对象
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("Java-01-设计模式/src/main/java/com/zhang/结构型/桥接模式/config.xml"));
            NodeList nl=null;
            Node classNode=null;
            String cName=null;
            nl=doc.getElementsByTagName("className");
            if(args.equals("image")){
                //获取第一个包含类名的节点，即扩充抽象类
                classNode= (Node) nl.item(0).getFirstChild();
            }else{
                //获取第二个包含类名的节点，即具体实现类
                classNode=nl.item(1).getFirstChild();
            }
            cName=classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        } catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
