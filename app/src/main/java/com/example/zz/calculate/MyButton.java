package com.example.zz.calculate;

import android.view.View;
import android.widget.Button;

/**
 * Created by zz on 17-5-12.
 * MyButton类定义了键盘中单个按键，
 * Type属性来确定按键的功能属性
 * showData来装入按键向显示文本框传入的数据
 * calculateData来装入按键向计算模块传入的数据
 * button来实现按键的基本功能
 */

public class MyButton {
    public static final int NUMBER_TYPE = 1;
    public static final int CONSTANT_TYPE = 2;
    public static final int FUN_TYPE = 3;
    public static final int BIN_OPERATOR = 4;
    public static final int LEFT_OPERATOR = 5;
    public static final int SYMBOL = 6;
    public static final int ACTION_OPERATOR = 7;
    public static final int REMOVE = 8;
    public static final int DOT = 9;


    private int buttonType;
    private String showData;
    private String calculateData;
    private Button button;

    public MyButton(View view, int id, int buttonType, String showData, String calculateData) {
        button = (Button) view.findViewById(id);
        this.buttonType = buttonType;
        this.showData = showData;
        this.calculateData = calculateData;
    }


    public int getButtonType() {
        return buttonType;
    }

    public void setButtonType(int buttonType) {
        this.buttonType = buttonType;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public String getCalculateData() {
        return calculateData;
    }

    public void setCalculateData(String calculateData) {
        this.calculateData = calculateData;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
