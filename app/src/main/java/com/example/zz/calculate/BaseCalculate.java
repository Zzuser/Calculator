package com.example.zz.calculate;

import android.view.View;

/**
 * Created by zz on 17-5-12.
 * BaseCalculate类来初始化所有基础计算所需的按键
 */

public class BaseCalculate {
    private MyButton button0;
    private MyButton button1;
    private MyButton button2;
    private MyButton button3;
    private MyButton button4;
    private MyButton button5;
    private MyButton button6;
    private MyButton button7;
    private MyButton button8;
    private MyButton button9;
    private MyButton button_add;
    private MyButton button_sub;
    private MyButton button_mul;
    private MyButton button_div;
    private MyButton button_dot;
    private MyButton button_clear;
    private MyButton button_equal;

    public BaseCalculate() {
        //default
    }

    public BaseCalculate(View view, View.OnClickListener clickListener, View.OnLongClickListener longClickListener) {
        button0 = new MyButton(view, R.id.button_0, MyButton.NUMBER_TYPE, "0", "0");
        button0.getButton().setOnClickListener(clickListener);
        button0.getButton().setOnLongClickListener(longClickListener);

        button1 = new MyButton(view, R.id.button_1, MyButton.NUMBER_TYPE, "1", "1");
        button1.getButton().setOnClickListener(clickListener);
        button1.getButton().setOnLongClickListener(longClickListener);

        button2 = new MyButton(view, R.id.button_2, MyButton.NUMBER_TYPE, "2", "2");
        button2.getButton().setOnClickListener(clickListener);
        button2.getButton().setOnLongClickListener(longClickListener);

        button3 = new MyButton(view, R.id.button_3, MyButton.NUMBER_TYPE, "3", "3");
        button3.getButton().setOnClickListener(clickListener);
        button3.getButton().setOnLongClickListener(longClickListener);

        button4 = new MyButton(view, R.id.button_4, MyButton.NUMBER_TYPE, "4", "4");
        button4.getButton().setOnClickListener(clickListener);
        button4.getButton().setOnLongClickListener(longClickListener);

        button5 = new MyButton(view, R.id.button_5, MyButton.NUMBER_TYPE, "5", "5");
        button5.getButton().setOnClickListener(clickListener);
        button5.getButton().setOnLongClickListener(longClickListener);

        button6 = new MyButton(view, R.id.button_6, MyButton.NUMBER_TYPE, "6", "6");
        button6.getButton().setOnClickListener(clickListener);
        button6.getButton().setOnLongClickListener(longClickListener);

        button7 = new MyButton(view, R.id.button_7, MyButton.NUMBER_TYPE, "7", "7");
        button7.getButton().setOnClickListener(clickListener);
        button7.getButton().setOnLongClickListener(longClickListener);

        button8 = new MyButton(view, R.id.button_8, MyButton.NUMBER_TYPE, "8", "8");
        button8.getButton().setOnClickListener(clickListener);
        button8.getButton().setOnLongClickListener(longClickListener);

        button9 = new MyButton(view, R.id.button_9, MyButton.NUMBER_TYPE, "9", "9");
        button9.getButton().setOnClickListener(clickListener);
        button9.getButton().setOnLongClickListener(longClickListener);

        button_add = new MyButton(view, R.id.button_add, MyButton.BIN_OPERATOR, "+", "+");
        button_add.getButton().setOnClickListener(clickListener);
        button_add.getButton().setOnLongClickListener(longClickListener);

        button_sub = new MyButton(view, R.id.button_sub, MyButton.BIN_OPERATOR, "-", "-");
        button_sub.getButton().setOnClickListener(clickListener);
        button_sub.getButton().setOnLongClickListener(longClickListener);

        button_mul = new MyButton(view, R.id.button_mul, MyButton.BIN_OPERATOR, "×", "*");
        button_mul.getButton().setOnClickListener(clickListener);
        button_mul.getButton().setOnLongClickListener(longClickListener);

        button_div = new MyButton(view, R.id.button_div, MyButton.BIN_OPERATOR, "÷", "/");
        button_div.getButton().setOnClickListener(clickListener);
        button_div.getButton().setOnLongClickListener(longClickListener);

        button_dot = new MyButton(view, R.id.button_dot, MyButton.BIN_OPERATOR, ".", ".");
        button_dot.getButton().setOnClickListener(clickListener);
        button_dot.getButton().setOnLongClickListener(longClickListener);

        button_clear = new MyButton(view, R.id.button_clear, MyButton.REMOVE, "", "");
        button_clear.getButton().setOnClickListener(clickListener);
        button_clear.getButton().setOnLongClickListener(longClickListener);

        button_equal = new MyButton(view, R.id.button_equal, MyButton.ACTION_OPERATOR, "=", "=");
        button_equal.getButton().setOnClickListener(clickListener);
        button_equal.getButton().setOnLongClickListener(longClickListener);

    }


    /**
     * @return
     */


    public MyButton getButton0() {
        return button0;
    }

    public void setButton0(MyButton button0) {
        this.button0 = button0;
    }

    public MyButton getButton1() {
        return button1;
    }

    public void setButton1(MyButton button1) {
        this.button1 = button1;
    }

    public MyButton getButton2() {
        return button2;
    }

    public void setButton2(MyButton button2) {
        this.button2 = button2;
    }

    public MyButton getButton3() {
        return button3;
    }

    public void setButton3(MyButton button3) {
        this.button3 = button3;
    }

    public MyButton getButton4() {
        return button4;
    }

    public void setButton4(MyButton button4) {
        this.button4 = button4;
    }

    public MyButton getButton5() {
        return button5;
    }

    public void setButton5(MyButton button5) {
        this.button5 = button5;
    }

    public MyButton getButton6() {
        return button6;
    }

    public void setButton6(MyButton button6) {
        this.button6 = button6;
    }

    public MyButton getButton7() {
        return button7;
    }

    public void setButton7(MyButton button7) {
        this.button7 = button7;
    }

    public MyButton getButton8() {
        return button8;
    }

    public void setButton8(MyButton button8) {
        this.button8 = button8;
    }

    public MyButton getButton9() {
        return button9;
    }

    public void setButton9(MyButton button9) {
        this.button9 = button9;
    }

    public MyButton getButton_add() {
        return button_add;
    }

    public void setButton_add(MyButton button_add) {
        this.button_add = button_add;
    }

    public MyButton getButton_sub() {
        return button_sub;
    }

    public void setButton_sub(MyButton button_sub) {
        this.button_sub = button_sub;
    }

    public MyButton getButton_mul() {
        return button_mul;
    }

    public void setButton_mul(MyButton button_mul) {
        this.button_mul = button_mul;
    }

    public MyButton getButton_div() {
        return button_div;
    }

    public void setButton_div(MyButton button_div) {
        this.button_div = button_div;
    }

    public MyButton getButton_equal() {
        return button_equal;
    }

    public void setButton_equal(MyButton button_equal) {
        this.button_equal = button_equal;
    }

    public MyButton getButton_dot() {
        return button_dot;
    }

    public void setButton_dot(MyButton button_dot) {
        this.button_dot = button_dot;
    }

    public MyButton getButton_clear() {
        return button_clear;
    }

    public void setButton_clear(MyButton button_clear) {
        this.button_clear = button_clear;
    }
}
