package com.tlias.utils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParseUtils {

    public static <T> List<T> parse(String file, Class<T> targetClass) {
        ArrayList<T> list = new ArrayList<>();
        try {
            // 1.获得一个xml解析器
            SAXReader saxReader = new SAXReader();
            // 2.将xml文件加载到内存中
            Document document = saxReader.read(new File(file));
            // 3.获得根标签
            Element rootElement = document.getRootElement();
            // 4.获得所有的emp标签
            List<Element> elements = rootElement.elements("emp");
            // 5.通过反射创建对象
            for (Element element : elements) {
                String name = element.element("name").getText();
                String age = element.element("age").getText();
                String image = element.element("image").getText();
                String gender = element.element("gender").getText();
                String job = element.element("job").getText();
                // 获取构造函数
                Constructor<T> constructor = targetClass.getDeclaredConstructor(
                    String.class,
                    Integer.class,
                    String.class,
                    String.class,
                    String.class
                );
                T object = constructor.newInstance(name, Integer.parseInt(age), image, gender, job);

                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
