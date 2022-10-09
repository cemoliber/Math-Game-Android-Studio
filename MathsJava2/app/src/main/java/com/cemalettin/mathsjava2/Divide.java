package com.cemalettin.mathsjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class Divide extends AppCompatActivity {

    private Button sendButton;
    private TextView questionInfo;
    private TextView resultInfo;
    private EditText answerText;

    private float realAnswer;

    public TextView pointText;
    public static int point;

    int x1,x2;
    int i1,i2;

    Random r1 = new Random();
    Random r2 = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        questionInfo = findViewById(R.id.questionText);
        resultInfo = findViewById(R.id.status);

        Random r = new Random();
        int i1 = (r.nextInt(101) + 1);


        Random r2 = new Random();
        int i2 = (r2.nextInt(16) + 1);

        while(i1 % i2 != 0 && i1 < i2){
            i1 = (r.nextInt(101) + 1);
            i2 = (r2.nextInt(16) + 1);
        }


        realAnswer = i1 / i2;//anwser
        String message = i1+" / "+i2;//function for shows to users
        questionInfo.setText(message);//shows to users

        workSub();
        workRefresh();

    }

    private void workRefresh() {

        Button refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //first random number
                i1 = (r1.nextInt(1001) + 1);
                x1 = i1;

                //second random number
                i2 = (r2.nextInt(1001) + 1);
                x2 = i2;

                //send info to textViews
                questionInfo = findViewById(R.id.questionText);
                resultInfo = findViewById(R.id.status);

                realAnswer = x1 / x2;//anwser
                String message = x1+" / "+x2;//function for shows to users
                questionInfo.setText(message);//shows to users


            }
        });

    }

    public void workSub(){

        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointText = findViewById(R.id.point);

                answerText = findViewById(R.id.answerText);
                String answerStr = answerText.getText().toString();
                float enteredAnswer = Integer.parseInt(answerStr);

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