package com.pti4ka.ballo0n.balloon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class CheckerActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private Button button;
    private String secretCode = "perryBallo0n"; // замени на свою фразу!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_checker);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.checker);
        button = (Button) findViewById(R.id.sumbit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (text.equals(secretCode)) {
                    startActivity(new Intent(CheckerActivity.this, OmgActivity.class));
                    // ура! пасхалка!
                    Toast.makeText(CheckerActivity.this, "Well, you found it. Congratulations!", Toast.LENGTH_SHORT).show();
                } else {
                    // обычный текст
                    textView.setText(text);
                }
            }
        });
    }


    public void startMainActivity(View view) {
        startActivity(new Intent(CheckerActivity.this, MainActivity.class));
    }


}
