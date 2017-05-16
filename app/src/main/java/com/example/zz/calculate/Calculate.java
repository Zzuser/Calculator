package com.example.zz.calculate;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by zz on 17-5-12.
 * 计算器的计算控制模块
 * calculateData缓存将要被计算的数据
 * bottomShowData缓存将要被显示文本框下方显示的数据
 * topShowData缓存将要被显示文本框上分方显示的数据
 * result缓存计算结果
 */

public class Calculate {
    //连续按键计数器，来计数一个按键被连续按的次数
    public static int count_NUMBER_TYPE = 0;
    public static int count_BIN_OPERATOR = 0;
    public static int count_CONSTANT_TYPE = 0;
    public static int count_LEFT_OPERATOR = 0;
    public static int count_SYMBOL = 0;
    public static int count_FUN_TYPE = 0;
    public static int count_ACTION_OPERATOR = 0;
    public static int count_REMOVE = 0;
    public static int count_DOT = 0;
    //操作历史
    public static int COUNT = 0;    //操作总次数
    public static int[] OPERATION;  //操作按键类型记录

    private StringBuilder calculateData;
    private StringBuilder bottomShowData;
    private StringBuilder topShowData;
    private String result;

    public Calculate() {
        calculateData = new StringBuilder();
        bottomShowData = new StringBuilder();
        topShowData = new StringBuilder();
        result = new String();
        OPERATION = new int[100];
    }

    /***
     *Calculate()负责将计算结果格式化后传入result
     */
    public void Calculate() {
        DecimalFormat decimalFormat = new DecimalFormat("###################.##########");
        try {
            result = decimalFormat.format(eval(calculateData.toString()));
        } catch (Exception e) {
            Log.d("eql", "onCreate:error ");
            result = "Error";
        }
    }

    /***
     *Equal()负责将计算完的公式传入topShowData；
     * 将计算得到的result传入topShowData；
     */
    public void Equal() {
        Log.d("bottomShowData", "Equal: pre" + topShowData);
        Log.d("bottomShowData", "Equal: pre" + bottomShowData);
        Log.d("bottomShowData", "Equal: pre" + result);
        topShowData.setLength(0);
        topShowData.append(bottomShowData);
        Log.d("bottomShowData", "Equal: late" + topShowData);
        bottomShowData.setLength(0);
        bottomShowData.append(result);
        Log.d("bottomShowData", "Equal: late" + bottomShowData);
        calculateData.setLength(0);
        calculateData.append(result);
        Log.d("bottomShowData", "Equal: late" + result);
    }

    /***
     *Clear()清空所有缓存，并将所有按键状态恢复到默认值
     */
    public void Clear() {
        topShowData.setLength(0);
        bottomShowData.setLength(0);
        calculateData.setLength(0);
        count_NUMBER_TYPE = 0;
        count_BIN_OPERATOR = 0;
        count_CONSTANT_TYPE = 0;
        count_LEFT_OPERATOR = 0;
        count_SYMBOL = 0;
        count_FUN_TYPE = 0;
        count_ACTION_OPERATOR = 0;
        count_REMOVE = 0;
        count_DOT = 0;
        OPERATION = new int[100];
        COUNT = 0;

    }

    /***
     *Remove()删除缓存中用户输入的上一个数据
     */
    public void Remove() {
        if (bottomShowData.length() == 0 && calculateData.length() == 0) {
            //NOP
        } else {
            bottomShowData.deleteCharAt(bottomShowData.length() - 1);
            calculateData.deleteCharAt(calculateData.length() - 1);
        }
    }

    /***
     *从按键的触发事件中获取按键的数据传入缓存
     */
    public void appendData(String dataShow, String dataCalculate) {
        this.calculateData.append(dataCalculate);
        Log.d("button0", "showData: " + calculateData);
        this.bottomShowData.append(dataShow);
    }

    /***
     *通过按键的类型和顺序来确定按键是否该被触发，防止无效有害的输入
     */
    public boolean OnOff(int type) {
        boolean onoff = true;
        switch (type) {
            case MyButton.NUMBER_TYPE:
                if (count_ACTION_OPERATOR == 1) {
                    Clear();
                }
                if (count_NUMBER_TYPE > 10)
                    onoff = false;
                if (count_CONSTANT_TYPE > 0)
                    onoff = false;
                if (count_LEFT_OPERATOR > 0)
                    onoff = false;
                if (count_SYMBOL > 0)
                    onoff = false;
                if (onoff != false) {

                    ++count_NUMBER_TYPE;
                    count_BIN_OPERATOR = 0;
                    count_CONSTANT_TYPE = 0;
                    count_LEFT_OPERATOR = 0;
                    count_SYMBOL = 0;
                    count_FUN_TYPE = 0;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.NUMBER_TYPE);
                }
                break;

            case MyButton.BIN_OPERATOR:
                if (count_BIN_OPERATOR > 0)
                    onoff = false;
                if (onoff != false) {
                    count_NUMBER_TYPE = 0;
                    ++count_BIN_OPERATOR;
                    count_CONSTANT_TYPE = 0;
                    count_LEFT_OPERATOR = 0;
                    count_SYMBOL = 0;
                    count_FUN_TYPE = 0;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.BIN_OPERATOR);
                }
                break;

            case MyButton.CONSTANT_TYPE:
                if (count_ACTION_OPERATOR == 1) {
                    Clear();
                }
                if (count_CONSTANT_TYPE > 0)
                    onoff = false;
                if (count_NUMBER_TYPE > 0)
                    onoff = false;
                if (count_LEFT_OPERATOR > 0)
                    onoff = false;
                if (count_SYMBOL > 0)
                    onoff = false;
                if (onoff != false) {
                    count_NUMBER_TYPE = 0;
                    count_BIN_OPERATOR = 0;
                    ++count_CONSTANT_TYPE;
                    count_LEFT_OPERATOR = 0;
                    count_SYMBOL = 0;
                    count_FUN_TYPE = 0;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.CONSTANT_TYPE);
                }
                break;

            case MyButton.LEFT_OPERATOR:
                if (count_LEFT_OPERATOR > 0)
                    onoff = false;
                if (count_FUN_TYPE > 0)
                    onoff = false;
                if (count_BIN_OPERATOR > 0)
                    onoff = false;

                if (onoff != false) {
                    count_NUMBER_TYPE = 0;
                    count_BIN_OPERATOR = 0;
                    count_CONSTANT_TYPE = 0;
                    ++count_LEFT_OPERATOR;
                    count_SYMBOL = 0;
                    count_FUN_TYPE = 0;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.LEFT_OPERATOR);
                }
                break;

            case MyButton.SYMBOL:
                if (count_ACTION_OPERATOR == 1) {
                    Clear();
                }
                if (count_FUN_TYPE > 0)
                    onoff = false;
                if (count_BIN_OPERATOR > 0)
                    onoff = false;
                if (onoff != false) {
                    count_NUMBER_TYPE = 0;
                    count_BIN_OPERATOR = 0;
                    count_CONSTANT_TYPE = 0;
                    count_LEFT_OPERATOR = 0;
                    ++count_SYMBOL;
                    count_FUN_TYPE = 0;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.SYMBOL);
                }
                break;

            case MyButton.FUN_TYPE:
                if (count_ACTION_OPERATOR == 1) {
                    Clear();
                }
                if (count_NUMBER_TYPE > 0)
                    onoff = false;
                if (count_CONSTANT_TYPE > 0)
                    onoff = false;
                if (count_LEFT_OPERATOR > 0)
                    onoff = false;
                if (count_SYMBOL > 0)
                    onoff = false;
                if (onoff != false) {
                    count_NUMBER_TYPE = 0;
                    count_BIN_OPERATOR = 0;
                    count_CONSTANT_TYPE = 0;
                    count_LEFT_OPERATOR = 0;
                    count_SYMBOL = 0;
                    ++count_FUN_TYPE;
                    count_ACTION_OPERATOR = 0;
                    count_REMOVE = 0;
                    count_DOT = 0;
                    ClickHistory(MyButton.FUN_TYPE);
                }
                break;

            case MyButton.ACTION_OPERATOR:
                count_NUMBER_TYPE = 0;
                count_BIN_OPERATOR = 0;
                count_CONSTANT_TYPE = 0;
                count_LEFT_OPERATOR = 0;
                count_SYMBOL = 0;
                count_FUN_TYPE = 0;
                ++count_ACTION_OPERATOR;
                count_REMOVE = 0;
                count_DOT = 0;
                OPERATION = new int[100];
                COUNT = 0;
                break;
            case MyButton.REMOVE:                   //根据操作记录删除本次操作的记录
                try {

                    switch (OPERATION[COUNT - 1]) {
                        case MyButton.NUMBER_TYPE:
                            Log.d("Calculate", "count_NUMBER_TYPE:-- " + count_NUMBER_TYPE);
                            count_NUMBER_TYPE--;
                            Log.d("Calculate", "count_NUMBER_TYPE:-- " + count_NUMBER_TYPE);
                            Pull();
                            break;
                        case MyButton.CONSTANT_TYPE:
                            Log.d("Calculate", "CONSTANT_TYPE:-- ");
                            count_CONSTANT_TYPE--;
                            Pull();
                            break;
                        case MyButton.FUN_TYPE:
                            Log.d("Calculate", "FUN_TYPE:-- ");
                            count_FUN_TYPE--;
                            Pull();
                            break;
                        case MyButton.BIN_OPERATOR:
                            Log.d("Calculate", "BIN_OPERATOR: --");
                            count_BIN_OPERATOR--;
                            Pull();
                            break;
                        case MyButton.LEFT_OPERATOR:
                            Log.d("Calculate", "LEFT_OPERATOR:-- ");
                            count_LEFT_OPERATOR--;
                            Pull();
                            break;
                        case MyButton.SYMBOL:
                            Log.d("Calculate", "SYMBOL:-- ");
                            count_SYMBOL--;
                            Pull();
                            break;
                        case MyButton.DOT:
                            Log.d("Calculate", "DOT:-- ");
                            count_DOT--;
                            Pull();
                            break;
                        default:
                            Log.d("Calculate", "OnOff: " + "noREMOVE");
                            break;
                    }
                } catch (Exception e) {
                    Log.d("Remove", e.toString());
                    break;
                }
                OPERATION[COUNT - 1] = 0;
                COUNT--;
                break;
            case MyButton.DOT:
                break;

            default:
                break;

        }
        Log.d("Calculate", "count_NUMBER_TYPE: " + count_NUMBER_TYPE
                + "\ncount_BIN_OPERATOR:" + count_BIN_OPERATOR
                + "\ncount_CONSTANT_TYPE:" + count_CONSTANT_TYPE
                + "\ncount_LEFT_OPERATOR:" + count_LEFT_OPERATOR
                + "\ncount_SYMBOL:" + count_SYMBOL
                + "\ncount_FUN_TYPE:" + count_FUN_TYPE
                + "\ncount_ACTION_OPERATOR:" + count_ACTION_OPERATOR
                + "\ncount_REMOVE:" + count_REMOVE
                + "\ncount_DOT:" + count_DOT
                + "\nCOUNT:" + COUNT);

        Log.d("Calculate", "OPERATION: nnn" + Arrays.toString(OPERATION));
        Log.d("Calculate", "OnOff: " + Boolean.toString(onoff));
        return onoff;
    }

    /***
     *生成按键的操作记录
     */
    public void ClickHistory(int type) {
        OPERATION[COUNT] = type;
        COUNT++;
    }

    /***
     * 根据按键操作记录恢复上一个按键连续计数器的状态（配合Remove使用，恢复输入被删除数据前的按键状态）
     */
    public void Pull() {
        try {
            switch (OPERATION[COUNT - 2]) {
                case MyButton.NUMBER_TYPE:
                    Log.d("Calculate", "NUMBER_TYPE:++ ");
                    if (count_NUMBER_TYPE == 0) {
                        Log.d("Calculate", "NUMBER_TYPE:++ ");
                        count_NUMBER_TYPE++;
                    }
                    break;
                case MyButton.CONSTANT_TYPE:
                    Log.d("Calculate", "CONSTANT_TYPE:++ ");
                    count_CONSTANT_TYPE++;
                    break;
                case MyButton.FUN_TYPE:

                    if (count_FUN_TYPE == 0) {
                        Log.d("Calculate", "FUN_TYPE:++ ");
                        count_FUN_TYPE++;
                    }
                    break;
                case MyButton.BIN_OPERATOR:
                    Log.d("Calculate", "BIN_OPERATOR: ++");
                    count_BIN_OPERATOR++;
                    break;
                case MyButton.LEFT_OPERATOR:
                    Log.d("Calculate", "LEFT_OPERATOR:++ ");
                    count_LEFT_OPERATOR++;
                    break;
                case MyButton.SYMBOL:
                    Log.d("Calculate", "SYMBOL:++ ");
                    count_SYMBOL++;
                    break;
                case MyButton.ACTION_OPERATOR:
                    Log.d("Calculate", "ACTION_OPERATOR:++ ");
                    count_ACTION_OPERATOR++;
                    break;
                case MyButton.DOT:
                    Log.d("Calculate", "DOT:++ ");
                    count_DOT++;
                    break;
                default:
                    Log.d("Calculate", "OnOff: " + "noPULL");
                    break;
            }
        } catch (Exception e) {
            Log.d("Calculate", "PULL _ Error");
        }


    }

    /***
     *System（）用来完成进制转换计算
     */
    public void System(String s) throws SystemException {
        topShowData.setLength(0);
        try {
            Integer temp = Integer.parseInt(result);
            if (temp < 0) {
                topShowData.append("Only Positive Number");
            } else {

                switch (s) {
                    case "bin:":
                        topShowData.append("bin:" + Integer.toBinaryString(temp));
                        break;
                    case "oct:":
                        topShowData.append("oct:" + Integer.toOctalString(temp));
                        break;
                    case "dec:":
                        topShowData.append("dec:" + Integer.toString(temp));
                        break;
                    case "hex:":
                        topShowData.append("hex:" + Integer.toHexString(temp));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            throw ex;
        }

    }

    /***
     *eval()解析calculateData中要被计算的数据，并返回计算结果
     */
    public static double eval(final String str) throws FactException {

        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("asin")) x = Math.toDegrees(Math.asin(x));
                    else if (func.equals("acos")) x = Math.toDegrees(Math.acos(x));
                    else if (func.equals("atan")) x = Math.toDegrees(Math.atan(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else if (func.equals("abs")) x = Math.abs(x);
                    else if (func.equals("exp")) x = Math.exp(x);
                    else if (func.equals("pow")) x = Math.pow(x, 1.0 / 3);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());// exponentiation
                if (eat('%')) x = (int) x % (int) parseFactor();
                try {
                    if (eat('!')) {
                        if (x % 1 == 0)
                            x = factorial(new BigDecimal((int) x)).intValue();
                        else
                            throw new FactException();
                    }
                } catch (FactException e) {
                    RuntimeException exc = new RuntimeException();
                    exc.initCause(e);
                    throw exc;
                }
                return x;
            }
        }.parse();

    }

    /***
     *factorial()阶乘计算，拓展eval（）的计算方法
     */
    public static BigDecimal factorial(BigDecimal n) throws FactException {


        if (n.intValue() == 0) {
            return new BigDecimal(1);
        }
        if (n.intValue() < 0) {
            Log.d("fact", "onCreate:Error ");
            throw new FactException();
        } else {
            BigDecimal bd1 = new BigDecimal(1);//1
            if (n.equals(new BigDecimal(1))) {
                return bd1;
            } else
                return n.multiply(factorial(n.subtract(bd1)));
        }//n*f(n-1)
    }

    /***
     *计算阶乘会产生的异常
     */
    public static class FactException extends Exception {
        String massage;

        public FactException() {
            massage = "Error OvO";
        }

        @Override
        public String toString() {
            return massage;
        }
    }

    /***
     *进制转换会产生的异常
     */
    public static class SystemException extends Exception {
        String massage;

        public SystemException() {
            massage = "It's too large to transform T_T";
        }

        @Override
        public String toString() {
            return massage;
        }
    }

    /***
     *Get and Set
     */
    public StringBuilder getCalculateData() {
        return calculateData;
    }

    public void setCalculateData(StringBuilder calculateData) {
        this.calculateData = calculateData;
    }

    public StringBuilder getBottomShowData() {
        return bottomShowData;
    }

    public void setBottomShowData(StringBuilder bottomShowData) {
        this.bottomShowData = bottomShowData;
    }

    public StringBuilder getTopShowData() {
        return topShowData;
    }

    public void setTopShowData(StringBuilder topShowData) {
        this.topShowData = topShowData;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}

