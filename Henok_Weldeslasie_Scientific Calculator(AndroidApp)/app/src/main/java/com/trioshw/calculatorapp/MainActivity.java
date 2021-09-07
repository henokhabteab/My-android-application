package com.trioshw.calculatorapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Level;
import java.util.logging.Logger;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private static final Logger logger = Logger.getLogger(MainActivity.class.toString());
    private TextView previousCalculation;
    private EditText display;
    private boolean isTrigo = false;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {

        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        logger.log(Level.INFO, "jana " + oldStr + "," + leftStr + "," + rightStr);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());



    }

    public void zeroBTNPUSH(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTNPUSH(View view) {
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPUSH(View view) {
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTNPUSH(View view) {
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPUSH(View view) {
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPUSH(View view) {
        
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPUSH(View view) {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPUSH(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPUSH(View view) {
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPUSH(View view) {
        updateText(getResources().getString(R.string.nineText));
    }

    public void multiplyBTNPUSH(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBTNPUSH(View view) {
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtractBTNPUSH(View view) {
        updateText(getResources().getString(R.string.subtractText));
    }

    public void addBTNPUSH(View view) {

        updateText(getResources().getString(R.string.addText));
    }
    public void decimalBTNPUSH(View view) {
        updateText(getResources().getString(R.string.decimalText));
    }

    public void clearBTNPUSH(View view) {
        isTrigo = false;

        display.setText("");
        previousCalculation.setText("");
    }

    public void parOpenBTNPUSH(View view) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parCloseBTNPUSH(View view) {
        isTrigo = false;
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void equalBTNPUSH(View view) {
        String userExp = display.getText().toString();
        if (isTrigo) {
            userExp = userExp + ")";
        }
        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");
        userExp = userExp.replaceAll("log", "log10");
        userExp = userExp.replaceAll("π", "pi");


        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        isTrigo = false;
        display.setSelection(result.length());

    }

    public void backspaceBTNPUSH(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
            previousCalculation.setText(selection);
        }
    }

    public void trigSinBTNPUSH(View view) {
        isTrigo = true;
        updateText("sin(");
    }

    public void trigCosBTNPUSH(View view) {
        isTrigo = true;
        updateText("cos(");
    }

    public void trigTanBTNPUSH(View view) {
        isTrigo = true;
        updateText("tan(");
    }

    public void trigArcSinBTNPUSH(View view) {
        isTrigo = true;
        updateText("arcsin(");
    }

    public void trigArcCosBTNPUSH(View view) {
        isTrigo = true;
        updateText("arccos(");
    }

    public void trigArcTanBTNPUSH(View view) {
        isTrigo = true;
        updateText("arctan(");
    }

    public void logBTNPUSH(View view) {
        isTrigo = true;
        updateText("log(");
    }

    public void naturalLogBTNPUSH(View view) {
        isTrigo = true;
        updateText("ln(");
    }

    public void squareRootBTNPUSH(View view) {
//        updateText("sqrt(");
        isTrigo = true;
        updateText("sqrt(");
    }

    public void eBTNPUSH(View view) {
        isTrigo = true;
        updateText("e*(");
    }

    public void piBTNPUSH(View view) {
        isTrigo = true;
        updateText("π*(");
    }

    public void absBTNPUSH(View view) {
        isTrigo = true;
        updateText("abs(");
    }

    public void primeBTNPUSH(View view) {
        isTrigo = true;
        updateText("ispr(");
    }

    public void xSquaredBTNPUSH(View view) {
        isTrigo = true;
        updateText("^(2");
    }

    public void xPowerYBTNPUSH(View view) {
        isTrigo = true;
        updateText("^(");
    }
}