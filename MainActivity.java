package com.example.theweightonator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView currentWeight;
    private TextView EmptyH;
    private TextView EmptyL;
    private TextView maxWeightR;
    private ImageView hw_1;
    private ImageView hw_2;
    private ImageView hw_3;
    private ImageView hw_4;
    private ImageView hw_5;
    private ImageView hw_6;
    private ImageView lw;
    private Button addWeightHigh;
    private Button addWeightLow;
    private Button reset;
    double num = 4.5;
    int heavyWeight=0;
    int lessWeight=0;
    double maxWeight=33.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWeight = (TextView) findViewById(R.id.numWeight);
        addWeightHigh = (Button) findViewById(R.id.buttonHigh);
        addWeightLow = (Button) findViewById(R.id.buttonLow);
        reset = (Button) findViewById(R.id.reset);
        EmptyH = (TextView) findViewById(R.id.EmptyHeavy);
        EmptyL = (TextView) findViewById(R.id.EmptyLessHeavy);
        maxWeightR = (TextView) findViewById(R.id.maxWeightReached);
        hw_1 = (ImageView) findViewById(R.id.hw_1);
        hw_2 = (ImageView) findViewById(R.id.hw_2);
        hw_3 = (ImageView) findViewById(R.id.hw_3);
        hw_4 = (ImageView) findViewById(R.id.hw_4);
        hw_5 = (ImageView) findViewById(R.id.hw_5);
        hw_6 = (ImageView) findViewById(R.id.hw_6);
        lw = (ImageView) findViewById(R.id.lw);


        addWeightHigh.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num<maxWeight){
                    if(heavyWeight<6){
                        num=num+4.4;
                        Math.ceil(num);
                        currentWeight.setText(Double.toString(num));
                        heavyWeight++;
                        if (heavyWeight==1) {hw_1.setVisibility(View.VISIBLE);}
                        if (heavyWeight==2) {hw_2.setVisibility(View.VISIBLE);}
                        if (heavyWeight==3) {hw_3.setVisibility(View.VISIBLE);}
                        if (heavyWeight==4) {hw_4.setVisibility(View.VISIBLE);}
                        if (heavyWeight==5) {hw_5.setVisibility(View.VISIBLE);}
                        if (heavyWeight==6) {hw_6.setVisibility(View.VISIBLE);EmptyH.setVisibility(View.VISIBLE);}

                    }
            }else {
                    maxWeightR.setVisibility(View.VISIBLE);
                    EmptyH.setVisibility(View.VISIBLE);
                    currentWeight.setText(Double.toString(maxWeight));

                }
        }}));

        addWeightLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num<maxWeight){
                    if(lessWeight<1) {
                        num = num + 2.2;
                        Math.ceil(num);
                        currentWeight.setText(Double.toString(num));
                        lessWeight++;
                        lw.setVisibility(View.VISIBLE);
                        EmptyL.setVisibility(View.VISIBLE);
                    }
                }else if (num>33){
                    maxWeightR.setVisibility(View.VISIBLE);
                    EmptyL.setVisibility(View.VISIBLE);
                    currentWeight.setText(Double.toString(maxWeight));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=4.5f;
                currentWeight.setText(Double.toString(num));
                heavyWeight=0;
                lessWeight=0;
                EmptyH.setVisibility(View.INVISIBLE);
                EmptyL.setVisibility(View.INVISIBLE);
                maxWeightR.setVisibility(View.INVISIBLE);
                hw_1.setVisibility(View.INVISIBLE);
                hw_2.setVisibility(View.INVISIBLE);
                hw_3.setVisibility(View.INVISIBLE);
                hw_4.setVisibility(View.INVISIBLE);
                hw_5.setVisibility(View.INVISIBLE);
                hw_6.setVisibility(View.INVISIBLE);
                lw.setVisibility(View.INVISIBLE);

            }
        });
    }
}
