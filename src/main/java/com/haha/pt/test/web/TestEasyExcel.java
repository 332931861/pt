package com.haha.pt.test.web;

import com.alibaba.excel.EasyExcel;
import com.haha.pt.test.entity.DemoData;
import com.haha.pt.test.entity.ExcelListener;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {


    public static void main(String[] args) {
        //实现excle写的操作
        //1 设置写入文件夹的地址和excle文件名称
        String filename = "E:\\write.xlsx";

        //2 调用easyExcel里面的方法实现写操作
        //  write方法中两个参数 , 第一个是文件存储的路径名称 , 第二个是实体类.class
        //EasyExcel.write(filename , DemoData.class).sheet("学生列表").doWrite(getData());


        // 实现exce读操作
        EasyExcel.read(filename , DemoData.class , new ExcelListener()).sheet().doRead();


    }

    //创建一个方法返回list集合
    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            DemoData demoData = new DemoData();
            demoData.setSname("marry" + i);
            demoData.setSno(i);
            list.add(demoData);
        }
        return list;
    }

}
