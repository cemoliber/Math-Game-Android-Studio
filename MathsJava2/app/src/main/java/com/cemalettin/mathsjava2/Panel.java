package com.cemalettin.mathsjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Panel extends AppCompatActivity {

    ImageButton sum;
    ImageButton sub;
    ImageButton multi;
    ImageButton divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        //for sum
        sum = findViewById(R.id.sum);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoSum();

            }
        });

        //for sub
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoSub();

            }
        });

        //for multi
        multi = findViewById(R.id.multi);
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoMulti();

            }
        });

        //for divide
        divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                gotoDivide();
            }
        });

    }


    public void gotoSum(){
        Intent intent = new Intent(this, Sum.class);
        startActivity(intent);
    }

    public void gotoSub(){
        Intent intent = new Intent(this, Sub.class);
        startActivity(intent);
    }

    public void gotoMulti(){
        Intent intent = new Intent(this, Multi.class);
        startActivity(intent);
    }


    public void gotoDivide(){
        Intent intent = new Intent(this, Divide.class);
        startActivity(intent);
    }

}