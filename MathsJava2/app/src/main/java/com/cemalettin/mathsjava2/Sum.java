package com.cemalettin.mathsjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Sum extends AppCompatActivity  {

    private TextView questionInfo;
    private TextView resultInfo;
    private EditText answerText;
    private int realAnswer;
    public TextView pointText;
    public static int point;

    int x1,x2;
    int i1,i2;

    Random r1 = new Random();
    Random r2 = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);


        //first random number
        i1 = (r1.nextInt(101) + 1);
        x1 = i1;

        //second random number
        i2 = (r2.nextInt(101) + 1);
        x2 = i2;




        //send info to textViews
        questionInfo = findViewById(R.id.questionText);
        resultInfo = findViewById(R.id.status);

        realAnswer = x1 + x2;//anwser
        String message = x1+" + "+x2;//function for shows to users
        questionInfo.setText(message);//shows to users

        workRefresh();

        workSum();

    }

    private void workRefresh() {

        Button refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //first random number
                i1 = (r1.nextInt(501) + 1);
                x1 = i1;

                //second random number
                i2 = (r2.nextInt(501) + 1);
                x2 = i2;


                //send info to textViews
                questionInfo = findViewById(R.id.questionText);
                resultInfo = findViewById(R.id.status);

                realAnswer = x1 + x2;//anwser
                String message = x1+" + "+x2;//function for shows to users
                questionInfo.setText(message);//shows to users
            }
        });

    }

    public void workSum(){


        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //side********
                pointText = findViewById(R.id.point);

                answerText = findViewById(R.id.answerText);
                String answerStr = answerText.getText().toString();
                int enteredAnswer = Integer.parseInt(answerStr);

                if(enteredAnswer == realAnswer){
                    String message2 = "CONGRATULATIONS!! You Find the "+ realAnswer;
                    resultInfo.setText("");
                    resultInfo.setText(message2);
                    point += 3;
                }else{
                    String message3 = "UNFORTUNATELY!! Answer Was: "+realAnswer+" :(";
                    resultInfo.setText("");
                    resultInfo.setText(message3);
                    point -=5;
                }
                closeKeyboard();
                String message4 = "POINT: "+point;
                pointText.setText(message4);
            }
        });
    }

    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}