package com.example.user.idealweightapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.widget.TextView;

public class ResultMale implements CalculationMethod {

    private final int height;
    private final int age;
    private int GJHamwi_Formula;
    private int BJDevine_Formula;
    private int JDRobinson_Formula;
    private int DRMiller_Formula;
    private int bmi;
    private final TextView textView;

    ResultMale(TextView textView, int height, int age) {
        this.textView = textView;
        this.height = height;
        this.age = age;
    }

    @Override
    public void calculateMethod() {
        GJHamwi_Formula = (int) (48 + (2.7 * ((height - 152.4) * 0.393701)));
        BJDevine_Formula = (int) (50 + (2.3 * ((height - 152.4) * 0.393701)));
        JDRobinson_Formula = (int) (52 + (1.9 * ((height - 152.4) * 0.393701)));
        DRMiller_Formula = (int) (56.2 + (1.4 * ((height - 152.4) * 0.393701)));
        bmi = (int) ((height - 100 + (age * 0.1)) * 0.9);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void showResult() {
        if (age < 2) {
            textView.setTextColor(Color.RED);
           textView.setText("Please enter your age more than 2");
        } else if (age >= 80) {
            textView.setTextColor(Color.RED);
            textView.setText("Please enter your age less than 80");
        } else {
            textView.setTextColor(Color.BLACK);
            textView.setText(String.format("Based on the Robinson formula (1983), " +
                            "your ideal weight is %d kgs\n" +
                            "Based on the Miller formula (1983), your ideal weight is %d kgs\n" +
                            "Based on the Devine formula (1974), your ideal weight is %d kgs\n" +
                            "Based on the Hamwi formula (1964), your ideal weight is %d kgs\n" +
                            "Based on the healthy BMI recommendation, your recommended weight is %d kgs",
                    JDRobinson_Formula, DRMiller_Formula, BJDevine_Formula, GJHamwi_Formula, bmi));
        }
    }

    @Override
    public void calculateMethod2() {
        bmi = (int) ((height - 100 + (age * 0.1)) * 0.9);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void showResult2() {
        if (age < 2) {
            textView.setTextColor(Color.RED);
            textView.setText("Please enter your age more than 2");
        } else if (age >= 80) {
            textView.setTextColor(Color.RED);
            textView.setText("Please enter your age less than 80");
        } else {
            textView.setTextColor(Color.BLACK);
            textView.setText(String.format("Based on the healthy BMI recommendation, your recommended weight is %d kgs", bmi));
        }
    }
}
