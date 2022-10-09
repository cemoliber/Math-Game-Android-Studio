package com.cemalettin.mathsjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signing;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signing = findViewById(R.id.signing);
        signing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoSigning();
            }
        });

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoRegister();
            }
        });

    }

    public void gotoSigning() {
        Intent intent = new Intent(this, Signing.class);
        startActivity(intent);
    }

    public void gotoRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}