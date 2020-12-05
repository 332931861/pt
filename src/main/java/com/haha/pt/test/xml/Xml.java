package com.haha.pt.test.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 解析xml
 */
public class Xml {


    public static void main(String[] args) {
        try {
            InputStream resourceAsStream = Xml.class.getClassLoader().getResourceAsStream("xml/test.xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            /*List<Element> list = rootElement.selectNodes("//item");
            for (Element element : list) {
                String id = element.attributeValue("id");
                if("ah3".equals(id)){

                }else {
                    String value = element.attributeValue("value");
                    String name = element.attributeValue("name");
                    System.out.println(name+" | "+value);

                }
            }*/
            List<Element> list = rootElement.selectNodes("//bean");
            for (Element element : list) {
                if("12".equals(element.attributeValue("id"))){
                    List<Element> selectNodes = element.selectNodes("item");
                    for (Element selectNode : selectNodes) {
                        String value = selectNode.attributeValue("value");
                        String name = selectNode.attributeValue("name");
                        System.out.println(name+" | "+value);
                    }

                }


            }



        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
