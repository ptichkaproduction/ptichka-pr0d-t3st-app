package com.pti4ka.ballo0n.balloon;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
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
    private String secretCode = "perryBallo0n";


    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String NICKNAME_KEY = "nickname";




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
                    // ура, пасхалка
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

    private void showNicknameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("TYPE YOUR NICKNAME HERE:");

        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String nickname = input.getText().toString();

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(NICKNAME_KEY, nickname);
                editor.apply();

            }
        });

        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alert.show();
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
        } else if (id == R.id.nav_exit) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(CheckerActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(CheckerActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finishAffinity();
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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(CheckerActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(CheckerActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finishAffinity();
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

        } else if (id == R.id.editNickname) {
            showNicknameDialog();
        }


        return super.onOptionsItemSelected(item);
    }
}
