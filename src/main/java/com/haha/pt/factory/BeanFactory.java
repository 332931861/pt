package com.haha.pt.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    /**
     * 任务一：读取解析xml，通过反射技术实例化对象并且存储待用（map集合）
     * 任务二：对外提供获取实例对象的接口（根据id获取）
     */

    private static Map<String,Object> map = new HashMap<>();  // 存储对象
    static{
        try {
            InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("xml/bean.xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.selectNodes("//bean");
            for (Element element : list) {
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                Class<?> aClass = Class.forName(clazz);
                Object o = aClass.newInstance();
                map.put(id,o);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Object getBean(String id) {
        return map.get(id);
    }

}
