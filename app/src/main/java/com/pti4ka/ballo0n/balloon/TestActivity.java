package com.pti4ka.ballo0n.balloon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import junit.runner.Version;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);


        Button WOW = (Button) findViewById(R.id.wow_button);
        WOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
                builder.setTitle("EXIT FROM THIS T3ST???");
                builder.setMessage("Are you sure you want to exit??");
                builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    finish();

                }
            });
                builder.setNegativeButton("No, thanks!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
            }
        });
    }

    public void startVersionActivity(View view) {
        startActivity(new Intent(TestActivity.this, VersionActivity.class));
    }


    public void startOmgActivity(View view) {
        startActivity(new Intent(TestActivity.this, OmgActivity.class));
    }


    public void startCheckerActivity(View view) {
        startActivity(new Intent(TestActivity.this, CheckerActivity.class));
    }


    public void startTestActivity(View view) {
        startActivity(new Intent(TestActivity.this, TestActivity.class));
    }


}

