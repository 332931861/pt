package com.haha.pt.test.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoData> {

    //一行一行的读取excel的数据 , 不包括表头 , 也就是不读取第一行
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("sn0" + demoData.getSno()+"sname" + demoData.getSname());
    }

    //读取表头的内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头:" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
