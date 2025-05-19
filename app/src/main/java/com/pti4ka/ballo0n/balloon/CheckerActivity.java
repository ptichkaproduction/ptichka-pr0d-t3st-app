package com.pti4ka.ballo0n.balloon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class CheckerActivity extends AppCompatActivity

    implements NavigationView.OnNavigationItemSelectedListener{


    private EditText editText;
    private TextView textView;
    private Button button;
    private String secretCode = "perryBallo0n"; // замени на свою фразу!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarChecker);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Keyboard checker =D");


        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.checker);
        button = (Button) findViewById(R.id.sumbit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (text.equals(secretCode)) {
                    textView.setText("OMG!!!");
                    startActivity(new Intent(CheckerActivity.this, OmgActivity.class));
                    // ура! пасхалка!
                    Toast.makeText(CheckerActivity.this, "Well, you found it. Congratulations!", Toast.LENGTH_SHORT).show();
                } else {
                    // обычный текст
                    textView.setText(text);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }


    public void startMainActivity(View view) {
        startActivity(new Intent(CheckerActivity.this, MainActivity.class));
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(CheckerActivity.this, MainActivity.class));

        } else if (id == R.id.nav_checker) {

            startActivity(new Intent(CheckerActivity.this, CheckerActivity.class));


        } else if (id == R.id.nav_info) {
            startActivity(new Intent(CheckerActivity.this, VersionActivity.class));

        } else if (id == R.id.nav_device) {
            startActivity(new Intent(CheckerActivity.this, DeviceActivity.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
