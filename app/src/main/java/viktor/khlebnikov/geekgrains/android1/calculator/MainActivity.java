package viktor.khlebnikov.geekgrains.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button0;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button1;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button2;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button3;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button4;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button5;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button6;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button7;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button8;
import static viktor.khlebnikov.geekgrains.android1.calculator.R.id.button9;

public class MainActivity extends AppCompatActivity {

    private TextView mResultField;

    private float mValueOne;
    private float mValueTwo;

    private boolean crunchifyPlus;
    private boolean crunchifyMinus;
    private boolean crunchifyMultiple;
    private boolean crunchifyDivision;

    private Float operand = null;

    private final View.OnClickListener btnNumberListener = this::onClick;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (operand != null)
            outState.putFloat("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        operand = savedInstanceState.getFloat("OPERAND");
        mResultField.setText(operand.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);

        MaterialButton mButton0 = findViewById(button0);
        MaterialButton mButton1 = findViewById(button1);
        MaterialButton mButton2 = findViewById(button2);
        MaterialButton mButton3 = findViewById(button3);
        MaterialButton mButton4 = findViewById(button4);
        MaterialButton mButton5 = findViewById(button5);
        MaterialButton mButton6 = findViewById(button6);
        MaterialButton mButton7 = findViewById(button7);
        MaterialButton mButton8 = findViewById(button8);
        MaterialButton mButton9 = findViewById(button9);
        MaterialButton mButtonPt = findViewById(R.id.buttonPt);
        MaterialButton mButtonPlus = findViewById(R.id.buttonPls);
        MaterialButton mButtonMinus = findViewById(R.id.buttonMns);
        MaterialButton mButtonMultiple = findViewById(R.id.buttonMultiple);
        MaterialButton mButtonDivision = findViewById(R.id.buttonDivide);
        MaterialButton mButtonClear = findViewById(R.id.buttonClear);
        MaterialButton mButtonResult = findViewById(R.id.buttonResult);
        mResultField = findViewById(R.id.textView2);
        MaterialButton mButtonSettings = findViewById(R.id.buttonSettings);

        mButton0.setOnClickListener(btnNumberListener);
        mButton1.setOnClickListener(btnNumberListener);
        mButton2.setOnClickListener(btnNumberListener);
        mButton3.setOnClickListener(btnNumberListener);
        mButton4.setOnClickListener(btnNumberListener);
        mButton5.setOnClickListener(btnNumberListener);
        mButton6.setOnClickListener(btnNumberListener);
        mButton7.setOnClickListener(btnNumberListener);
        mButton8.setOnClickListener(btnNumberListener);
        mButton9.setOnClickListener(btnNumberListener);

        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                if (mResultField.getText() == "0") {
                    mResultField.setText("");
                } else {
                    mValueOne = Float.parseFloat(mResultField.getText() + "");
                    operand = mValueOne;
                    crunchifyPlus = true;
                    mResultField.setText("0");
                }
            }
        });

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                if (mResultField.getText() == "0") {
                    mResultField.setText("-");
                } else {
                    mValueOne = Float.parseFloat(mResultField.getText() + "");
                    operand = mValueOne;
                    crunchifyMinus = true;
                    mResultField.setText("0");
                }
            }
        });

        mButtonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                mValueOne = Float.parseFloat(mResultField.getText() + "");
                operand = mValueOne;
                crunchifyMultiple = true;
                mResultField.setText("0");
            }
        });

        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                mValueOne = Float.parseFloat(mResultField.getText() + "");
                operand = mValueOne;
                crunchifyDivision = true;
                mResultField.setText("0");
            }
        });

        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                mValueTwo = Float.parseFloat(mResultField.getText() + "");

                if (crunchifyPlus) {
                    operand = (mValueOne + mValueTwo);
                    mResultField.setText(operand + "");
                    crunchifyPlus = false;
                }

                if (crunchifyMinus) {
                    operand = (mValueOne - mValueTwo);
                    mResultField.setText(operand + "");
                    crunchifyMinus = false;
                }

                if (crunchifyMultiple) {
                    operand = (mValueOne * mValueTwo);
                    mResultField.setText(operand + "");
                    crunchifyMultiple = false;
                    if (Float.isInfinite(operand))
                        mResultField.setText(R.string.exception_infinity);
                }

                if (crunchifyDivision) {
                    operand = (mValueOne / mValueTwo);
                    if (mValueTwo == 0) {
                        mResultField.setText(R.string.exeption_divide_zero);
                    } else
                        mResultField.setText(operand + "");
                    crunchifyDivision = false;
                }

            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultField.setText("0");
                operand = null;
            }
        });

        mButtonPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isText(mResultField);
                textIsMinusOnly(mResultField);
                String result = mResultField.getText().toString();
                if (!result.contains(".")) {
                    mResultField.setText(mResultField.getText() + ".");
                }
            }
        });

        mButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });

    }

    void textIsMinusOnly(View v) {
        if (mResultField.getText() == "-") {
            mResultField.setText("0");
        }
    }

    void isText(View v) {
        if (!mResultField.getText().toString().matches("[\\d,\\-,.,\\,]+"))
            mResultField.setText("0");
    }

    private void onClick(View view) {

        isText(mResultField);

        switch (view.getId()) {

            case button0: {
                if (!(mResultField.getText().equals("0"))) {
                    mResultField.setText(mResultField.getText() + "0");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button1: {
                if (mResultField.getText().equals("0")) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "1");
                } else {
                    mResultField.setText(mResultField.getText() + "1");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button2: {
                if (mResultField.getText().equals("0")) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "2");
                } else {
                    mResultField.setText(mResultField.getText() + "2");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button3: {
                if (mResultField.getText().equals("0")) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "3");
                } else {
                    mResultField.setText(mResultField.getText() + "3");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button4: {
                if (mResultField.getText().equals("0")) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "4");
                } else {
                    mResultField.setText(mResultField.getText() + "4");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button5: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "5");
                } else {
                    mResultField.setText(mResultField.getText() + "5");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button6: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "6");
                } else {
                    mResultField.setText(mResultField.getText() + "6");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button7: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "7");
                } else {
                    mResultField.setText(mResultField.getText() + "7");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button8: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "8");
                } else {
                    mResultField.setText(mResultField.getText() + "8");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case button9: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "9");
                } else {
                    mResultField.setText(mResultField.getText() + "9");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}