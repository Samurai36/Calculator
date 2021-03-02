package viktor.khlebnikov.geekgrains.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonDivision;
    private Button mButtonMultiple;
    private Button mButtonPt;
    private Button mButtonClear;
    private Button mButtonResult;
    private TextView mResultField;

    private float mValueOne;
    private float mValueTwo;

    private boolean crunchifyPlus;
    private boolean crunchifyMinus;
    private boolean crunchifyMultiple;
    private boolean crunchifyDivision;

    private Float operand = null;

    private final View.OnClickListener btnNumberListener = (view) -> {

        switch (view.getId()) {

            case R.id.button0: {
                if (!("0".equals(mResultField.getText()))) {
                    mResultField.setText(mResultField.getText() + "0");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button1: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "1");
                } else {
                    mResultField.setText(mResultField.getText() + "1");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button2: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "2");
                } else {
                    mResultField.setText(mResultField.getText() + "2");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button3: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "3");
                } else {
                    mResultField.setText(mResultField.getText() + "3");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button4: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "4");
                } else {
                    mResultField.setText(mResultField.getText() + "4");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button5: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "5");
                } else {
                    mResultField.setText(mResultField.getText() + "5");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button6: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "6");
                } else {
                    mResultField.setText(mResultField.getText() + "6");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button7: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "7");
                } else {
                    mResultField.setText(mResultField.getText() + "7");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button8: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "8");
                } else {
                    mResultField.setText(mResultField.getText() + "8");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
            case R.id.button9: {
                if ("0".equals(mResultField.getText())) {
                    mResultField.setText("");
                    mResultField.setText(mResultField.getText() + "9");
                } else {
                    mResultField.setText(mResultField.getText() + "9");
                    operand = Float.parseFloat(mResultField.getText() + "");
                }
                break;
            }
        }
    };


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

        mButton0 = findViewById(R.id.button0);
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);
        mButton5 = findViewById(R.id.button5);
        mButton6 = findViewById(R.id.button6);
        mButton7 = findViewById(R.id.button7);
        mButton8 = findViewById(R.id.button8);
        mButton9 = findViewById(R.id.button9);
        mButtonPt = findViewById(R.id.buttonPt);
        mButtonPlus = findViewById(R.id.buttonPls);
        mButtonMinus = findViewById(R.id.buttonMns);
        mButtonMultiple = findViewById(R.id.buttonMultiple);
        mButtonDivision = findViewById(R.id.buttonDivide);
        mButtonClear = findViewById(R.id.buttonClear);
        mButtonResult = findViewById(R.id.buttonResult);
        mResultField = findViewById(R.id.textView2);

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
                mValueOne = Float.parseFloat(mResultField.getText() + "");
                operand = mValueOne;
                crunchifyMinus = true;
                mResultField.setText("0");
            }
        });

        mButtonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(mResultField.getText() + "");
                operand = mValueOne;
                crunchifyMultiple = true;
                mResultField.setText("0");
            }
        });

        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(mResultField.getText() + "");
                operand = mValueOne;
                crunchifyDivision = true;
                mResultField.setText("0");
            }
        });

        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(mResultField.getText() + "");

                if (crunchifyPlus == true) {
                    mResultField.setText(mValueOne + mValueTwo + "");
                    operand = (mValueOne + mValueTwo);
                    crunchifyPlus = false;
                }

                if (crunchifyMinus == true) {
                    mResultField.setText(mValueOne - mValueTwo + "");
                    operand = (mValueOne - mValueTwo);
                    crunchifyMinus = false;
                }

                if (crunchifyMultiple == true) {
                    mResultField.setText(mValueOne * mValueTwo + "");
                    operand = (mValueOne * mValueTwo);
                    crunchifyMultiple = false;
                }

                if (crunchifyDivision == true) {
                    if (mValueTwo == 0) {
                        mResultField.setText("Don't divide by zero");
                    } else
                        mResultField.setText(mValueOne / mValueTwo + "");
                    operand = (mValueOne / mValueTwo);
                    crunchifyDivision = false;
                }
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultField.setText("");
                operand = null;
            }
        });

        mButtonPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = mResultField.getText().toString();
                if (!result.contains(".")) {
                    mResultField.setText(mResultField.getText() + ".");
                }
            }
        });
    }

}