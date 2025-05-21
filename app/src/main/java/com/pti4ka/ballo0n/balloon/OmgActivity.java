package com.pti4ka.ballo0n.balloon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class OmgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.easter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.omg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSecret);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("OMG! IT'S A SECRET!!!");
    }

    public void startMainActivity(View view) {
        startActivity(new Intent(OmgActivity.this, MainActivity.class));
    }

}
