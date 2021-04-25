package com.haha.pt.test.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty("学生编号")//设置excle表头名称
    private Integer sno;

    @ExcelProperty("学生姓名")//设置excle表头名称
    private String sname;
}
