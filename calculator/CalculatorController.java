package com.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    // 按纽及标签定义
    @FXML
    private Button x2, x3, Xy, sqrt, yroot, inv;  // 平方 三次方 y次方 平方根 y次方根 倒数
    @FXML
    private Button add, sub, mul, div;  // + - * /
    @FXML
    private Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;  // 数字
    @FXML
    private Button sin, cos, tan, asin, acos, atan;  // 三角与反三角
    @FXML
    private Label results; // 显示
    @FXML
    private Button clear; // C
    @FXML
    private Button equ; // =


    //给按钮添加事件，调用显示整体式子的函数，各个按钮对应该内容的字符串
    @FXML
    void n0(ActionEvent event) { getString("0"); }
    @FXML
    void n1(ActionEvent event) { getString("1"); }
    @FXML
    void n2(ActionEvent event) { getString("2"); }
    @FXML
    void n3(ActionEvent event) { getString("3"); }
    @FXML
    void n4(ActionEvent event) { getString("4"); }
    @FXML
    void n5(ActionEvent event) { getString("5"); }
    @FXML
    void n6(ActionEvent event) { getString("6"); }
    @FXML
    void n7(ActionEvent event) { getString("7"); }
    @FXML
    void n8(ActionEvent event) { getString("8"); }
    @FXML
    void n9(ActionEvent event) { getString("9"); }

    @FXML
    void div(ActionEvent event) { getString("/"); }
    @FXML
    void mul(ActionEvent event) { getString("*"); }
    @FXML
    void sub(ActionEvent event) { getString("-"); }
    @FXML
    void add(ActionEvent event) { getString("+"); }
    @FXML
    void equ(ActionEvent event) { getString("="); }
    @FXML
    void clear(ActionEvent event) { getString("C"); }


    @FXML
    void x2(ActionEvent event) { getString("x²"); }
    @FXML
    void x3(ActionEvent event) { getString("x³"); }
    @FXML
    void Xy(ActionEvent event) { getString("Xy"); }
    @FXML
    void sqrt(ActionEvent event) { getString("√x"); }
    @FXML
    void yroot(ActionEvent event) { getString("y√x"); }
    @FXML
    void inv(ActionEvent event) { getString("1/x"); }
    
    @FXML
    void sin(ActionEvent event) { getString("sin"); }
    @FXML
    void cos(ActionEvent event) { getString("cos"); }
    @FXML
    void tan(ActionEvent event) { getString("tan"); }
    @FXML
    void asin(ActionEvent event) { getString("asin"); }
    @FXML
    void acos(ActionEvent event) { getString("acos"); }
    @FXML
    void atan(ActionEvent event) { getString("atan"); }

    
    private void getString(String s) {     //  整体式子
        String out = "";  //输出显示
        if (results.getText().equals("0") || results.getText().equals("error")) {
            results.setText("0");  // 置零操作
        }

        switch (s) {
            //两个数，由=出结果，本符号显示在屏幕上
            case "+":
            case "-":
            case "*":
            case "/":
                out = results.getText() + " " + s + " ";
                break;
            case "y√x":
                out = results.getText() + " " + "√" + " ";
                break;
            case "Xy":
                out = results.getText() + " " + "^" + " ";
                break;

            //由符号出结果  ，无需再屏幕上显示该符号  
            case "=":
                out = getResult1();
                break;
            case "sin":
                out = getResultsin();
                break;
            case "cos":
                out = getResultcos();
                break;
            case "tan":
                out = getResulttan();
                break;
            case "asin":
                out = getResultasin();
                break;
            case "acos":
                out = getResultacos();
                break;
            case "atan":
                out = getResultatan();
                break;
            case "x²":
                out = getResultx2();
                break;
            case "x³":
                out = getResultx3();
                break;
            case "√x":
                out = getResultsqrt();
                break;
            case "1/x":
                out = getResultinv();
                break;
            case "C":
                results.setText("");
                break;
            
            // 数字显示
            default:
                out = results.getText() + s;
                break;
        }
        results.setText(out);  // 输出显示到屏幕中
    }

    private String getResult1() {  // 由“=”作为输出标志的
        try {
            String[] textbox = results.getText().split(" ");
            float result = Float.parseFloat(textbox[0]);  //第一个数

            for (int i = 2; i < textbox.length; i += 2) {
                float num = Float.parseFloat(textbox[i]);  //第二个数

                switch (textbox[i - 1]) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "/":
                        result = Float.parseFloat(textbox[i - 2]) / num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "^":
                        result = (float) Math.pow(result, num);
                        break;
                    case "√":
                        result = (float) Math.pow(result, 1 / num);
                        break;
                }
            }

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }

        } catch (NumberFormatException e) {
            System.err.println("wrong input || null String");
            return "error";
        }
    }

    private String getResultx2() {  // x2

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);  // 取x

        result = result * result;  //x2

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private String getResultx3() {  // x3

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        result = result * result * result; 

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private String getResultinv() {  // 1/x

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        if (result == 0) {
            return ("error");   // 分母不为0
        } else {
            result = 1 / result;

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        }
    }

    private String getResultsin() {  // sin

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        result = (float) Math.toRadians(result);  //转化为角度，求三角
        result = (float) Math.sin(result);        

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private String getResultcos() {  // cos

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        result = (float) Math.toRadians(result);    //转化为角度，求三角
        result = (float) Math.cos(result);

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private String getResulttan() { //tan

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        if (result == 0 || result % 90 != 0) {      // tan90°无意义

            result = (float) Math.toRadians(result);   // 转化为角度，求三角
            result = (float) Math.tan(result);

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        } else {
            return ("error");
        }
    }

    private String getResultasin() { //asin

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        if (result >= -1 && result <= 1) {     // 反三角定义域
            result = (float) Math.asin(result);

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        } else {
            return "error";
        }

    }

    private String getResultacos() { //acos

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        if (result >= -1 && result <= 1) {    // 反三角定义域
            result = (float) Math.acos(result);

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        } else {
            return "error";
        }

    }

    private String getResultatan() { //atan

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        result = (float) Math.atan(result);    //定义域为R

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private String getResultsqrt() { //sqrt

        String[] textbox = results.getText().split(" ");
        float result = Float.parseFloat(textbox[0]);

        result = (float) Math.sqrt(result);

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

}
