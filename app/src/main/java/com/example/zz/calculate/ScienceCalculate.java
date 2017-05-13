package com.example.zz.calculate;


import android.view.View;

/**
 * Created by zz on cossqrt(-!-costan.
 */

public class ScienceCalculate {
    private MyButton button_sin;
    private MyButton button_cos;
    private MyButton button_tan;
    private MyButton button_log;
    private MyButton button_ln;
    private MyButton button_fact;
    private MyButton button_sq;
    private MyButton button_sqr;
    private MyButton button_percent;
    private MyButton button_PI;
    private MyButton button_e;
    private MyButton button_ans;
    private MyButton button_bracket_left;
    private MyButton button_bracket_right;
    private MyButton button_shift;
    private MyButton button_binary;
    private MyButton button_octal;
    private MyButton button_decimal;
    private MyButton button_hexadecimal;
    private MyButton button_history;

    public ScienceCalculate(View view, View.OnClickListener clickListener, View.OnLongClickListener longClickListener) {
        button_sin = new MyButton(view, R.id.button_sin, MyButton.FUN_TYPE, "sin(", "sin(");
        button_sin.getButton().setOnClickListener(clickListener);
        button_sin.getButton().setOnLongClickListener(longClickListener);

        button_cos = new MyButton(view, R.id.button_cos, MyButton.FUN_TYPE, "cos(", "cos(");
        button_cos.getButton().setOnClickListener(clickListener);
        button_cos.getButton().setOnLongClickListener(longClickListener);

        button_tan = new MyButton(view, R.id.button_tan, MyButton.FUN_TYPE, "tan(", "tan(");
        button_tan.getButton().setOnClickListener(clickListener);
        button_tan.getButton().setOnLongClickListener(longClickListener);

        button_log = new MyButton(view, R.id.button_log, MyButton.FUN_TYPE, "log(", "log(");
        button_log.getButton().setOnClickListener(clickListener);
        button_log.getButton().setOnLongClickListener(longClickListener);

        button_ln = new MyButton(view, R.id.button_ln, MyButton.FUN_TYPE, "ln(", "ln(");
        button_ln.getButton().setOnClickListener(clickListener);
        button_ln.getButton().setOnLongClickListener(longClickListener);

        button_fact = new MyButton(view, R.id.button_fact, MyButton.LEFT_OPERATOR, "!", "!");
        button_fact.getButton().setOnClickListener(clickListener);
        button_fact.getButton().setOnLongClickListener(longClickListener);

        button_sq = new MyButton(view, R.id.button_sq, MyButton.BIN_OPERATOR, "^", "^");
        button_sq.getButton().setOnClickListener(clickListener);
        button_sq.getButton().setOnLongClickListener(longClickListener);

        button_sqr = new MyButton(view, R.id.button_sqr, MyButton.FUN_TYPE, "√(", "sqrt(");
        button_sqr.getButton().setOnClickListener(clickListener);
        button_sqr.getButton().setOnLongClickListener(longClickListener);

        button_percent = new MyButton(view, R.id.button_percent, MyButton.BIN_OPERATOR, "%", "%");
        button_percent.getButton().setOnClickListener(clickListener);
        button_percent.getButton().setOnLongClickListener(longClickListener);

        button_PI = new MyButton(view, R.id.button_PI, MyButton.CONSTANT_TYPE, "π", Double.toString(Math.PI));
        button_PI.getButton().setOnClickListener(clickListener);
        button_PI.getButton().setOnLongClickListener(longClickListener);

        button_e = new MyButton(view, R.id.button_e, MyButton.CONSTANT_TYPE, "e", Double.toString(Math.E));
        button_e.getButton().setOnClickListener(clickListener);
        button_e.getButton().setOnLongClickListener(longClickListener);

        button_ans = new MyButton(view, R.id.button_ans, MyButton.CONSTANT_TYPE, "Ans", "ans");
        button_ans.getButton().setOnClickListener(clickListener);
        button_ans.getButton().setOnLongClickListener(longClickListener);

        button_binary = new MyButton(view, R.id.button_binary, MyButton.ACTION_OPERATOR, "bin:", "bin");
        button_binary.getButton().setOnClickListener(clickListener);
        button_binary.getButton().setOnLongClickListener(longClickListener);

        button_octal = new MyButton(view, R.id.button_octal, MyButton.ACTION_OPERATOR, "oct:", "oct");
        button_octal.getButton().setOnClickListener(clickListener);
        button_octal.getButton().setOnLongClickListener(longClickListener);

        button_decimal = new MyButton(view, R.id.button_decimal, MyButton.ACTION_OPERATOR, "dec:", "dec");
        button_decimal.getButton().setOnClickListener(clickListener);
        button_decimal.getButton().setOnLongClickListener(longClickListener);

        button_hexadecimal = new MyButton(view, R.id.button_hexadecimal, MyButton.ACTION_OPERATOR, "hex:", "hex");
        button_hexadecimal.getButton().setOnClickListener(clickListener);
        button_hexadecimal.getButton().setOnLongClickListener(longClickListener);

        button_history = new MyButton(view, R.id.button_history, MyButton.ACTION_OPERATOR, "history", "history");
        button_history.getButton().setOnClickListener(clickListener);
        button_history.getButton().setOnLongClickListener(longClickListener);

        button_bracket_left = new MyButton(view, R.id.button_bracket_left, MyButton.FUN_TYPE, "(", "(");
        button_bracket_left.getButton().setOnClickListener(clickListener);
        button_bracket_left.getButton().setOnLongClickListener(longClickListener);

        button_bracket_right = new MyButton(view, R.id.button_bracket_right, MyButton.SYMBOL, ")", ")");
        button_bracket_right.getButton().setOnClickListener(clickListener);
        button_bracket_right.getButton().setOnLongClickListener(longClickListener);

        button_shift = new MyButton(view, R.id.button_shift, MyButton.FUN_TYPE, "arc", "a");
        button_shift.getButton().setOnClickListener(clickListener);
        button_shift.getButton().setOnLongClickListener(longClickListener);
    }

    /***
     *
     */
    public MyButton getButton_sin() {
        return button_sin;
    }

    public void setButton_sin(MyButton button_sin) {
        this.button_sin = button_sin;
    }

    public MyButton getButton_cos() {
        return button_cos;
    }

    public void setButton_cos(MyButton button_cos) {
        this.button_cos = button_cos;
    }

    public MyButton getButton_tan() {
        return button_tan;
    }

    public void setButton_tan(MyButton button_tan) {
        this.button_tan = button_tan;
    }

    public MyButton getButton_log() {
        return button_log;
    }

    public void setButton_log(MyButton button_log) {
        this.button_log = button_log;
    }

    public MyButton getButton_ln() {
        return button_ln;
    }

    public void setButton_ln(MyButton button_ln) {
        this.button_ln = button_ln;
    }

    public MyButton getButton_fact() {
        return button_fact;
    }

    public void setButton_fact(MyButton button_fact) {
        this.button_fact = button_fact;
    }

    public MyButton getButton_sq() {
        return button_sq;
    }

    public void setButton_sq(MyButton button_sq) {
        this.button_sq = button_sq;
    }

    public MyButton getButton_sqr() {
        return button_sqr;
    }

    public void setButton_sqr(MyButton button_sqr) {
        this.button_sqr = button_sqr;
    }

    public MyButton getButton_percent() {
        return button_percent;
    }

    public void setButton_percent(MyButton button_percent) {
        this.button_percent = button_percent;
    }

    public MyButton getButton_PI() {
        return button_PI;
    }

    public void setButton_PI(MyButton button_PI) {
        this.button_PI = button_PI;
    }

    public MyButton getButton_e() {
        return button_e;
    }

    public void setButton_e(MyButton button_e) {
        this.button_e = button_e;
    }

    public MyButton getButton_ans() {
        return button_ans;
    }

    public void setButton_ans(MyButton button_ans) {
        this.button_ans = button_ans;
    }

    public MyButton getButton_bracket_left() {
        return button_bracket_left;
    }

    public void setButton_bracket_left(MyButton button_bracket_left) {
        this.button_bracket_left = button_bracket_left;
    }

    public MyButton getButton_bracket_right() {
        return button_bracket_right;
    }

    public void setButton_bracket_right(MyButton button_bracket_right) {
        this.button_bracket_right = button_bracket_right;
    }

    public MyButton getButton_shift() {
        return button_shift;
    }

    public void setButton_shift(MyButton button_shift) {
        this.button_shift = button_shift;
    }

    public MyButton getButton_binary() {
        return button_binary;
    }

    public void setButton_binary(MyButton button_binary) {
        this.button_binary = button_binary;
    }

    public MyButton getButton_octal() {
        return button_octal;
    }

    public void setButton_octal(MyButton button_octal) {
        this.button_octal = button_octal;
    }

    public MyButton getButton_decimal() {
        return button_decimal;
    }

    public void setButton_decimal(MyButton button_decimal) {
        this.button_decimal = button_decimal;
    }

    public MyButton getButton_hexadecimal() {
        return button_hexadecimal;
    }

    public void setButton_hexadecimal(MyButton button_hexadecimal) {
        this.button_hexadecimal = button_hexadecimal;
    }

    public MyButton getButton_history() {
        return button_history;
    }

    public void setButton_history(MyButton button_history) {
        this.button_history = button_history;
    }
}
