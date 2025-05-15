package com.pti4ka.ballo0n.balloon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OmgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.easter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.omg);
    }

    public void startMainActivity(View view) {
        startActivity(new Intent(OmgActivity.this, MainActivity.class));
    }

}
