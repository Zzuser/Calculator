package com.example.zz.calculate;

import java.io.Serializable;

/**
 * Created by zz on 17-5-13.
 * History类是定义单个历史记录条目的类，而单个历史记录条目包含计算公式，和计算结果
 */

public class History implements Serializable {
    private String function;
    private String result;
    public History(String function,String result){
        this.function=function;
        this.result=result;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
