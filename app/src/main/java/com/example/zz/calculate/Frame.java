package com.example.zz.calculate;

/**
 * Created by zz on 17-5-12.
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
