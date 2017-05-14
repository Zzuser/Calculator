package com.example.zz.calculate;

/**
 * Created by zz on 17-5-12.
 * Frame类是容纳不同键盘布局的框架，是定义RecyclerView中条目的基础类
 * 每一个Frame装入所有的键盘种类，通过定义它们的TYPE来使需要的键盘类型显示
 */

public class Frame {
    public static final int TYPE_BASE=0;
    public static final int TYPE_SCIENCE=1;
    private int type;
    public Frame(int type){
        this.type=type;
    }

    public int getType() {
        return type;
    }
}
