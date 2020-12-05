package com.haha.pt.entity;

public enum Color {

    RED("红色", 1,"这是红色"), GREEN("绿色", 2,"这是绿色"),
    BLANK("白色", 3,"这是白色"), YELLO("黄色", 4,"这是黄色");


    private String name ;
    private int index ;
    private String desc;

    private Color( String name , int index ,String desc){
        this.name = name ;
        this.index = index ;
        this.desc = desc ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static void main(String[] args) {
        System.out.println(Color.RED.getDesc());
    }

}

