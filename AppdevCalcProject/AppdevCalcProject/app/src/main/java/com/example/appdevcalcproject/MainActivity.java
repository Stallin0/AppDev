package com.example.appdevcalcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "OUTPUT CHECK";
    private static final String TAG1 = "VALUE CHECK";
    String wholeOp = "";
    TextView display;
    Button I;
    Button II;
    Button III;
    Button IV;
    Button V;
    Button VI;
    Button VII;
    Button IIX;
    Button IX;
    Button add;
    Button sub;
    Button mult;
    Button div;
    Button cl;
    Button z;
    Button equ;
    Button leftP;
    Button rightP;
    Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        z = findViewById(R.id.zero);
        z.setOnClickListener(this);
        I = findViewById(R.id.one);
        I.setOnClickListener(this);
        II = findViewById(R.id.two);
        II.setOnClickListener(this);
        III = findViewById(R.id.three);
        III.setOnClickListener(this);
        IV = findViewById(R.id.four);
        IV.setOnClickListener(this);
        V = findViewById(R.id.five);
        V.setOnClickListener(this);
        VI = findViewById(R.id.six);
        VI.setOnClickListener(this);
        VII = findViewById(R.id.seven);
        VII.setOnClickListener(this);
        IIX = findViewById(R.id.eight);
        IIX.setOnClickListener(this);
        IX = findViewById(R.id.nine);
        IX.setOnClickListener(this);
        add = findViewById(R.id.plus);
        add.setOnClickListener(this);
        sub = findViewById(R.id.minus);
        sub.setOnClickListener(this);
        mult = findViewById(R.id.multiply);
        mult.setOnClickListener(this);
        div = findViewById(R.id.divide);
        div.setOnClickListener(this);
        equ = findViewById(R.id.equals);
        equ.setOnClickListener(this);
        leftP = findViewById(R.id.paraO);
        leftP.setOnClickListener(this);
        rightP = findViewById(R.id.paraC);
        rightP.setOnClickListener(this);
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

    }
    public String solver(String wO){
        String tempOp = wO;
        ArrayList<String> workList = new ArrayList<>();
        String[] workArray = tempOp.split(" ");
        String workString = "";
        ArrayList<Integer> paraClean = new ArrayList<>();
        int fCount = 0;

        for(int i = 0; i < workArray.length; i++){
            int wack = i+1;
            Log.d(TAG, workArray[i]);
            //Log.d(TAG, workArray[wack]);

            if(workArray[i].equals("+")||workArray[i].equals("-")||workArray[i].equals("/")||workArray[i].equals("X")){
                Log.d(TAG, "check");
                if(wack>= workArray.length){
                    return "error (press clear)";
                }
                else if(workArray[wack].equals("+")||workArray[wack].equals("-")||workArray[wack].equals("/")||workArray[wack].equals("X")){
                    Log.d(TAG, "check");
                    return "ERROR";
                }
            }
        }

        for(String i: workArray){
            workList.add(i);
            //Log.d(TAG, workList.get(fCount));

            /*if((workList.get(fCount)).equals(" ")){
                wholeOp = "ERROR";
                return wholeOp;
            }
            fCount++;
            */

        }
        /*
        int count = 0;
        for(int i = 0; i < workList.size(); i++) {
            if (workList.get(i).equals("(")) {
                int tempI = i+1;
                String temptempOp = "";
                while(!workList.get(tempI).equals(")")){
                    temptempOp+=workList.get(tempI);
                    paraClean.add(tempI);
                    tempI++;
                }
                paraClean.add(tempI);


                String replace = solver(temptempOp);
                workList.set(paraClean.remove(i), replace);
                for(int o: paraClean){
                    workList.remove(o-count);
                    count++;
                }
            }
        }
        */
        for(int i = 0; i < workList.size(); i++){
            if(workList.get(i).equals("X")){
                int x1 = Integer.parseInt(workList.get(i-1));
                int x2 = Integer.parseInt(workList.get(i+1));;
                String value = String.valueOf(x1*x2);
                workList.set(i-1, value);
                workList.remove(i);
                workList.remove(i);
            }

        }
        for(int i = 0; i < workList.size(); i++){
            if(workList.get(i).equals("÷")){
                double x1 = Integer.parseInt(workList.get(i-1));
                double x2 = Integer.parseInt(workList.get(i+1));;
                if(x2 == 0)
                    return "error divide by zero";
                String value = String.valueOf(x1/x2);
                workList.set(i-1, value);
                workList.remove(i);
                workList.remove(i);
            }
        }

        for(int i = 0; i < workList.size(); i++){
            if(workList.get(i).equals("+")){
                Log.d(TAG1, workList.get(i));
                int x1 = Integer.parseInt(workList.get(i-1));
                int x2 = Integer.parseInt(workList.get(i+1));
                String value = String.valueOf(x1+x2);
                workList.set(i-1, value);
                workList.remove(i);
                workList.remove(i);
            }
        }
        for(int i = 0; i < workList.size(); i++){
            if(workList.get(i).equals("-")){
                int x1 = Integer.parseInt(workList.get(i-1));
                int x2 = Integer.parseInt(workList.get(i+1));;
                String value = String.valueOf(x1-x2);
                workList.set(i-1, value);
                workList.remove(i);
                workList.remove(i);
            }
        }
        for(int i = 0; i < workList.size();i++)
            workString+=workList.get(i);
        wholeOp = workString;
        return workString;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one:
                wholeOp+="1";
                display.setText(wholeOp);
                break;
            case R.id.two:
                wholeOp+="2";
                display.setText(wholeOp);
                break;
            case R.id.three:
                wholeOp+="3";
                display.setText(wholeOp);
                break;
            case R.id.four:
                wholeOp+="4";
                display.setText(wholeOp);
                break;
            case R.id.five:
                wholeOp+="5";
                display.setText(wholeOp);
                break;
            case R.id.six:
                wholeOp+="6";
                display.setText(wholeOp);
                break;
            case R.id.seven:
                wholeOp+="7";
                display.setText(wholeOp);
                break;
            case R.id.eight:
                wholeOp+="8";
                display.setText(wholeOp);
                break;
            case R.id.nine:
                wholeOp+="9";
                display.setText(wholeOp);
                break;
            case R.id.zero:
                wholeOp+="0";
                display.setText(wholeOp);
                break;
            case R.id.plus:
                wholeOp+=" + ";
                display.setText(wholeOp);
                break;
            case R.id.minus:
                wholeOp+=" - ";
                display.setText(wholeOp);
                break;
            case R.id.multiply:
                wholeOp+=" X ";
                display.setText(wholeOp);
                break;
            case R.id.divide:
                wholeOp+=" ÷ ";
                display.setText(wholeOp);
                break;
            case R.id.paraO:
                wholeOp+="( ";
                display.setText(wholeOp);
                break;
            case R.id.paraC:
                wholeOp+=" )";
                display.setText(wholeOp);
                break;
            case R.id.equals:
                String Endval = solver(wholeOp);
                display.setText(Endval);
                break;
            case R.id.clear:
                display.setText("cleared");
                wholeOp = "";
                break;
        }
    }
}