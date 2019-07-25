package com.example.user.idealweightapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    EditText editText;
    RadioButton female;
    RadioGroup radioGroup;
    Button button;
    TextView textView, textView2;

    int age, height;
    String sex, age_user;

    resultFemale result_Female;
    resultMale result_Male;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        seekBar();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age_user = editText.getText().toString();
                female = findViewById(radioGroup.getCheckedRadioButtonId());
                sex = (String) female.getText();

                if (TextUtils.isEmpty(age_user)) {
                    editText.setError("Please enter your age.");
                    return;
                }

                if (sex.equals("Female")) { //female
                    if (height >= 152) {
                        age = Integer.parseInt(age_user);
                        result_Female = new resultFemale(textView2, height, age);
                        result_Female.calculateMethod();
                        result_Female.showResult();
                    } else {
                        age = Integer.parseInt(age_user);
                        result_Female = new resultFemale(textView2, height, age);
                        result_Female.calculateMethod2();
                        result_Female.showResult2();
                    }
                } else { //male
                    if (height >= 152) {
                        age = Integer.parseInt(age_user);
                        result_Male = new resultMale(textView2, height, age);
                        result_Male.calculateMethod();
                        result_Male.showResult();
                    } else {
                        age = Integer.parseInt(age_user);
                        result_Male = new resultMale(textView2, height, age);
                        result_Male.calculateMethod2();
                        result_Male.showResult2();
                    }
                }
            }
        });
    }

    protected void findID() {
        seekbar = findViewById(R.id.height_SeekBar);
        editText = findViewById(R.id.age_editText);
        radioGroup = findViewById(R.id.radioBtn);
        button = findViewById(R.id.calBtn);
        textView = findViewById(R.id.showText);
        textView2 = findViewById(R.id.result);
    }

    @SuppressLint("SetTextI18n")
    private void seekBar() {

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue = 0;

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                textView.setText("You're at " + progress + " CM now"); //starting height
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText(progressValue + " CM"); //textView start with 0
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Your height is " + seekBar.getProgress() + " CM"); //your final height
                if (seekBar.getProgress() == seekBar.getMax()) {
                    textView.setText("You've reached maximum limit of height : " + seekBar.getMax() + " CM");
                }
               height = seekbar.getProgress();
            }
        });
    }

}
