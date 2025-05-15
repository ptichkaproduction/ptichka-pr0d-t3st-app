package com.pti4ka.ballo0n.balloon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CheckerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_checker);
    }

    public void startMainActivity(View view) {
        startActivity(new Intent(CheckerActivity.this, MainActivity.class));
    }

    public void check (View v){

        EditText editMessage=(EditText)findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.checker);

        //get text from edittext and convert it to string
        String messageString=editMessage.getText().toString();

        //set string from edittext to textview
        textView.setText(messageString);

        //clear edittext after sending text to message
        editMessage.setText("");


    }

}
